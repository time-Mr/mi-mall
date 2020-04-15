package com.time.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 用户的地址
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer addressId;

    @NotNull(message = "所属人不能为空")
    private String owner;

    @NotNull(message = "收货人不能为空")
    private String consignee;

    @NotNull(message = "电话不能为空")
    private String phone;

    @NotNull(message = "地址不能为空")
    private String address;

    private Integer postalCode;

    private String note;


}