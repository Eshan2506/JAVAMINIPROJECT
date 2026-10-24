package com.construction.waste.controller;

import com.construction.waste.dto.EstimationRequestDTO;
import com.construction.waste.dto.EstimationResultDTO;
import com.construction.waste.model.MaterialType;
import com.construction.waste.service.WasteCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * REST API for Waste Audit and Estimation module calculations.
 */
@RestController
@RequestMapping("/api/audit")
@CrossOrigin(origins = "*")
public class WasteAuditRestController {

    private final WasteCalculatorService wasteCalculatorService;

    @Autowired
    public WasteAuditRestController(WasteCalculatorService wasteCalculatorService) {
        this.wasteCalculatorService = wasteCalculatorService;
    }

    /**
     * Endpoint to get available material types.
     */
    @GetMapping("/materials")
    public ResponseEntity<List<MaterialType>> getMaterials() {
        return ResponseEntity.ok(Arrays.asList(MaterialType.values()));
    }

    /**
     * Endpoint to calculate estimation.
     */
    @PostMapping("/calculate")
    public ResponseEntity<EstimationResultDTO> calculate(@RequestBody EstimationRequestDTO request) {
        EstimationResultDTO result = wasteCalculatorService.calculateEstimation(request);
        return ResponseEntity.ok(result);
    }
}
