package com.safiribytes.shoppingmicroservice.order_service.dto;

import java.math.BigDecimal;

public record OrderRequest(
        Long id,
        String orderName,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}
