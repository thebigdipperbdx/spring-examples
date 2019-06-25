package org.spring.mvc.service;

import javax.jws.WebService;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-06-25 11:38
 */
@WebService
public interface UserService {
    String sayHello(String name);
}