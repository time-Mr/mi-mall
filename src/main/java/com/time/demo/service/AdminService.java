package com.time.demo.service;

import com.time.demo.entity.Admin;

import java.util.List;

/**
 * 管理员逻辑接口
 *
 * @author time
 */
public interface AdminService {


    /**
     * 添加管理员
     *
     * @param admin
     * @return 是否成功
     */
    int insertSelective(Admin admin);


    /**
     * 修改管理员
     *
     * @param admin 管理员对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(Admin admin);


    /**
     * 管理员登录
     *
     * @param admin 管理员对象
     * @return 是否成功
     */
    int login(Admin admin);

    /**
     * 根据名字查询
     *
     * @param name
     * @return
     */
    Admin selectByName(String name);

    /**
     * 查询管理员登录时间
     *
     * @return
     */
    List<Admin> selectAdminDate();
}
