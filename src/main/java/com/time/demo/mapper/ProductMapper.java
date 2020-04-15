package com.time.demo.mapper;

import com.time.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 商品底层接口
 *
 * @author time
 */
@Mapper
public interface ProductMapper {

    /**
     * 根据主键删除
     *
     * @param proId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer proId);

    /**
     * 查询全部商品并分页，模糊查询
     *
     * @param map 条件对象
     * @return 结果集
     */
    List<Product> selectAll(Map<String, Object> map);

    /**
     * 根据主键查询
     *
     * @param productId 主键
     * @return 结果集
     */
    Product selectByPrimaryKey(Integer productId);

    /**
     * 根据商品名字查询
     *
     * @param productName 商品名
     * @return 结果集
     */
    Product selectByProductName(String productName);

    /**
     * 修改商品信息
     *
     * @param product 商品对象
     * @return 是否成功
     */
    int updateProduct(Product product);

    /**
     * 添加商品
     *
     * @param product 商品对象
     * @return 是否成功
     */
    int insertProduct(Product product);

    /**
     * 查询商品总数
     *
     * @return 总数
     */
    int selectTotalCount();

    /**
     * 查询全部商品
     *
     * @return 结果集
     */
    List<Product> selectAllToExcel();

    /**
     * 修改商品销量
     *
     * @param product 商品对象
     * @return 是否修改成功
     */
    int addSales(Product product);

    /**
     * 查询商品库存
     *
     * @param name
     * @return
     */
    long selectTotality(String name);

    /**
     * 查询商品部分信息并根据销量降序排序
     *
     * @return
     */
    List<Product> selectToOrderBy();

}