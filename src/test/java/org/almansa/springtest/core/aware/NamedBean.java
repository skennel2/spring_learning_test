package org.almansa.springtest.core.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component(value = "Named Bean")
public class NamedBean implements BeanNameAware {

	private String beanName;
	
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public String getBeanName() {
		return beanName;
	}
}
