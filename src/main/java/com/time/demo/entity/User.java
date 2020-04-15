package com.time.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseRowModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "用户编号", index = 0)
    private Integer userId;

    @ExcelProperty(value = "用户昵称", index = 1)
    private String nickName;

    @NotNull(message = "用户名不能为空")
    @ExcelProperty(value = "用户名", index = 2)
    private String userName;

    @NotNull(message = "密码不能为空")
    private String passWord;

    @ExcelProperty(value = "用户性别", index = 3)
    private String sex;

}