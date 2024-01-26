package com.br.fastBurguer.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.boundary.CreateClientBoundary;
import com.br.fastBurguer.adapters.boundary.FindClientByCpfBoundary;
import com.br.fastBurguer.adapters.presenters.client.ClientDTOMapper;
import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.adapters.presenters.client.FindClientByCpfResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/client")
@Tag(name = "Client", description = "Create and search client.")
public class ClientController {

    private final CreateClientBoundary createClientBoundary;
    private final FindClientByCpfBoundary findClientByCpfBoundary;

    public ClientController(CreateClientBoundary createClientBoundary, FindClientByCpfBoundary findClientByCpfBoundary,
            ClientDTOMapper clientDTOMapper) {
        this.createClientBoundary = createClientBoundary;
        this.findClientByCpfBoundary = findClientByCpfBoundary;
    }

    @Operation(summary = "Create Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client Created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CreateClientRequest.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content
            })
    })
    @PostMapping()
    public ResponseEntity<String> clientRegister(@RequestBody CreateClientRequest request) {

        try {
            createClientBoundary.createClient(request);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Search Client By CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client Found", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                    @Content
            })
    })
    @GetMapping()
    public ResponseEntity<FindClientByCpfResponse> getClientByCpf(@RequestParam("cpf") String cpfValue)
            throws JsonProcessingException {

        try {
            FindClientByCpfResponse clientToReturn = findClientByCpfBoundary.findClientByCpf(cpfValue);
            return ResponseEntity.ok(clientToReturn);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
