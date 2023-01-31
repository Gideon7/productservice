package com.app.productservice.models.requests;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price) {
}
