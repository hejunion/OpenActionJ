package com.ypg.merchant.services.controller.video;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.ypg.merchant.services.actionframework.profile.ProfilePostExecutionAdvice;
import com.ypg.merchant.services.actionframework.profile.ProfilePostExecutionAdvisor;

@Configuration
@ComponentScan
public class VideoActionControllerConfiguration {
	
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        final DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
    
    @Bean
    public ProfilePostExecutionAdvice profilePostExecutionAdvice(){
    	return new ProfilePostExecutionAdvice();
    }
    
    @Bean
	@DependsOn("defaultAdvisorAutoProxyCreator")
    public ProfilePostExecutionAdvisor profilePostExecutionAdvisor(){
    	return new ProfilePostExecutionAdvisor();
    }
    
    
	@Bean  
	@DependsOn("defaultAdvisorAutoProxyCreator")
	public VideoActionController videoActionController(){
		return new VideoActionController();
	}
	

}
