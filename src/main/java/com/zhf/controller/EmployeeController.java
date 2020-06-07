package com.zhf.controller;

import com.zhf.dao.DepartmentDao;
import com.zhf.dao.EmployeeDao;
import com.zhf.entities.Department;
import com.zhf.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        System.out.println("员工添加");
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emps/add";
    }

    @PostMapping("/emp")
    public String addEmp(Model model,Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//    来到修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
//        System.out.println(id);
        return "emps/add";
    }

    @PutMapping("/emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
//        System.out.println(id);
        return "redirect:/emps";
    }

    @PostMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
