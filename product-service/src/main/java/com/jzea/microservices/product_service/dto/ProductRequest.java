package com.jzea.microservices.product_service.dto;

import java.math.BigDecimal;

/*
* A RECORD is similar to a class but with less boilerplate,
* you only must set up the name fields and their types, and it
* will create their constructor, getters and setters.
* */
public record ProductRequest (Long id, String name, String description, BigDecimal price) { }
