package com.time.demo.controller;

import com.time.demo.entity.Product;
import com.time.demo.service.ProductService;
import com.time.demo.util.UploadUtil;
import com.time.demo.util.VerdictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 商品控制层
 *
 * @author time
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UploadUtil uploadUtil;

    /**
     * 查询全部商品并分页，模糊查询
     *
     * @param response 响应对象
     * @param start    开始索引
     * @param number   结束索引
     * @param proType  商品类型
     * @param proName  商品名称
     * @return 结果集
     */
    @RequestMapping("/selectAll")
    public List<Product> selectAll(HttpServletResponse response, Integer start, Integer number
            , String proType, String proName
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, Object> hashMap = new HashMap<>(4);
        hashMap.put("start", VerdictUtil.isNullString(start));
        hashMap.put("number", VerdictUtil.isNullString(number));
        hashMap.put("proType", VerdictUtil.isNullString(proType));
        hashMap.put("proName", VerdictUtil.isNullString(proName));
        return productService.selectAll(hashMap);
    }

    /**
     * 根据商品名称查询商品
     *
     * @param response    响应对象
     * @param productName 商品名称
     * @return 结果集
     */
    @RequestMapping("/selectByProductName")
    public Product selectByProductName(HttpServletResponse response, String productName) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.selectByProductName(productName);
    }

    /**
     * 根据主键查询商品
     *
     * @param response 响应对象
     * @param proId    主键
     * @return 结果集
     */
    @RequestMapping("/selectByPrimaryKey")
    public Product selectByPrimaryKey(HttpServletResponse response, Integer proId) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.selectByPrimaryKey(proId);
    }

    /**
     * 添加商品
     *
     * @param response 响应对象
     * @param product  商品对象
     * @return 是否成功
     */
    @RequestMapping(value = "/insertProduct")
    public int insertProduct(HttpServletResponse response, @RequestBody Product product) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.insertProduct(product);
    }

    /**
     * 删除商品
     *
     * @param response 响应对象
     * @param product  商品对象
     * @return 是否成功
     */
    @RequestMapping(value = "/deleteProduct")
    public int deleteProduct(HttpServletResponse response, Product product) {
        boolean flag = false;
        response.setHeader("Access-Control-Allow-Origin", "*");
        uploadUtil.deleteFile(product.getPicture1());
        uploadUtil.deleteFile(product.getPicture2());
        uploadUtil.deleteFile(product.getPicture3());
        return productService.deleteByPrimaryKey(product.getProId());
    }

    /**
     * 修改商品
     *
     * @param response 响应对象
     * @param product  商品对象
     * @return 结果集
     */
    @RequestMapping("/updateProduct")
    public int updateProduct(HttpServletResponse response, @RequestBody Product product) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.updateProduct(product);
    }

    /**
     * 上传商品图片
     *
     * @param response       响应对象
     * @param multipartFile1 图片对象
     * @return 是否成功
     */
    @RequestMapping("/upload")
    public String upload(HttpServletResponse response, @RequestParam(value = "file") MultipartFile multipartFile1) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return uploadUtil.upload(multipartFile1);
    }

    /**
     * 查询商品总数
     *
     * @param response 响应对象
     * @return 总数
     */
    @RequestMapping("/selectTotalCount")
    public int selectTotalCount(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.selectTotalCount();
    }

    @RequestMapping("/selectToOrderBy")
    public List<Product> selectToOrderBy(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.selectToOrderBy();
    }

    @RequestMapping("/deleteFile")
    public boolean deleteFile(HttpServletResponse response, String fileName) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return uploadUtil.deleteFile(fileName);
    }
}
