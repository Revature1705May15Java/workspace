package com.ex.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ParentBean implements BeanNameAware,
BeanFactoryAware,
InitializingBean,
DisposableBean
{
	private String secret;
	private String beanName;

	public String getSecret() {
		return secret;
	}

	public ParentBean() {
		super();
		System.out.println("Instantiate: ParentBean");
	}

	public void setSecret(String secret) {
		this.secret = secret;
		System.out.println("Populating property: 'secret'");
	}

	public void setBeanName(String beanName) {
		System.out.println("Bean's name is: " +beanName);
		this.beanName = beanName;
	}

	public void setBeanFactory(BeanFactory womb) 
			throws BeansException {
		System.out.println("Bean made by Factory: " + womb);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("After " + beanName + "'s properties set.");
	}

	public void myCustomInitializationMethod(){
		System.out.println("Calling my custom init for " + beanName);
	}

	public void destroy() throws Exception {
		System.out.println("Disposing bean: " + beanName);
	}

	public void customDestroyMethod(){
		System.out.println("Actually destroying bean: " +beanName);
	}


}
