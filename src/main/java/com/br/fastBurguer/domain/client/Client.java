package com.br.fastBurguer.domain.client;

import com.br.fastBurguer.domain.client.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.domain.cpf.CPF;
import com.br.fastBurguer.domain.email.Email;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
@EqualsAndHashCode(of = "id")
public class Client {

    public Client(@NotNull String name, CPF cpf, Email email, @NotNull ClientIdentifyByEnum identified) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.identified = identified.getValue();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToOne
    @JoinColumn(name = "cpfs_id")
    private CPF cpf;
 
    @OneToOne
    @JoinColumn(name = "emails_id")
    private Email email;

    @NotNull
    private String identified;
 
    private Long acessNum;
}
