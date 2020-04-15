package com.time.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户喜欢的商品
 *
 * @author time
 */
@Data
public class Like implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer likeId;

	private String owner;

	private String product;

	private String model;

	private String color;

	private Double price;

}