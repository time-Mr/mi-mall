package com.time.demo.service;

import com.time.demo.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * 商品逻辑接口
 *
 * @author time
 */
public interface ProductService {

    /**
     * 根据主键删除
     *
     * @param proId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer proId);

    /**
     * 添加商品
     *
     * @param product 商品对象
     * @return 是否成功
     */
    int insertProduct(Product product);

    /**
     * 修改商品
     *
     * @param product 商品对象
     * @return 是否成功
     */
    int updateProduct(Product product);

    /**
     * 查询全部商品并分页
     *
     * @param map 条件键值对
     * @return 结果集
     */
    List<Product> selectAll(Map<String, Object> map);

    /**
     * 查询全部商品
     *
     * @return 结果集
     */
    List<Product> selectAll();

    /**
     * 根据主键查询
     *
     * @param productId 主键
     * @return 结果集
     */
    Product selectByPrimaryKey(Integer productId);

    /**
     * 根据名字查询
     *
     * @param productName 名字
     * @return 结果集
     */
    Product selectByProductName(String productName);

    /**
     * 查询商品总数
     *
     * @return 总数
     */
    int selectTotalCount();

    /**
     * 查询商品部分信息并根据销量降序排序
     *
     * @return
     */
    List<Product> selectToOrderBy();
}
