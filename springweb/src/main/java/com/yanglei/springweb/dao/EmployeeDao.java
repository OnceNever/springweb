package com.yanglei.springweb.dao;

import com.yanglei.springweb.pojo.Department;
import com.yanglei.springweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(10001, new Employee(10001, "AA", "A123456@qq.com", 0, new Department(101, "后勤部")));
        employees.put(10002, new Employee(10002, "BB", "B123456@qq.com", 1, new Department(102, "营销部")));
        employees.put(10003, new Employee(10003, "CC", "C123456@qq.com", 1, new Department(103, "教学部")));
        employees.put(10004, new Employee(10004, "DD", "D123456@qq.com", 0, new Department(104, "文艺部")));
        employees.put(10005, new Employee(10005, "EE", "E123456@qq.com", 1, new Department(105, "宣传部")));
    }

    //主键自增
    private static Integer  initId = 10086;

    //添加员工
    public void save(Employee employee){
        if(employee.getId() == null)employee.setId(initId++);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询所有员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //根据id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
