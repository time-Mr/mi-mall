package com.time.demo.controller;

import com.time.demo.entity.Order;
import com.time.demo.entity.Product;
import com.time.demo.entity.User;
import com.time.demo.service.OrderService;
import com.time.demo.service.ProductService;
import com.time.demo.service.UserService;
import com.time.demo.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * 导出Excel控制层
 *
 * @author time
 */
@RestController
public class ExportExcelController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    private final String USER_SHEET = "用户表";
    private final String PRODUCT_SHEET = "商品表";
    private final String ORDER_SHEET = "订单表";

    /**
     * 导出Excel
     *
     * @param response 响应对象
     * @param sheet    表名
     * @return 是否成功
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response, String sheet) throws Exception {
        if (USER_SHEET.equals(sheet)) {
            ExcelUtil.getExcel(response, "用户表", userService.selectAllUser(), User.class);
            return "导出成功";
        } else if (PRODUCT_SHEET.equals(sheet)) {
            ExcelUtil.getExcel(response, "商品表", productService.selectAll(), Product.class);
            return "导出成功";
        } else if (ORDER_SHEET.equals(sheet)) {
            ExcelUtil.getExcel(response, "订单表", orderService.selectAll(), Order.class);
            return "导出成功";
        } else {
            return null;
        }
    }
}