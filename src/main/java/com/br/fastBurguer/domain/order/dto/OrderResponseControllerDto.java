package com.br.fastBurguer.domain.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseControllerDto {
    Long clientId;
    List<String> products;
}
