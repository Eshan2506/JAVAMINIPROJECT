package com.construction.waste.dto;

import com.construction.waste.model.MaterialType;

/**
 * Data Transfer Object representing calculated waste estimation metrics.
 */
public class EstimationResultDTO {

    private final String projectName;
    private final MaterialType materialType;
    private final double plannedQuantity;
    private final double estimatedWasteQuantity;
    private final double estimatedWasteWeightKg;
    private final double estimatedDisposalCost;

    public EstimationResultDTO(String projectName,
                               MaterialType materialType,
                               double plannedQuantity,
                               double estimatedWasteQuantity,
                               double estimatedWasteWeightKg,
                               double estimatedDisposalCost) {
        this.projectName = projectName;
        this.materialType = materialType;
        this.plannedQuantity = plannedQuantity;
        this.estimatedWasteQuantity = estimatedWasteQuantity;
        this.estimatedWasteWeightKg = estimatedWasteWeightKg;
        this.estimatedDisposalCost = estimatedDisposalCost;
    }

    public String getProjectName() {
        return projectName;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public double getPlannedQuantity() {
        return plannedQuantity;
    }

    public double getEstimatedWasteQuantity() {
        return estimatedWasteQuantity;
    }

    public double getEstimatedWasteWeightKg() {
        return estimatedWasteWeightKg;
    }

    public double getEstimatedDisposalCost() {
        return estimatedDisposalCost;
    }
}
