package com.ex.annotatedbeans;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.ex.beanlifecycle.ParentBean;
import com.ex.beanlifecycle.ProcessorBean;

public class BasicExampleConfigClass {


	private ParentBean jon;
	private ProcessorBean bppb;
	
	@Bean(initMethod="myCustomInitializationMethod",
			destroyMethod="customDestroyMethod", 
			autowire=Autowire.NO)
	@Scope("singleton")
	public ParentBean jon(){
		return new ParentBean();
	}
	@Bean
	public ProcessorBean bppb(){
		return new ProcessorBean();
	}

}
