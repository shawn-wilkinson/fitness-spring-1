package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private IDeviceRepository deviceRepository;

    @Autowired
    public void setDeviceRepository(IDeviceRepository deviceRepository) { this.deviceRepository = deviceRepository; }

    public Device findOneBySerialNumber(String serialNumber){
        return deviceRepository.findOneBySerialNumber(serialNumber);
    };

}
