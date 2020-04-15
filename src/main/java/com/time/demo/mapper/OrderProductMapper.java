package com.time.demo.mapper;

import com.time.demo.entity.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单商品底层接口
 *
 * @author time
 */
@Mapper
public interface OrderProductMapper {

    /**
     * 批量添加订单商品
     *
     * @param productList 商品集合
     * @return 是否成功
     */
    int insertProductList(List<OrderProduct> productList);

    /**
     * 批量修改订单商品
     *
     * @param productList 商品集合
     * @return 是否成功
     */
    int updateProductList(List<OrderProduct> productList);

    /**
     * 批量删除订单商品
     *
     * @param orderId 商品集合
     * @return 是否成功
     */
    int deleteProductList(Integer orderId);
}