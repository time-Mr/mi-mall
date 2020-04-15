package com.time.demo.controller;

import com.time.demo.entity.Like;
import com.time.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户喜欢的商品控制层
 *
 * @author time
 */
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    /**
     * 根据用户名查询
     *
     * @param response 响应对象
     * @param userName 指定的用户
     * @return 喜欢的商品结果集
     */
    @RequestMapping("/selectLikeProduct")
    public List<Like> selectLikeProduct(HttpServletResponse response, String userName) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return likeService.selectByUserName(userName);
    }
}
