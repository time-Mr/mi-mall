package com.time.demo.controller;

import com.time.demo.entity.Order;
import com.time.demo.service.OrderService;
import com.time.demo.util.RegularExpressionUtil;
import com.time.demo.util.VerdictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单控制层
 *
 * @author time
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据主键删除订单
     *
     * @param orderId 传入的主键
     * @return 是否成功
     */
    @CrossOrigin
    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Integer orderId) {
        return orderService.deleteByPrimaryKey(orderId);
    }

    /**
     * 根据主键查询订单
     *
     * @param orderId 查询的主键
     * @return 结果集
     */
    @CrossOrigin
    @RequestMapping("/selectByPrimaryKey")
    public Order selectByPrimaryKey(Integer orderId) {
        return orderService.selectByPrimaryKey(orderId);
    }

    /**
     * 添加订单
     *
     * @param order 添加的对象
     * @return 是否成功
     */
    @RequestMapping(value = "/insertOrder")
    public int insertOrder(HttpServletResponse response, @RequestBody Order order) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        order.setCreateTime(new Date());
        order.setOrderNumber(RegularExpressionUtil.getOrderNumber());
        return orderService.insertSelective(order);
    }

    /**
     * 根据用户名查询订单，模糊查询
     *
     * @param response    响应对象
     * @param userName    查询对象
     * @param orderNumber 订单号
     * @param product     商品
     * @return 结果集
     */
    @RequestMapping("/selectByUsername")
    public List<Order> selectByUsername(HttpServletResponse response, String userName, Integer orderNumber,
                                        String product) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> map = new HashMap<>(3);
        map.put("userName", userName);
        map.put("orderNumber", orderNumber);
        map.put("product", product);
        return orderService.selectByUserName(map);
    }

    /**
     * 修改订单
     *
     * @param response 响应对象
     * @param order    添加对象
     * @return 是否成功
     */
    @CrossOrigin
    @RequestMapping("/updateOrder")
    public int updateOrder(HttpServletResponse response, @RequestBody Order order) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return orderService.updateByPrimaryKeySelective(order);
    }

    /**
     * 查询全部订单并分页，模糊查询
     *
     * @param response    响应对象
     * @param start       开始页
     * @param number      条数
     * @param owner       所属人
     * @param consign     收货人
     * @param orderNumber 订单号
     * @return 结果集
     */
    @RequestMapping("/selectAll")
    public List<Order> selectAll(HttpServletResponse response, Integer start, Integer number
            , String owner, String consign, String orderNumber
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, Object> hashMap = new HashMap<>(5);
        hashMap.put("start", VerdictUtil.isNullString(start));
        hashMap.put("number", VerdictUtil.isNullString(number));
        hashMap.put("owner", VerdictUtil.isNullString(owner));
        hashMap.put("consign", VerdictUtil.isNullString(consign));
        hashMap.put("orderNumber", VerdictUtil.isNullString(orderNumber));
        return orderService.selectAll(hashMap);
    }

    /**
     * 查询订单总数
     *
     * @param response 响应对象
     * @return 总数
     */
    @RequestMapping("/selectTotalCount")
    public int selectTotalCount(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return orderService.selectTotalCount();
    }

}
