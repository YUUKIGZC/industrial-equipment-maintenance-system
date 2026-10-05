package com.industrial;

import com.industrial.model.Device;
import com.industrial.model.DeviceStatus;
import com.industrial.repository.DeviceRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DeviceRepository repository = new DeviceRepository();

        List<Device> devices = repository.findAll();

//        com.industrial.model.Device deviceTest = new com.industrial.model.Device(0, "加工中心二号", com.industrial.model.DeviceType.CNC, com.industrial.model.DeviceStatus.RUNNING);
//        repository.save(deviceTest);


        for (Device device : devices) {
            device.displayInfo();
            System.out.println("------------------");
        }

        Device device = repository.findById(3);
        if (device != null) {
            System.out.println("找到设备：");
            device.displayInfo();
        }else {
            System.out.println("设备不存在！");
        }
        boolean updated = repository.updateStatus(999, DeviceStatus.STOPPED);
        System.out.println(updated);

        boolean deleted = repository.deleteById(5);
        System.out.println(deleted);
    }
}
