package com.time.demo.mapper;

import com.time.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单底层接口
 *
 * @author time
 */
@Mapper
public interface OrderMapper {

    /**
     * 根据主键删除
     *
     * @param orderId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * 按条件添加
     *
     * @param order 订单商品对象
     * @return 结果集
     */
    int insertSelective(Order order);

    /**
     * 按主键查询
     *
     * @param orderId 主键
     * @return 结果集
     */
    Order selectByPrimaryKey(Integer orderId);

    /**
     * 按条件修改
     *
     * @param order 条件对象
     * @return 结果集
     */
    int updateByPrimaryKeySelective(Order order);

    /**
     * 按用户名查询
     *
     * @param map 条件对象
     * @return 结果集
     */
    List<Order> selectByUserName(Map<String, Object> map);

    /**
     * 按条件查询全部订单
     *
     * @param map 条件对象
     * @return 结果集
     */
    List<Order> selectAll(Map<String, Object> map);

    /**
     * 查询全部订单
     *
     * @return 结果集
     */
    List<Order> selectAll();

    /**
     * 查询订单总数
     *
     * @return 总数
     */
    int selectTotalCount();
}