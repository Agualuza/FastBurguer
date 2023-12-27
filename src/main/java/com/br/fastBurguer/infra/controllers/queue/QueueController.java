package com.br.fastBurguer.infra.controllers.queue;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.application.useCases.EditQueueStatus;
import com.br.fastBurguer.application.useCases.FindQueueByStatus;
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

    private final EditQueueStatus editQueueStatus;
    private final FindQueueByStatus findQueueByStatus;
    private final QueueDTOMapper queueDTOMapper;

    public QueueController(EditQueueStatus editQueueStatus, FindQueueByStatus findQueueByStatus,
            QueueDTOMapper queueDTOMapper) {
        this.editQueueStatus = editQueueStatus;
        this.findQueueByStatus = findQueueByStatus;
        this.queueDTOMapper = queueDTOMapper;
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
        List<Queue> queues = findQueueByStatus.findQueueByStatus(queueStatusRequest.getStatusQueue());
        return ResponseEntity.ok(queues);
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
        Queue queueEdited = editQueueStatus.editQueueStatus(queueEditRequest.id(), status.getStatusQueue());
        return ResponseEntity.ok(queueDTOMapper.toResponse(queueEdited));
    }
}
