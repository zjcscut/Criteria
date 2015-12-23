package cn.ppfix.dao;

import cn.ppfix.entity.Employee;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/18-1:06
 */
@Repository
public class EmployeeDAO extends SessionFactoryHelper {

    @Transactional
    public List<Employee> getAllEmployee() {
        Criteria emCriteria = getCurrentSession().createCriteria(Employee.class);
        List<Employee> list = emCriteria.list();
        return list;
    }
}
