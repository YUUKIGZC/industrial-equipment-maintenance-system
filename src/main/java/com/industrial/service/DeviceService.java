package com.industrial.service;

import com.industrial.exception.DeviceNotFoundException;
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

    public Device createDevice(Device device) {
        deviceRepository.save(device);
        return device;
    }
    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }
    public Device getDeviceById(int id) {
        Device device = deviceRepository.findById(id);

        if (device == null) {
            throw new DeviceNotFoundException(id);
        }
        return device;
    }
    public boolean updateStatus(int id, DeviceStatus status) {

        boolean updated = deviceRepository.updateStatus(id, status);

        if (!updated) {
            throw new DeviceNotFoundException(id);
        }
        return updated;
    }
    public boolean deleteDevice(int id) {

        boolean deleted = deviceRepository.deleteById(id);

        if (!deleted) {
            throw new DeviceNotFoundException(id);
        }
        return deleted;
    }
}
