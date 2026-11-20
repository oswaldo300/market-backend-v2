package com.media.tecnm.market_backend_v2.web.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * Convierte los errores de integridad referencial (por ejemplo, borrar una
 * categoria que todavia tiene productos, o un cliente que ya tiene compras)
 * en un 409 Conflict con un mensaje claro, en vez de un 500 generico.
 * La base de datos protege los datos relacionados; no es un error del codigo.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrity(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "status", 409,
                "error", "Conflict",
                "message", "No se puede completar la operacion porque el registro esta relacionado con otros datos (por ejemplo, una categoria con productos o un cliente con compras). Borra primero los registros relacionados.",
                "detail", String.valueOf(ex.getMostSpecificCause().getMessage())
        ));
    }
}
