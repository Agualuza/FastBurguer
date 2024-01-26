package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.client.FindClientByCpfResponse;

public interface FindClientByCpfBoundary {
    
    public FindClientByCpfResponse findClientByCpf(String number);
}
