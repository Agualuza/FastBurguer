package com.br.fastBurguer.infra.persistence.client;

import com.br.fastBurguer.infra.persistence.cpf.CpfEntity;
import com.br.fastBurguer.infra.persistence.email.EmailEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "clients")
@NoArgsConstructor
public class ClientEntity {

    public ClientEntity(@NotNull String name, CpfEntity cpfEntity, EmailEntity emailEntity, @NotNull String identified) {
        this.name = name;
        this.cpfEntity = cpfEntity;
        this.emailEntity = emailEntity;
        this.identified = identified;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "cpfs_id")
    private CpfEntity cpfEntity;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "emails_id")
    private EmailEntity emailEntity;

    @NotNull
    private String identified;

    private Long acessNum;

}
