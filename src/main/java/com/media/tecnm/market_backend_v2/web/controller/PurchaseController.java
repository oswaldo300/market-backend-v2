package com.media.tecnm.market_backend_v2.web.controller;

import com.media.tecnm.market_backend_v2.domain.Purchase;
import com.media.tecnm.market_backend_v2.domain.service.PurchaseService;
import com.media.tecnm.market_backend_v2.web.dto.PurchaseRequest;
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
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Manage your purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("")
    @Operation(summary = "Get all purchases",
            description = "Return a list of all purchases")
    @ApiResponse(responseCode = "200",
            description = "Successful retrieval of purchases")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get purchase by ID",
            description = "Return a purchase by its ID if it exists")
    @ApiResponse(responseCode = "200",
            description = "Purchase found")
    @ApiResponse(responseCode = "404",
            description = "Purchase not found")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<Purchase> getPurchase(
            @Parameter(description = "ID of the purchase to be retrieved",
                    example = "1",
                    required = true)
            @PathVariable("id") int purchaseId) {
        return purchaseService.getPurchase(purchaseId)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Get purchases by client",
            description = "Return all purchases of a specific client")
    @ApiResponse(responseCode = "200",
            description = "Purchase(s) found for the client")
    @ApiResponse(responseCode = "404",
            description = "Purchase(s) not found for the client")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID of the client",
                    example = "CLI-001", required = true)
            @PathVariable("clientId") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @Operation(summary = "Create a purchase",
            description = "Create a purchase with its items in a single transaction (master-detail)")
    @ApiResponse(responseCode = "201",
            description = "Purchase created")
    @ApiResponse(responseCode = "400",
            description = "Invalid purchase data")
    @ApiResponse(responseCode = "500",
            description = "Internal Server Error")
    public ResponseEntity<Purchase> save(@RequestBody PurchaseRequest request) {
        return new ResponseEntity<>(purchaseService.save(request), HttpStatus.CREATED);
    }
}
