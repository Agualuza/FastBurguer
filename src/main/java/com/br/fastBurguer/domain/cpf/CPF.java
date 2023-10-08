package com.br.fastBurguer.domain.cpf;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cpfs")
public class CPF {
    
    public CPF(String cpf) {
        this.cpf = cpf;
    }

    @Id
    private String cpf;

}
