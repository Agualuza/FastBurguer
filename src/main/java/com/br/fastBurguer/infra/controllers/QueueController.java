package com.br.fastBurguer.infra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.boundary.EditQueueStatusBoundary;
import com.br.fastBurguer.adapters.boundary.FindQueueByStatusBoundary;
import com.br.fastBurguer.adapters.presenters.queue.QueueDTOMapper;
import com.br.fastBurguer.adapters.presenters.queue.QueueEditRequestBody;
import com.br.fastBurguer.adapters.presenters.queue.QueueResponse;
import com.br.fastBurguer.adapters.presenters.queue.QueueStatusRequest;
import com.br.fastBurguer.core.entities.Queue;

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

        private final EditQueueStatusBoundary editQueueStatusBoundary;
        private final FindQueueByStatusBoundary findQueueByStatusBoundary;

        public QueueController(EditQueueStatusBoundary editQueueStatusBoundary,
                        FindQueueByStatusBoundary findQueueByStatusBoundary,
                        QueueDTOMapper queueDTOMapper) {
                this.editQueueStatusBoundary = editQueueStatusBoundary;
                this.findQueueByStatusBoundary = findQueueByStatusBoundary;
        }

        @Operation(summary = "Get Queues")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Queues Found", content = {
                                        @Content
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        })
        })
        @GetMapping()
        public ResponseEntity<List<Queue>> getAllQueueByStatus(
                        @RequestParam("status") QueueStatusRequest queueStatusRequest) {

                try {
                        List<Queue> queues = findQueueByStatusBoundary
                                        .findQueueByStatus(queueStatusRequest.getStatusQueue());
                        return ResponseEntity.ok(queues);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }

        @Operation(summary = "Edit Status Queues")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Queue edited", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = QueueResponse.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        })
        })
        @PutMapping("/{status}")
        public ResponseEntity<QueueResponse> putStatusQueue(@RequestBody QueueEditRequestBody queueEditRequest,
                        @PathVariable QueueStatusRequest status) {

                try {
                        QueueResponse queueEdited = editQueueStatusBoundary.editQueueStatus(queueEditRequest.orderId(),
                                        status.getStatusQueue());
                        return ResponseEntity.ok(queueEdited);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
        }
}
