package com.construction.waste.controller;

import com.construction.waste.dto.EstimationRequestDTO;
import com.construction.waste.dto.EstimationResultDTO;
import com.construction.waste.model.MaterialType;
import com.construction.waste.service.WasteCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller handling web requests for the Waste Audit & Estimation module.
 */
@Controller
@RequestMapping("/audit")
public class WasteAuditController {

    private final WasteCalculatorService wasteCalculatorService;

    @Autowired
    public WasteAuditController(WasteCalculatorService wasteCalculatorService) {
        this.wasteCalculatorService = wasteCalculatorService;
    }

    /**
     * Renders the waste audit estimation form with an empty EstimationRequestDTO.
     *
     * @param model the Spring MVC UI Model
     * @return the audit form view name
     */
    @GetMapping
    public String showAuditForm(Model model) {
        if (!model.containsAttribute("estimationRequest")) {
            model.addAttribute("estimationRequest", new EstimationRequestDTO());
        }
        model.addAttribute("materialTypes", MaterialType.values());
        return "audit-form.html";
    }

    /**
     * Handles submission of the audit estimation form, performs calculations,
     * adds the result to the model, and renders the result view.
     *
     * @param request the submitted EstimationRequestDTO
     * @param model   the Spring MVC UI Model
     * @return the audit result view name
     */
    @PostMapping("/calculate")
    public String calculateAudit(@ModelAttribute("estimationRequest") EstimationRequestDTO request, Model model) {
        EstimationResultDTO result = wasteCalculatorService.calculateEstimation(request);
        model.addAttribute("result", result);
        return "audit-result.html";
    }
}
