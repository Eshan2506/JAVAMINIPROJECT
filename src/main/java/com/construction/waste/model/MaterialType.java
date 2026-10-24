package com.construction.waste.model;

/**
 * Enum representing construction materials with their associated waste factors and density.
 */
public enum MaterialType {
    CONCRETE(0.08, 2400.0),
    DRYWALL(0.12, 800.0),
    BRICK(0.05, 1900.0),
    PACKAGING(0.15, 150.0);

    private final double wasteFactor;
    private final double densityKgPerUnit;

    MaterialType(double wasteFactor, double densityKgPerUnit) {
        this.wasteFactor = wasteFactor;
        this.densityKgPerUnit = densityKgPerUnit;
    }

    public double getWasteFactor() {
        return wasteFactor;
    }

    public double getDensityKgPerUnit() {
        return densityKgPerUnit;
    }
}
