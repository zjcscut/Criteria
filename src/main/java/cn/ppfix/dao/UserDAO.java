package cn.ppfix.dao;

import cn.ppfix.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/22-0:16
 */
@Repository
public class UserDAO extends SessionFactoryHelper {

    //相等于等号操作
    public User getByEq(String name) {
        Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.add(Restrictions.eq("name", name));
        List<User> list = cr.list();
        return list.get(0);
    }

    /**
     * 相当于like操作
     * MatchMode.START -> "likeStr%" 类似这样
     *
     * @param likeStr
     * @return
     */
    public List<User> getByLike(String likeStr) {
        Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.add(Restrictions.like("name", likeStr, MatchMode.START));
        List<User> list = cr.list();
        return list;
    }

    //相当于in操作
    public List<User> getByIn() {
        String[] likeStr = {"zjc", "tom"};
        Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.add(Restrictions.in("name", likeStr));
        List<User> list = cr.list();
        return list;
    }

    //年龄age等于22或age为空（null）
    public List<User> getByNull() {
        Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.add(Restrictions.or(Restrictions.isNull("age"), Restrictions.eq("age", 22)));
        List<User> list = cr.list();
        return list;
    }

    //排序
    public List<User> getByOrder() {
        Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.add(Restrictions.like("name", "z", MatchMode.START));
        cr.addOrder(Order.desc("age"));
        List<User> list = cr.list();
        return list;
    }

    //分页
    public List<User> pageQuery(int page, int size) {
        Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.setFirstResult((page - 1) * size);
        cr.setMaxResults(size);
        List<User> list = cr.list();
        return list;
    }
}
