package com.time.demo.controller;

import com.time.demo.entity.Admin;
import com.time.demo.service.AdminService;
import com.time.demo.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 管理员控制层
 *
 * @author time
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UploadUtil uploadUtil;

    /**
     * 管理员注册
     *
     * @param response 响应对象
     * @param admin    注册对象
     * @return 是否注册成功
     */
    @RequestMapping("/register")
    public int register(HttpServletResponse response, Admin admin) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return adminService.insertSelective(admin);
    }

    /**
     * 管理员登录
     *
     * @param response 响应对象
     * @param admin    登录对象
     * @return 是否登录成功
     */
    @RequestMapping("/login")
    public int login(HttpServletResponse response, Admin admin) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        admin.setLoginDate(new Date());
        return adminService.login(admin);
    }

    /**
     * 管理员修改
     *
     * @param response 响应对象
     * @param admin    修改对象
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    public int update(HttpServletResponse response, Admin admin) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return adminService.updateByPrimaryKeySelective(admin);
    }

    /**
     * 上传头像
     *
     * @param response       响应对象
     * @param multipartFile1 头像对象
     * @return 是否成功上传
     */
    @RequestMapping("/upload")
    public String upload(HttpServletResponse response, @RequestParam(value = "file") MultipartFile multipartFile1) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return uploadUtil.upload(multipartFile1);
    }

    @RequestMapping("/selectByName")
    public Admin selectByName(HttpServletResponse response, String name) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return adminService.selectByName(name);
    }

    @RequestMapping("/selectAdminDate")
    public List<Admin> selectAdminDate(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return adminService.selectAdminDate();
    }
}
