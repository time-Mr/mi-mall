package com.time.demo.service;

import com.time.demo.entity.Product;
import com.time.demo.mapper.ColorMapper;
import com.time.demo.mapper.ConfMapper;
import com.time.demo.mapper.MealMapper;
import com.time.demo.mapper.ProductMapper;
import com.time.demo.util.VerdictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 商品逻辑实现
 *
 * @author time
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ColorMapper colorMapper;

    @Autowired
    private ConfMapper confMapper;

    @Autowired
    private MealMapper mealMapper;

    @Override
    public Product selectByPrimaryKey(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectAll(Map<String, Object> map) {
        return productMapper.selectAll(map);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAllToExcel();
    }

    @Override
    public Product selectByProductName(String productName) {
        return productMapper.selectByProductName(productName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertProduct(Product product) {
        if (productMapper.insertProduct(product) > 0) {
            product.getConf().forEach((conf) -> conf.setProductId(product.getProId()));
            product.getColor().forEach((color) -> color.setProductId(product.getProId()));
            product.getMeal().forEach((meal) -> meal.setProductId(product.getProId()));
        }
        return VerdictUtil.returnInt(mealMapper.insertMealList(product.getMeal()) > 0 && colorMapper.insertColorList(product.getColor()) > 0
                && confMapper.insertConfList(product.getConf()) > 0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProduct(Product product) {
        if (productMapper.updateProduct(product) > 0) {
            product.getConf().forEach((conf) -> conf.setProductId(product.getProId()));
            product.getColor().forEach((color) -> color.setProductId(product.getProId()));
            product.getMeal().forEach((meal) -> meal.setProductId(product.getProId()));
        }
        return VerdictUtil.returnInt(mealMapper.updateMealList(product.getMeal()) > 0 && colorMapper.updateColorList(product.getColor()) > 0
                && confMapper.updateConfList(product.getConf()) > 0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer proId) {
        if (mealMapper.deleteMealList(proId) > 0 && colorMapper.deleteColorList(proId) > 0
                && confMapper.deleteConfList(proId) > 0) {
            return productMapper.deleteByPrimaryKey(proId);
        }
        return 0;
    }

    @Override
    public int selectTotalCount() {
        return productMapper.selectTotalCount();
    }

    @Override
    public List<Product> selectToOrderBy() {
        AtomicInteger i = new AtomicInteger(1);
        List<Product> productList = productMapper.selectToOrderBy();
        productList.forEach(product -> product.setProId(i.getAndIncrement()));
        return productList;
    }

}
