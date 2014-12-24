package com.ypg.merchant.services.actionframework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import com.ypg.merchant.services.action.Action;
import com.ypg.merchant.services.action.ActionResult;


public abstract class AbstractActionController implements ActionController {
	private Map<Class<Action>,ActionMethodInvoker> handleRegistry = new HashMap<Class<Action>,ActionMethodInvoker>();

	@PostConstruct
	public void init()  {

		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
		provider.addIncludeFilter(new AssignableTypeFilter(ActionExecutor.class));

		// scan in org.example.package
		Set<BeanDefinition> components = provider.findCandidateComponents(this.getClass().getPackage().getName());
		for (BeanDefinition component : components){
			try {
				Class foundClass = Class.forName(component.getBeanClassName());

				if (ActionExecutor.class.isAssignableFrom(foundClass)){
					System.out.print("Found ActionExecutor:");
					//It should have default Constructor
					Object foundClassInstance = foundClass.newInstance();

					Method[] methods = foundClass.getMethods();
					for (Method method:methods){
						ActionHandle actonHandle = method.getAnnotation(ActionHandle.class);
						if (actonHandle!=null){
							Class[] classez = actonHandle.value();
							for (Class clasz:classez)
								if ( Action.class.isAssignableFrom(clasz)){

									ActionMethodInvoker actionCtrlInvoker = new ActionMethodInvoker(foundClassInstance,method);
									this.addRegistry(clasz,actionCtrlInvoker);
								}	


						}

					}
				}

				else System.out.print("Found:");
				System.out.println(foundClass.getName());
			}  catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			// use class cls found
		}
		this.onCreate();

	}

	@PreDestroy
	public void cleanup(){
		this.onRemove();
	}

	private void addRegistry(Class<Action> clasz, ActionMethodInvoker actionMethodInvoker){
		handleRegistry.put(clasz, actionMethodInvoker);
	}


	public ActionResult doAction(Action action,Object... args) throws InvalidActionMethodException{
		ActionMethodInvoker actionMethodInvoker = handleRegistry.get(action.getClass());
		if (actionMethodInvoker==null) throw new InvalidActionMethodException("No ActionHandle found for "+action.getClass());
		
		Method method = actionMethodInvoker.getMethod();
		// Make sure the method is accessible (JDK bug ?)
		method.setAccessible(true);
		try {
			Class[] methodParams = method.getParameterTypes();
			if (methodParams.length < 1)
				throw new InvalidActionMethodException(method.getName()+" has no Action Parameter");
			if (methodParams.length -1 >5)
				throw new InvalidActionMethodException("method "+method.getName()+" only support upto 5 extra Parameters");			
			//Parameter 0 is type of Acton
			Class methodParamClasz0 = methodParams[0];
			if (!Action.class.isAssignableFrom(methodParamClasz0))  
				throw new InvalidActionMethodException(method.getName()+" has invalid Parameter ("+methodParamClasz0.getSimpleName()+")");		        


			//Parameter 1...n
			if (methodParams.length >=2){
				Object[] valueParamObjs = new Object[methodParams.length];
				for (int k=1;k<methodParams.length;k++){
					Class methodParamClasz = methodParams[k];
					//Any parameter Object passed in?
					if ((args!=null)&&(k<= args.length)){
						Object inParamObj = args[k-1];
						if (inParamObj!=null){
							if (methodParamClasz.isAssignableFrom(inParamObj.getClass()))
								valueParamObjs[k] = inParamObj;
							else 
								throw new InvalidActionMethodException(inParamObj.getClass()+" is not valud Parameter type of " + methodParamClasz );		    	

						}							
						else
							valueParamObjs[k]=null;
					}else
						valueParamObjs[k]=null;
				}
				
				/*
				Object argObj1 =null;
				Class methodParamClasz1 = methodParams[1];
				if (ActionController.class.isAssignableFrom(methodParamClasz1))
					//Any value passed as parameter?
					if ((args!=null) && (args.length>=1)){
						argObj1 = args[0];
						if (!ActionController.class.isAssignableFrom(argObj1.getClass()))
							throw new InvalidActionMethodException(argObj1.getClass()+" is not valud Parameter type of " + ActionController.class );		    	
					}
					*/
				//To improve
				Class<?> returnType = method.getReturnType();
				if (!ActionResult.class.isAssignableFrom(returnType)) 
					throw new InvalidActionMethodException(returnType.getClass()+" is not valud return type of " + method.getName() );
				/*
				switch (methodParams.length-1) {
				  case 1: return (ActionResult) method.invoke(actionMethodInvoker.getHostObj(),action,valueParamObjs[0]);
				  case 2 :return (ActionResult)method.invoke(actionMethodInvoker.getHostObj(),action,valueParamObjs[0],valueParamObjs[1]);
				  case 3 :return (ActionResult)method.invoke(actionMethodInvoker.getHostObj(),action,valueParamObjs[0],valueParamObjs[1],valueParamObjs[2]);
				  case 4 :return (ActionResult)method.invoke(actionMethodInvoker.getHostObj(),action,valueParamObjs[0],valueParamObjs[1],valueParamObjs[2],valueParamObjs[3]);
				  case 5 :return (ActionResult)method.invoke(actionMethodInvoker.getHostObj(),action,valueParamObjs[0],valueParamObjs[1],valueParamObjs[2],valueParamObjs[3],valueParamObjs[4]);
				}*/
				valueParamObjs[0]=action;
				return (ActionResult)method.invoke(actionMethodInvoker.getHostObj(),valueParamObjs);
						    
			}else
				return  (ActionResult)method.invoke(actionMethodInvoker.getHostObj(),action);
			//actionMethodInvoker.invoke(action);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
			throw new InvalidActionMethodException("Error",e);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new InvalidActionMethodException("Error",e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new InvalidActionMethodException("Error",e);
		}

	}
}
