package com.time.demo.mapper;

import com.time.demo.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 地址底层接口
 *
 * @author time
 */
@Mapper
public interface AddressMapper {
    /**
     * 根据主键删除
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
     * 修改地址
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