package com.time.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseRowModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExcelProperty(value = "商品编号", index = 0)
	private Integer proId;

	@ExcelProperty(value = "商品类型", index = 1)
	private String proType;

	@ExcelProperty(value = "商品名称", index = 2)
	private String name;

	private String picture1;

	private String picture2;

	private String picture3;

	@ExcelProperty(value = "红色描述", index = 3)
	private String redNote;

	@ExcelProperty(value = "灰色描述", index = 4)
	private String grayNote;

	@ExcelProperty(value = "现价", index = 5)
	private Double currentPrice;

	private Double totalPrice;

	private Double originalPrice;

	@ExcelProperty(value = "数量", index = 6)
	private int quantity;

	private Long sales;

	private int totality;

	private List<Conf> conf;

	private List<Color> color;

	private List<Meal> meal;

}