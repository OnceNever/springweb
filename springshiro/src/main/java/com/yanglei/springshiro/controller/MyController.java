package com.yanglei.springshiro.controller;

import com.yanglei.springshiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg", "hello,shiro");
        return "index";
    }

    @RequestMapping("user/add")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("user/update")
    public String toUpdate(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();

        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //执行登录方法
            subject.login(token);
        } catch (UnknownAccountException e) {
            model.addAttribute("error", "该用户不存在！");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", "用户密码错误！");
            return "login";
        }
        return "index";
    }

    @RequestMapping("/noAuth")
    @ResponseBody
    public String noAuth(){
        return "未经授权无法访问此页面！";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
