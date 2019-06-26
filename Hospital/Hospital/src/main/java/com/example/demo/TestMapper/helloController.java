package com.example.demo.TestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @Autowired
    private UserMapper userMapper;

    @Rollback(false)
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {

        com.example.demo.TestMapper.User u = userMapper.findByName(userName);
        System.out.println(u);
        return u;
    }

    @RequestMapping(value = "/hello")
    public  String helloworld(){
        return "helloworld";
    }
}
