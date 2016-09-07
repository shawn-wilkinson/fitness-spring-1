package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.PositionService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private PositionService positionService;
    private DeviceService deviceService;
    private RunService runService;

    @Autowired
    public void setPositionService(PositionService positionService) { this.positionService = positionService; }

    @Autowired
    public void setDeviceService(DeviceService deviceService) { this.deviceService = deviceService; }

    @Autowired
    public void setRunService(RunService runService) { this.runService = runService; }

    @RequestMapping(value="/{serialNumber}", method = RequestMethod.POST)
    public Position createPosition(@PathVariable String serialNumber, @RequestBody Position position) {
        Device device = deviceService.findOneBySerialNumber(serialNumber);
        Run activeRun = runService.findActiveRun(device);
        if(activeRun != null) {
            position.setRun(activeRun);
            position = positionService.savePosition(position);
            return position;
        }
        return null;
    }
}
