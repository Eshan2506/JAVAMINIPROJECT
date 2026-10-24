package com.construction.waste;

import com.construction.waste.dto.EstimationRequestDTO;
import com.construction.waste.dto.EstimationResultDTO;
import com.construction.waste.model.MaterialType;
import com.construction.waste.model.WasteLog;
import com.construction.waste.service.WasteCalculatorService;
import com.construction.waste.service.WasteLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WasteManagementApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WasteCalculatorService calculatorService;

    @Autowired
    private WasteLogService wasteLogService;

    @Test
    void contextLoads() {
        assertNotNull(calculatorService);
        assertNotNull(wasteLogService);
    }

    @Test
    void testWasteCalculatorLogic() {
        EstimationRequestDTO request = new EstimationRequestDTO("Test Tower", 100.0, MaterialType.CONCRETE);
        EstimationResultDTO result = calculatorService.calculateEstimation(request);

        assertNotNull(result);
        assertEquals("Test Tower", result.getProjectName());
        assertEquals(8.0, result.getEstimatedWasteQuantity(), 0.001); // 100 * 0.08
        assertEquals(19200.0, result.getEstimatedWasteWeightKg(), 0.001); // 8.0 * 2400.0
        assertEquals(960.0, result.getEstimatedDisposalCost(), 0.001); // (19200 / 1000) * 50
    }

    @Test
    void testGetAllWasteLogsApi() throws Exception {
        mockMvc.perform(get("/api/waste/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testAddWasteLogApi() throws Exception {
        String jsonPayload = "{"
                + "\"date\":\"2026-10-24\","
                + "\"siteZone\":\"Zone A - Foundation\","
                + "\"material\":\"Concrete\","
                + "\"weight\":750.5,"
                + "\"cause\":\"Over-pour\","
                + "\"disposalRoute\":\"Recycle\","
                + "\"hazardLevel\":\"Non-Hazardous\","
                + "\"vendor\":\"EcoHaul Solutions\","
                + "\"estimatedLoss\":11250.0"
                + "}";

        mockMvc.perform(post("/api/waste/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.material").value("Concrete"))
                .andExpect(jsonPath("$.weight").value(750.5));
    }
}
