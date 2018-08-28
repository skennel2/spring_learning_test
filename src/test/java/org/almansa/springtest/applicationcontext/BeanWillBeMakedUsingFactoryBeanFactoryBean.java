package org.almansa.springtest.applicationcontext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BeanWillBeMakedUsingFactoryBeanFactoryBean implements FactoryBean<BeanWillBeMakedUsingFactoryBean> {

    @Override
    public BeanWillBeMakedUsingFactoryBean getObject() throws Exception {
        return new BeanWillBeMakedUsingFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanWillBeMakedUsingFactoryBean.class;
    }

}