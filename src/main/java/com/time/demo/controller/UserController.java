package com.time.demo.controller;

import com.time.demo.entity.ShoppingCard;
import com.time.demo.entity.User;
import com.time.demo.service.UserService;
import com.time.demo.util.MD5Util;
import com.time.demo.util.VerdictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 用户控制层
 *
 * @author time
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param response 响应对象
     * @return 是否成功
     */
    @RequestMapping("/register")
    public int insertUser(HttpServletResponse response, User user) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        user.setPassWord(MD5Util.md5(user.getPassWord()));
        return userService.insertSelective(user);
    }

    /**
     * 用户登录
     *
     * @param response 响应对象
     * @param user     用户对象
     * @return 是否成功
     */
    @RequestMapping("/login")
    public Object selectUser(HttpServletResponse response, User user) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        user.setPassWord(MD5Util.md5(user.getPassWord()));
        return userService.selectUser(user);

    }

    /**
     * 根据主键查询
     *
     * @param response 响应对象
     * @param userId   主键
     * @return 结果集
     */
    @RequestMapping("/selectByPrimaryKey")
    public User selectByPrimaryKey(HttpServletResponse response, Integer userId) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return userService.selectByPrimaryKey(userId);
    }

    /**
     * 查询全部用户并分页
     *
     * @param response 响应对象
     * @param start    起始页
     * @param number   查询条数
     * @param nickName 昵称
     * @param userName 用户名
     * @return 结果集
     */
    @RequestMapping("/selectAllUser")
    public List<User> selectAllUser(HttpServletResponse response, Integer start, Integer number
            , String nickName, String userName
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, Object> hashMap = new HashMap<>(4);
        hashMap.put("start", VerdictUtil.isNullString(start));
        hashMap.put("number", VerdictUtil.isNullString(number));
        hashMap.put("userName", VerdictUtil.isNullString(userName));
        hashMap.put("nickName", VerdictUtil.isNullString(nickName));
        return userService.selectAllUser(hashMap);
    }

    /**
     * 修改用户
     *
     * @param response 响应对象
     * @param user     修改对象
     * @return 是否成功
     */
    @RequestMapping("/updateUser")
    public int updateUser(HttpServletResponse response, User user) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return userService.updateByPrimaryKeySelective(user);
    }


    /**
     * 删除用户
     *
     * @param response 响应对象
     * @param userName 用户名
     * @return 是否成功
     */
    @RequestMapping("/deleteUser")
    public int deleteUser(HttpServletResponse response, String userName) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return userService.deleteByUserName(userName);
    }

    /**
     * 查询所有用户数
     *
     * @param response 响应对象
     * @return 结果集
     */
    @RequestMapping("/selectTotalCount")
    public int selectTotalCount(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return userService.selectTotalCount();
    }

    /**
     * 加入购物车
     *
     * @param response     响应对象
     * @param shoppingCard 购物车对象
     * @return 是否成功
     * @throws Exception 异常
     */
    @RequestMapping("/addShoppingCart")
    public int addShoppingCart(HttpServletResponse response, ShoppingCard shoppingCard)
            throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        shoppingCard.setQuantity(1);
        return userService.addShoppingCart(shoppingCard);
    }

    /**
     * 获取购物车
     *
     * @param response 响应对象
     * @param name     用户名
     * @return 结果集
     */
    @RequestMapping("/getShoppingCard")
    public List<Object> getShoppingCard(HttpServletResponse response, String name) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return userService.getShoppingCart(name);
    }

    /**
     * 删除购物车
     *
     * @param response 响应对象
     * @param key      用户名
     * @return 是否成功
     */
    @RequestMapping("/removeShoppingCard")
    public int removeShoppingCard(HttpServletResponse response, String key) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return userService.deleteShoppingCard(key);
    }

}
