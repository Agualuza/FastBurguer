package com.br.fastBurguer.infra.persistence.queue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<QueueEntity, Long>{
     public List<QueueEntity> findByStatus(String type);
}
