package com.construction.waste.dto;

import com.construction.waste.model.MaterialType;

/**
 * Data Transfer Object for capturing waste estimation input parameters.
 */
public class EstimationRequestDTO {

    private String projectName;
    private double plannedQuantity;
    private MaterialType materialType;

    public EstimationRequestDTO() {
    }

    public EstimationRequestDTO(String projectName, double plannedQuantity, MaterialType materialType) {
        this.projectName = projectName;
        this.plannedQuantity = plannedQuantity;
        this.materialType = materialType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getPlannedQuantity() {
        return plannedQuantity;
    }

    public void setPlannedQuantity(double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
