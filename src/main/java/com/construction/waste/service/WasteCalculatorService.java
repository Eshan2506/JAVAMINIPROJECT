package com.construction.waste.service;

import com.construction.waste.dto.EstimationRequestDTO;
import com.construction.waste.dto.EstimationResultDTO;
import com.construction.waste.model.MaterialType;
import org.springframework.stereotype.Service;

/**
 * Service handling calculation logic for construction waste estimation.
 */
@Service
public class WasteCalculatorService {

    // Base disposal cost rate: $50 per metric ton (1000 kg)
    public static final double BASE_RATE_PER_TON = 50.0;

    /**
     * Calculates the estimated waste volume/quantity, waste weight in kg, and total disposal cost.
     *
     * @param request the estimation input parameters
     * @return EstimationResultDTO containing calculated estimation details
     */
    public EstimationResultDTO calculateEstimation(EstimationRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Estimation request must not be null");
        }

        String projectName = request.getProjectName();
        MaterialType materialType = request.getMaterialType();
        double plannedQuantity = request.getPlannedQuantity();

        if (materialType == null) {
            throw new IllegalArgumentException("Material type must be specified");
        }

        // Estimated waste quantity based on material waste factor
        double estimatedWasteQuantity = plannedQuantity * materialType.getWasteFactor();

        // Estimated waste weight in kilograms based on material density
        double estimatedWasteWeightKg = estimatedWasteQuantity * materialType.getDensityKgPerUnit();

        // Estimated disposal cost based on base rate of $50 per ton (1000 kg)
        double estimatedDisposalCost = (estimatedWasteWeightKg / 1000.0) * BASE_RATE_PER_TON;

        return new EstimationResultDTO(
                projectName,
                materialType,
                plannedQuantity,
                estimatedWasteQuantity,
                estimatedWasteWeightKg,
                estimatedDisposalCost
        );
    }
}
