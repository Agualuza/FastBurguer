package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c\r\n" + //
            "FROM Client c\r\n" + //
            "JOIN c.cpf cpf\r\n" + //
            "WHERE cpf.cpf = :cpf")
    public Client findClientCpf(@Param("cpf") String cpf);
}
