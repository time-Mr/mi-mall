package com.time.demo.service;

import com.time.demo.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * 订单逻辑接口
 *
 * @author time
 */
public interface OrderService {

    /**
     * 根据主键删除订单
     *
     * @param orderId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * 添加订单
     *
     * @param order 订单对象
     * @return 是否成功
     */
    int insertSelective(Order order);

    /**
     * 根据主键查询订单
     *
     * @param orderId 主键
     * @return 结果集
     */
    Order selectByPrimaryKey(Integer orderId);

    /**
     * 修改订单
     *
     * @param order 订单对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(Order order);

    /**
     * 根据用户名查询订单
     *
     * @param map 用户名
     * @return 结果集
     */
    List<Order> selectByUserName(Map<String, Object> map);

    /**
     * 查询全部订单并分页，模糊查询
     *
     * @param map 条件键值对
     * @return 结果集
     */
    List<Order> selectAll(Map<String, Object> map);

    /**
     * 查询订单总数
     *
     * @return 总数
     */
    int selectTotalCount();

    /**
     * 查询全部订单
     *
     * @return 结果集
     */
    List<Order> selectAll();

}
