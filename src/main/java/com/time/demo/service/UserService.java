package com.time.demo.service;

import com.time.demo.entity.ShoppingCard;
import com.time.demo.entity.User;

import java.util.List;
import java.util.Map;


/**
 * 用户逻辑接口
 *
 * @author time
 */
public interface UserService {

    /**
     * 删除指定用户
     *
     * @param username 用户名
     * @return 是否成功
     */
    int deleteByUserName(String username);

    /**
     * 用户注册
     *
     * @param user 用户对象
     * @return 是否成功
     */
    int insertSelective(User user);

    /**
     * 查询用户
     *
     * @param user 用户对象
     * @return 结果集
     */
    Object selectUser(User user);

    /**
     * 根据主键查询查询
     *
     * @param userId 主键
     * @return 结果集
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 带条件查询并分页，模糊查询
     *
     * @param map 条件键值对
     * @return 结果集
     */
    List<User> selectAllUser(Map<String, Object> map);

    /**
     * 查询全部
     *
     * @return 结果集
     */
    List<User> selectAllUser();

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 用户加购
     *
     * @param shoppingCard 购物车对象
     * @return 是否成功
     * @throws Exception 异常
     */
    int addShoppingCart(ShoppingCard shoppingCard) throws Exception;

    /**
     * 用户获取购物车
     *
     * @param name 用户名
     * @return 结果集
     */
    List<Object> getShoppingCart(String name);

    /**
     * 用户删除购物车
     *
     * @param key 用户名
     * @return 是否成功
     */
    int deleteShoppingCard(String key);

    /**
     * 查询用户总数
     *
     * @return 总数
     */
    int selectTotalCount();

}
