package com.br.fastBurguer.adapters.presenters.order;

import java.util.List;

public record FindOrderByProductsResponse(
        List<Long> orderIds) {

}
