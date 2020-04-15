package com.time.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品颜色
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Color implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "colorId")
	private Integer colorId;

	@JsonProperty(value = "productId")
	private Integer productId;

	@JsonProperty(value = "color")
	private String color;
}
