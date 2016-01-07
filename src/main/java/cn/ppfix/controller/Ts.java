package cn.ppfix.controller;

import cn.ppfix.dao.UserDAO;
import cn.ppfix.entity.User;
import cn.ppfix.entity.UserDTO;
import cn.ppfix.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/22-0:22
 */
@Controller
public class Ts {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "getByEQ")
    @ResponseBody
    public String getByEQ() {
        User user = userDAO.getByEq("zjc");
        return Json.toJson(user);
    }


    @RequestMapping(value = "getByLike")
    @ResponseBody
    public String getByLike() {
        List<User> lsit = userDAO.getByLike("z");
        return Json.toJson(lsit);
    }

    @RequestMapping(value = "getByIn")
    @ResponseBody
    public String getByIn() {
        List<User> lsit = userDAO.getByIn();
        return Json.toJson(lsit);
    }

    @RequestMapping(value = "getByNull")
    @ResponseBody
    public String getByNull() {
        List<User> lsit = userDAO.getByNull();
        return Json.toJson(lsit);
    }


    @RequestMapping(value = "getByOrder")
    @ResponseBody
    public String getByOrder() {
        List<User> lsit = userDAO.getByOrder();
        return Json.toJson(lsit);
    }

    @RequestMapping(value = "pageQuery")
    @ResponseBody
    public String pageQuery(@RequestParam(required = false, value = "page", defaultValue = "1") int page,
                            @RequestParam(required = false, value = "size", defaultValue = "2") int size) {
        List<User> lsit = userDAO.pageQuery(page, size);
        return Json.toJson(lsit);
    }

    @RequestMapping(value = "getDTO")
    @ResponseBody
    public String getDTO() {
        List<UserDTO> lsit = userDAO.getDTO();
        return Json.toJson(lsit);
    }
}
