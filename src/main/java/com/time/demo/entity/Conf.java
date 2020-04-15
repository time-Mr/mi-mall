package com.time.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品配置
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Conf implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "confId")
	private Integer confId;

	@JsonProperty(value = "productId")
	private Integer productId;

	@JsonProperty(value = "conf")
	private String conf;
}
