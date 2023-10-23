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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/queue")
@Tag(name = "Queue", description = "Queue kitchen")
public class QueueController {

    @Autowired
    QueueService queueService;
    
    @Operation(summary = "Get Queues")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Queues Found",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @GetMapping()
    public ResponseEntity<List<Queue>> getAllQueueByStatus(@RequestParam("status") StatusEnum statusEnum) {
        List<Queue> queues = queueService.getQueueByStatus(statusEnum);
        return ResponseEntity.ok(queues);
    }

    @Operation(summary = "Edit Status Queues")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Queue edited",
            content = {
                @Content(mediaType = "application/json",
                schema = @Schema(implementation = QueueDto.class))
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @PutMapping("/{status}")
    public ResponseEntity<QueueDto> putStatusQueue(@RequestBody QueueDto queue, @PathVariable StatusEnum status) {
        queueService.changeStatusQueue(queue.id(), status);
        return ResponseEntity.ok(queue);
    }
}
