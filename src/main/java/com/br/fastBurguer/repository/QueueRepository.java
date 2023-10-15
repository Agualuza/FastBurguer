package com.br.fastBurguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.queue.Queue;
import com.br.fastBurguer.domain.queue.Enums.StatusEnum;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long>{
     public List<Queue> findByStatus(StatusEnum type);
}
