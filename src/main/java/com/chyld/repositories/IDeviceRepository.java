package com.chyld.repositories;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IDeviceRepository extends PagingAndSortingRepository<Device, String> {

    public Device findOneBySerialNumber(String serialNumber);

}
