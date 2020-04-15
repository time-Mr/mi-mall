package com.time.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单中的商品
 *
 * @author time
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "orderProductId")
    private int orderProductId;

    @JsonProperty(value = "orderId")
    private int orderId;

    @JsonProperty(value = "productPicture")
    private String productPicture;

    @JsonProperty(value = "productName")
    private String productName;

    @JsonProperty(value = "productColor")
    private String productColor;

    @JsonProperty(value = "productMount")
    private Double productMount;

    @JsonProperty(value = "productNumber")
    private Long productNumber;
}
