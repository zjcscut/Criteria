package cn.ppfix.controller;

import cn.ppfix.dao.DepartmentDAO;
import cn.ppfix.dao.EmployeeDAO;
import cn.ppfix.entity.Department;
import cn.ppfix.entity.Employee;
import cn.ppfix.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/18-1:11
 */
@Controller
public class Test {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @RequestMapping(value = "/test/getAllEmployee")
    @ResponseBody
    public String getAllEmployee() {
        List<Employee> list = employeeDAO.getAllEmployee();
        System.out.println(list);
        return Json.toJson(list);
    }

    @RequestMapping(value = "/test/getAllDepartment")
    @ResponseBody
    public String getAllDepartment() {
        List<Department> list = departmentDAO.getAllDepartment();
        System.out.println(list);
        return Json.toJson(list);
    }
}
