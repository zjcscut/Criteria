package cn.ppfix.dao;

import cn.ppfix.entity.Department;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/18-1:05
 */
@Repository
public class DepartmentDAO  extends SessionFactoryHelper{

    @Transactional
    public List<Department> getAllDepartment(){
        Criteria deCriteria = getCurrentSession().createCriteria(Department.class);
        List<Department> list = deCriteria.list();
        return  list;
    }


}
