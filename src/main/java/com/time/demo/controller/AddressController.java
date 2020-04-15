package com.time.demo.controller;

import com.time.demo.entity.Address;
import com.time.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 地址控制层
 *
 * @author time
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService iAddressService;

    /**
     * 根据名字查询地址b
     *
     * @param response 响应对象
     * @param userName 查询的名字
     * @return 结果集
     */
    @RequestMapping("/selectAddress")
    public List<Address> selectAddress(HttpServletResponse response, String userName) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return iAddressService.selectByUserName(userName);
    }

    /**
     * 添加地址
     *
     * @param response 响应对象
     * @param address  添加的地址
     * @return 是否成功
     */
    @RequestMapping("/insertAddress")
    public int insertAddress(HttpServletResponse response, Address address) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return iAddressService.insertSelective(address);
    }

    /**
     * 修改地址
     *
     * @param response 响应对象
     * @param address  修改的地址
     * @return 是否成功
     */
    @RequestMapping("/updateAddress")
    public int updateAddress(HttpServletResponse response, Address address) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return iAddressService.updateByPrimaryKeySelective(address);
    }

    /**
     * 根据主键删除
     *
     * @param response  响应对象
     * @param addressId 删除的主键
     * @return 是否成功
     */
    @RequestMapping("/deleteAddress")
    public int deleteAddress(HttpServletResponse response, Integer addressId) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return iAddressService.deleteByPrimaryKey(addressId);
    }
}
