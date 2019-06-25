package org.spring.mvc;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.spring.mvc.service.UserService;

/**
 * @author yanyugang
 * @description WSDL文档地址：http://localhost:8081/service/userService?wsdl
 * @date 2019-06-25 11:46
 */
public class TestWebService {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(UserService.class);
        factoryBean.setAddress("http://localhost:8081/service/userService");

        UserService userService = (UserService)factoryBean.create();
        String str= userService.sayHello("tianming");
        System.out.println("str==="+str);
    }
}
