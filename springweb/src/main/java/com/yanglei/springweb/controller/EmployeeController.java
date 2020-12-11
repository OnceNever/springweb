package com.yanglei.springweb.controller;

import com.yanglei.springweb.dao.EmployeeDao;
import com.yanglei.springweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao dao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = dao.getAll();
        model.addAttribute("emps", employees);
        return "list";
    }
}
