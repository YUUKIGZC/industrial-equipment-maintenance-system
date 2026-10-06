package com.industrial.service;

import com.industrial.model.Device;
import com.industrial.model.DeviceStatus;
import com.industrial.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    //Spring DI
    private final DeviceRepository deviceRepository;
    //构造器注入
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }
    public boolean updateStatus(int id, DeviceStatus status) {
        return deviceRepository.updateStatus(id, status);
    }
    public Device createDevice(Device device) {
        deviceRepository.save(device);
        return device;
    }
    public boolean deleteDevice(int id) {
        return deviceRepository.deleteById(id);
    }
}
