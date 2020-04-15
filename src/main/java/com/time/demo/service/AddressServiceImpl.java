package com.time.demo.service;

import com.time.demo.entity.Address;
import com.time.demo.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址逻辑实现
 *
 * @author time
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int deleteByPrimaryKey(Integer addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int insertSelective(Address address) {
        return addressMapper.insertSelective(address);
    }

    @Override
    public int updateByPrimaryKeySelective(Address address) {
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public List<Address> selectByUserName(String username) {
        return addressMapper.selectByUserName(username);
    }

}