/*
 * Copyright (c) 2012-2015 zjc@ppfix.cn
 * May you do good and not evil.
 * May you find forgiveness for yourself and forgive others.
 * May you share freely,never taking more than you give.
 * Please do not del these words when you share or copy this file
 */

package cn.ppfix;

import cn.ppfix.dao.UserDAO;
import cn.ppfix.entity.User;
import cn.ppfix.entity.UserDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2016/1/7-16:26
 */
public class TestScope extends  BasicTest{

    @Autowired
    private UserDAO userDAO;

    @Test
    public void TestDTO(){
       List<UserDTO> list = userDAO.getDTO();
        System.out.println("list: " +list);
    }

    @Test
    public void TestVo(){
        List<User> list = userDAO.test1();
        System.out.println("list: " +list);
    }

    @Test
    public void TestVo2(){
        List<User> list = userDAO.test2();
        System.out.println("list: " +list);
    }

    @Test
    public void TestVo3(){
        List<UserDTO> list = userDAO.test3();
        System.out.println("list: " +list);
    }
}
