package com.time.demo.mapper;

import com.time.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员底层接口
 *
 * @author time
 */
@Mapper
public interface AdminMapper {

    /**
     * 添加管理员
     *
     * @param admin 管理员对象
     * @return 是否成功
     */
    int insertSelective(Admin admin);

    /**
     * 根据名字查询
     *
     * @param name 名字
     * @return 结果集
     */
    Admin selectByName(String name);

    /**
     * 修改管理员信息
     *
     * @param admin 管理员
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(Admin admin);

    /**
     * 写入管理员登录时间
     *
     * @param admin
     * @return
     */
    int updateAdminDate(Admin admin);

    /**
     * 查询管理员登录时间
     *
     * @return
     */
    List<Admin> selectAdminDate();
}