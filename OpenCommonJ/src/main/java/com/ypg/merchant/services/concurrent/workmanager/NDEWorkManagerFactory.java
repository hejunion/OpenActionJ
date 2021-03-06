/**
 * #(@) FooWorkManagerFactory.java Aug 15, 2006
 */
package com.ypg.merchant.services.concurrent.workmanager;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;

import com.ypg.merchant.services.concurrent.workmanager.ext.JDKThreadPool;
import com.ypg.merchant.services.concurrent.workmanager.impl.nde.NDEWorkManagerImpl;

import commonj.work.WorkManager;



/**
 * Factory class for <code>WorkManager</code>s. 
 *
 */
public final class NDEWorkManagerFactory extends AbstractFactory {
	
	/**
	 * Factory method that returns an instance of the requested 
	 * WorkManager.
	 * 
	 * @param obj The possibly <code>null</code> object containing location or 
	 * 				reference information that can be used in creating an 
	 * 				object.
	 * @param name The name of this object relative to <code>nameCtx</code>,
	 *				or <code>null</code> if no name is specified.
	 * @param nameCtx The context relative to which the <code>name</code> 
	 * 				parameter is specified, or <code>null</code> if 
	 * 				<code>name</code> is relative to the default initial 
	 * 				context.
	 * @param environment The possibly <code>null</code> environment that is #
	 * 				used in creating the object.
	 * @return The requested WorkManager
	 * @throws Exception if this object factory encountered an exception while 
	 * 				attempting to create an object, and no other object 
	 * 				factories are to be tried.
	 */
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, 
			Hashtable environment) throws Exception {
		
		// get work manager from map
		NDEWorkManagerImpl workManager = (NDEWorkManagerImpl) managers.get(name);
		if (workManager == null) {
			// lazy inititalization
		    int minThreads = 2; 
		    int maxThreads = 10;
		    int queueLength = 10;
		    int maxDaemons = 10;
		    
		    // get config values
		    Reference ref = (Reference) obj;
		    Enumeration addrs = ref.getAll();
		    while (addrs.hasMoreElements()) {
		    	RefAddr addr = (RefAddr) addrs.nextElement();
		    	String addrName = addr.getType();
		    	String addrValue = (String) addr.getContent();
		        
		    	if (addrName.equals(CONFIG_MAX_THREADS)) {
		    		maxThreads = getValue(addrName, addrValue);
		    	}
		    	else if (addrName.equals(CONFIG_MIN_THREADS)) {
		    		minThreads = getValue(addrName, addrValue);
		        }
		    	else if (addrName.equals(CONFIG_QUEUE_LENGTH)) {
		    		queueLength = getValue(addrName, addrValue);
		        }
		    	else if (addrName.equals("maxDaemons")) {
		    		maxDaemons = getValue(addrName, addrValue);
		        }
		    }
		    
		    // more sanity checks on config values
		    if (minThreads < 1) {
		    	throw new NamingException("minThreads can not be < 1.");
		    }
		    if (minThreads >= maxThreads) {
		    	throw new NamingException("minThreads can not be >= maxThreads.");
		    }
		    
		    // create the thread pool for this work manager
		    JDKThreadPool pool = new JDKThreadPool(minThreads, maxThreads, queueLength);
		    
		    // create the work manager
		    workManager = new NDEWorkManagerImpl(pool, maxDaemons);
		    managers.put(name, workManager);
		}
		
		return (WorkManager) workManager;
	}

}
