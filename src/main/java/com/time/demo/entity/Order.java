package com.time.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseRowModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExcelProperty(value = "订单编号", index = 0)
	private Integer orderId;

	@ExcelProperty(value = "用户名", index = 1)
	private String owner;

	@ExcelProperty(value = "昵称", index = 2)
	private String nickName;

	@ExcelProperty(value = "订单状态", index = 3)
	private Integer orderStatus;

	@ExcelProperty(value = "创建时间", index = 4)
	private Date createTime;

	@ExcelProperty(value = "收货人", index = 5)
	private String consign;

	@ExcelProperty(value = "收货人电话", index = 6)
	private String consignPhone;

	@ExcelProperty(value = "收货地址", index = 7)
	private String consignAddress;

	@ExcelProperty(value = "订单号", index = 8)
	private String orderNumber;

	@ExcelProperty(value = "支付方式", index = 9)
	private String payMethod;

	private List<OrderProduct> productList;

}