package org.spring.mvc.serviceImpl;

import org.spring.mvc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-06-25 11:38
 */
@Service
public class UserServiceImpl implements UserService {

    public String sayHello(String loginName){
        return "Hello," + loginName;
    }
}