package com.construction.waste.model;

import java.time.LocalDate;

/**
 * Model representing a single construction waste log record.
 */
public class WasteLog {

    private String id;
    private String date;
    private String siteZone;
    private String material;
    private Double weight;
    private String cause;
    private String disposalRoute;
    private String hazardLevel;
    private String vendor;
    private Double estimatedLoss;

    public WasteLog() {
    }

    public WasteLog(String id, String date, String siteZone, String material, Double weight,
                    String cause, String disposalRoute, String hazardLevel, String vendor, Double estimatedLoss) {
        this.id = id;
        this.date = date;
        this.siteZone = siteZone;
        this.material = material;
        this.weight = weight;
        this.cause = cause;
        this.disposalRoute = disposalRoute;
        this.hazardLevel = hazardLevel;
        this.vendor = vendor;
        this.estimatedLoss = estimatedLoss;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSiteZone() {
        return siteZone;
    }

    public void setSiteZone(String siteZone) {
        this.siteZone = siteZone;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDisposalRoute() {
        return disposalRoute;
    }

    public void setDisposalRoute(String disposalRoute) {
        this.disposalRoute = disposalRoute;
    }

    public String getHazardLevel() {
        return hazardLevel;
    }

    public void setHazardLevel(String hazardLevel) {
        this.hazardLevel = hazardLevel;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getEstimatedLoss() {
        return estimatedLoss;
    }

    public void setEstimatedLoss(Double estimatedLoss) {
        this.estimatedLoss = estimatedLoss;
    }
}
