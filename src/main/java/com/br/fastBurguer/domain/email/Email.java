package com.br.fastBurguer.domain.email;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "emails")
@Getter
@Setter
public class Email {
    
    public Email(String email) {
        this.email = email;
    }

    @Id
    private String email;

}
