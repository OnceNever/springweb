package com.yanglei.springshiro;

import com.yanglei.springshiro.entity.User;
import com.yanglei.springshiro.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringshiroApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        User user = userService.queryByName("admin");
        System.out.println(user);
    }

}
