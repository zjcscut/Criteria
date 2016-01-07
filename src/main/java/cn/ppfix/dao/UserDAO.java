package cn.ppfix.dao;

import cn.ppfix.entity.User;
import cn.ppfix.entity.UserDTO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
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


    //指定返回的实体类类型 User(id,name)
    public List<UserDTO> getDTO() {
//        Criteria cr =getCurrentSession().createCriteria(User.class,"user");
//        ProjectionList projectionList = Projections.projectionList();
//        projectionList.add(Projections.property("user.id").as("id")).
//                add(Projections.property("user.name").as("name"));
//        //转变bean
//        cr.setResultTransformer(Transformers.aliasToBean(User.class));
//        List<User> list = cr.list();
//        System.out.println(list);
//        return list;

        /**
         * 这里的hql 前面的用来做接收list数据实体类(DTO)如果不是映射的实体类必须带上包名
         */
//        String hql = "select new cn.ppfix.entity.UserDTO(s.id,s.name) from User s where s.id > 0";
//        Query query = getCurrentSession().createQuery(hql);
//        List<UserDTO> list = query.list();
//        return list;


        /**
         * 可以通过原生sql查询再通过转换封装到一个新的备bean
         */
//        String sql = "select u.id,u.name from User u where u.id > 0";
//        Query query = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserDTO.class));
//        List<UserDTO> list = query.list();
//        return list;

        /**
         * 尝试以上方法能不能自动匹配装载
         * 结果：不能，缺少装配参数
         */
        String sql = "select u.id,u.name from User u where u.id > 0";
        Query query = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserDTO.class));
        List<UserDTO> list = query.list();
        return list;
    }


    public List<User> test1() {
        String hql = " from User model where model.id > 0";
        Query query = getCurrentSession().createQuery(hql);
        List<User> list = query.list();
        return list;
    }


    public List<User> test2() {
        String hql = "select  new User(id,name) from User model where model.id > 0";
        Query query = getCurrentSession().createQuery(hql);
        List<User> list = query.list();
        return list;
    }
}
