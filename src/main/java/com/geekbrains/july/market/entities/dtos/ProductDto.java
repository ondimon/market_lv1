package com.geekbrains.july.market.entities.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"id"})
public class ProductDto {
    @NotNull
    private Long id;
    private String title;
    private int price;
}
