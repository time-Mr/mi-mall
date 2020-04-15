package com.time.demo.service;

import com.time.demo.entity.Order;
import com.time.demo.entity.Product;
import com.time.demo.mapper.OrderMapper;
import com.time.demo.mapper.OrderProductMapper;
import com.time.demo.mapper.ProductMapper;
import com.time.demo.util.VerdictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 订单逻辑实现
 *
 * @author time
 */
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer orderId) {
        orderProductMapper.deleteProductList(orderId);
        return VerdictUtil.returnInt(orderMapper.deleteByPrimaryKey(orderId) > 0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Order order) {
        if (orderMapper.insertSelective(order) > 0 && VerdictUtil.isNotNull(order.getProductList())) {
            order.getProductList().forEach((orderProduct) -> {
                Product product = new Product();
                product.setName(orderProduct.getProductName());
                product.setSales(productMapper.selectTotality(orderProduct.getProductName()) + orderProduct.getProductNumber());
                productMapper.addSales(product);
            });
            order.getProductList().forEach((orderProduct) -> {
                orderProduct.setOrderId(order.getOrderId());
                orderProduct.setProductPicture(orderProduct.getProductPicture().substring(orderProduct.getProductPicture().lastIndexOf("/")));
            });
            return orderProductMapper.insertProductList(order.getProductList());
        }
        return 0;
    }

    @Override
    public Order selectByPrimaryKey(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order order) {
        if (orderMapper.updateByPrimaryKeySelective(order) > 0 && VerdictUtil.isNotNull(order.getProductList())) {
            order.getProductList().forEach((orderProduct) -> orderProduct.setOrderId(order.getOrderId()));
            return orderProductMapper.updateProductList(order.getProductList());
        }
        return 0;
    }

    @Override
    public List<Order> selectByUserName(Map<String, Object> map) {
        return orderMapper.selectByUserName(map);
    }

    @Override
    public List<Order> selectAll(Map<String, Object> map) {
        return orderMapper.selectAll(map);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public int selectTotalCount() {
        return orderMapper.selectTotalCount();
    }


}
