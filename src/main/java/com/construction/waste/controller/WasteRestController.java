package com.construction.waste.controller;

import com.construction.waste.model.WasteLog;
import com.construction.waste.service.WasteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller exposing endpoints for logging and fetching construction waste.
 */
@RestController
@RequestMapping("/api/waste")
@CrossOrigin(origins = "*")
public class WasteRestController {

    private final WasteLogService wasteLogService;

    @Autowired
    public WasteRestController(WasteLogService wasteLogService) {
        this.wasteLogService = wasteLogService;
    }

    /**
     * Endpoint to fetch all recorded waste logs.
     * URL: GET http://localhost:8080/api/waste/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<WasteLog>> getAllLogs() {
        return ResponseEntity.ok(wasteLogService.getAllLogs());
    }

    /**
     * Endpoint to add a new waste log entry.
     * URL: POST http://localhost:8080/api/waste/add
     */
    @PostMapping("/add")
    public ResponseEntity<WasteLog> addLog(@RequestBody WasteLog wasteLog) {
        WasteLog saved = wasteLogService.addLog(wasteLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
