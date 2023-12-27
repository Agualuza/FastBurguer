package com.br.fastBurguer.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.presenters.client.ClientDTOMapper;
import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.adapters.presenters.client.FindClientByCpfResponse;
import com.br.fastBurguer.application.useCases.CreateClient;
import com.br.fastBurguer.application.useCases.FindClientByCpf;
import com.br.fastBurguer.core.entities.Client;
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

    private final CreateClient createClient;
    private final FindClientByCpf findClientByCpf;
    private final ClientDTOMapper clientDTOMapper;

    public ClientController(CreateClient createClient, FindClientByCpf findClientByCpf,
            ClientDTOMapper clientDTOMapper) {
        this.createClient = createClient;
        this.findClientByCpf = findClientByCpf;
        this.clientDTOMapper = clientDTOMapper;
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

        Client clientToCreate = clientDTOMapper.toClient(request);

        try {
            createClient.createClient(clientToCreate);
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
            Client clientToReturn = findClientByCpf.findClientByCpf(cpfValue);

            if (clientToReturn != null) {
                FindClientByCpfResponse createClientResponse = clientDTOMapper.toResponse(clientToReturn);
                return ResponseEntity.ok(createClientResponse);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.notFound().build();
    }
}
