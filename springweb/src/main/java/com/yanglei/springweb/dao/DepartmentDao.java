package com.yanglei.springweb.dao;

import com.yanglei.springweb.pojo.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "后勤部"));
        departments.put(102, new Department(102, "营销部"));
        departments.put(103, new Department(103, "教学部"));
        departments.put(104, new Department(104, "文艺部"));
        departments.put(105, new Department(105, "宣传部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
