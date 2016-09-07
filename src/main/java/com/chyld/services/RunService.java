package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RunService {
    private IRunRepository runRepository;

    @Autowired
    public void setRunRepository(IRunRepository runRepository) { this.runRepository = runRepository; }

    public Run saveRun(Run run){
        return runRepository.save(run);
    }

    public Run startRun(Run run) {
        Device device = run.getDevice();
        Run activeRun = findActiveRun(device);
        if (activeRun == null) {
            return saveRun(run);
        } else {
            return null;
        }
    }

    public Run stopRun(Run run) {
        run.setStopTime(new Date());
        return saveRun(run);
    }

    public Run findActiveRun(Device device ) { return runRepository.findOneByDeviceAndStartTimeIsNotNullAndStopTimeIsNull(device);}
}
