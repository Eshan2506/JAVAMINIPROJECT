package com.construction.waste.service;

import com.construction.waste.model.WasteLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Service managing construction waste logs in memory with sample starter data.
 */
@Service
public class WasteLogService {

    private final List<WasteLog> wasteLogs = new CopyOnWriteArrayList<>();

    public WasteLogService() {
        // Initialize with default construction waste logs matching the project demo
        wasteLogs.add(new WasteLog(
                UUID.randomUUID().toString(),
                "2026-10-18",
                "Zone A - Foundation",
                "Concrete",
                1250.0,
                "Over-pour & Spoilage",
                "Recycle",
                "Non-Hazardous",
                "EcoHaul Solutions",
                18750.0
        ));
        wasteLogs.add(new WasteLog(
                UUID.randomUUID().toString(),
                "2026-10-20",
                "Zone B - Framing",
                "Rebar / Steel",
                420.0,
                "Off-cuts",
                "Recycle",
                "Non-Hazardous",
                "Metals Reclaim Corp",
                25200.0
        ));
        wasteLogs.add(new WasteLog(
                UUID.randomUUID().toString(),
                "2026-10-22",
                "Zone C - Finishing",
                "Drywall / Gypsum",
                310.0,
                "Handling Damage",
                "Landfill",
                "Moderate",
                "City Waste Logistics",
                6200.0
        ));
    }

    /**
     * Retrieve all logged waste records, newest first.
     */
    public List<WasteLog> getAllLogs() {
        List<WasteLog> list = new ArrayList<>(wasteLogs);
        Collections.reverse(list);
        return list;
    }

    /**
     * Save a new waste log entry.
     */
    public WasteLog addLog(WasteLog log) {
        if (log.getId() == null || log.getId().isEmpty()) {
            log.setId(UUID.randomUUID().toString());
        }
        if (log.getWeight() == null) {
            log.setWeight(0.0);
        }
        if (log.getEstimatedLoss() == null) {
            log.setEstimatedLoss(0.0);
        }
        wasteLogs.add(log);
        return log;
    }
}
