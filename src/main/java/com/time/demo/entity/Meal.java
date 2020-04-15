package com.time.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品套餐
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Meal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "mealId")
	private Integer mealId;

	@JsonProperty(value = "productId")
	private Integer productId;
	
	@JsonProperty(value = "meal")
	private String meal;
}
