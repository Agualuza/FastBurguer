package com.br.fastBurguer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.queue.Queue;
import com.br.fastBurguer.domain.queue.Enums.StatusEnum;
import com.br.fastBurguer.domain.queue.dto.QueueDto;
import com.br.fastBurguer.services.QueueService;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueueService queueService;
    
    @GetMapping()
    public ResponseEntity<List<Queue>> getAllQueueByStatus(@RequestParam("status") StatusEnum statusEnum) {
        List<Queue> queues = queueService.getQueueByStatus(statusEnum);
        return ResponseEntity.ok(queues);
    }

    @PutMapping("/{status}")
    public ResponseEntity<QueueDto> putStatusQueue(@RequestBody QueueDto queue, @PathVariable StatusEnum status) {
        queueService.changeStatusQueue(queue.id(), status);
        return ResponseEntity.ok(queue);
    }
}
