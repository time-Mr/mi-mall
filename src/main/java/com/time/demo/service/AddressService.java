package com.time.demo.service;

import com.time.demo.entity.Address;

import java.util.List;


/**
 * 地址逻辑接口
 *
 * @author time
 */
public interface AddressService {

    /**
     * 删除主键
     *
     * @param addressId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer addressId);

    /**
     * 添加地址
     *
     * @param address 地址对象
     * @return 是否成功
     */
    int insertSelective(Address address);

    /**
     * 根据主键修改
     *
     * @param address 地址对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(Address address);

    /**
     * 根据用户名查找该用户所有地址
     *
     * @param userName 用户名
     * @return 结果集
     */
    List<Address> selectByUserName(String userName);
}
