package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public List<Device> listDevices(){
        return deviceRepository.findAll();
    }

    public Device createDevice(DeviceRequest request){
        Device device = new Device(
            request.name(),
            request.status()
        );
        return deviceRepository.save(device);
    }
}

// 