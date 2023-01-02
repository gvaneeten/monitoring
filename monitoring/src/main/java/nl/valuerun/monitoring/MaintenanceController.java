package nl.valuerun.monitoring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;

@Controller
@RequestMapping("maintenance")
public class MaintenanceController {

    @Resource(name = "maintenanceBean")
    MaintenanceState maintenanceState;

    @GetMapping(value = "/start", produces = "application/json")
    public @ResponseBody String start() {
        maintenanceState.setInMaintenance(true);
        return "Started";
    }

    @GetMapping(value = "/finish", produces = "application/json")
    public @ResponseBody String finish() {
        maintenanceState.setInMaintenance(false);
        return "Finished";
    }
}