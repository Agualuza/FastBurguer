package com.br.fastBurguer.infra.persistence.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT c FROM ClientEntity c JOIN c.cpfEntity cpf WHERE cpf.number = :cpf")
    public ClientEntity findClientCpf(@Param("cpf") String cpf);
}
