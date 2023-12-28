package com.br.fastBurguer.adapters.presenters.order;

import java.util.List;

public record FindAllOrdersResponse(
    List<FindOrderResponse> orders
) {
}
    

