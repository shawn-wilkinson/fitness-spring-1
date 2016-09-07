package com.chyld.controllers;


import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/runs")
public class RunController {

    private RunService runService;
    private DeviceService deviceService;

    @Autowired
    public void setRunService(RunService runService) { this.runService = runService; }

    @Autowired
    public void setDeviceService(DeviceService deviceService) { this.deviceService = deviceService; }

    @RequestMapping(value="/{serialNumber}/start", method = RequestMethod.POST)
    public Run createRun(@PathVariable String serialNumber) {
        Device device = deviceService.findOneBySerialNumber(serialNumber);
        Run run = new Run();
        run.setDevice(device);
        run.setStartTime(new Date());
        run = runService.startRun(run);
        return run;
    }
    @RequestMapping(value="/{serialNumber}/stop", method = RequestMethod.PUT)
    public Run stopRun(@PathVariable String serialNumber) {
        Device device = deviceService.findOneBySerialNumber(serialNumber);
        Run run = runService.findActiveRun(device);
        run = runService.stopRun(run);
        return run;
    }
}
