package com.media.tecnm.market_backend_v2.web.controller;

import com.media.tecnm.market_backend_v2.domain.Client;
import com.media.tecnm.market_backend_v2.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client", description = "Manage your clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    @Operation(summary = "Get all clients",
            description = "Return a list of all available clients")
    @ApiResponse(responseCode = "200",
            description = "Successful retrieval of clients")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID",
            description = "Return a client by its ID if it exists")
    @ApiResponse(responseCode = "200",
            description = "Client found")
    @ApiResponse(responseCode = "404",
            description = "Client not found")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<Client> getClient(
            @Parameter(description = "ID of the client to be retrieved",
                    example = "CLI-001",
                    required = true)
            @PathVariable("id") String clientId) {
        return clientService.getClient(clientId)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @Operation(summary = "Create a client",
            description = "Create a new client")
    @ApiResponse(responseCode = "201",
            description = "Client created")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a client",
            description = "Update an existing client by its ID")
    @ApiResponse(responseCode = "200",
            description = "Client updated")
    @ApiResponse(responseCode = "404",
            description = "Client not found")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<Client> update(
            @Parameter(description = "ID of the client to be updated",
                    example = "CLI-001",
                    required = true)
            @PathVariable("id") String clientId,
            @RequestBody Client client) {
        return clientService.update(clientId, client)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client",
            description = "Delete a client by its ID if it exists")
    @ApiResponse(responseCode = "200",
            description = "Client deleted")
    @ApiResponse(responseCode = "404",
            description = "Client not found")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<Void> delete(@PathVariable("id") String clientId) {
        if (clientService.delete(clientId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
