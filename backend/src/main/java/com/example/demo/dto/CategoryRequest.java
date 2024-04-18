package com.example.demo.dto;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

public record CategoryRequest(
    
    ObjectId budgetID,

    Decimal128 amount_allocated,
    String name,
    String description
    ) {}