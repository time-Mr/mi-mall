package com.time.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理员
 *
 * @author time
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer adminId;

    @NotNull(message = "名字不能为空")
    private String name;

    @NotNull(message = "密码不能为空")
    private String passWord;

    private String avatar;

    private Date loginDate;
}