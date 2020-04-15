package com.time.demo.service;

import com.time.demo.entity.Admin;
import com.time.demo.mapper.AdminMapper;
import com.time.demo.util.MD5Util;
import com.time.demo.util.VerdictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员逻辑实现
 *
 * @author time
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertSelective(Admin admin) {
        admin.setPassWord(MD5Util.md5(admin.getPassWord()));
        if (VerdictUtil.isNotNull(adminMapper.selectByName(admin.getName()))) {
            return 0;
        }
        return adminMapper.insertSelective(admin);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin admin) {
        admin.setPassWord(MD5Util.md5(admin.getPassWord()));
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int login(Admin admin) {
        if (1 == VerdictUtil.returnInt(VerdictUtil.isNotNull(adminMapper.selectByName(admin.getName())))) {
            adminMapper.updateAdminDate(admin);
            return 1;
        }
        return 0;
    }

    @Override
    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }

    @Override
    public List<Admin> selectAdminDate() {
        return adminMapper.selectAdminDate();
    }


}