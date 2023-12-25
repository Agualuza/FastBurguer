package com.br.fastBurguer.infra.persistence.cpf;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Transactional
@Table(name = "cpfs")
@NoArgsConstructor
public class CpfEntity {
    
    public CpfEntity(String number) {
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

}
