package com.industrial.controller;

import com.industrial.model.Device;
import com.industrial.repository.DeviceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController: 向Spring声明此类负责HTTP请求，并把返回值直接作为响应返回
@RestController
public class DeviceController {

    private DeviceRepository deviceRepository = new DeviceRepository();

    //@GetMapping: 当有人使用GET请求访问“/devices”时，执行以下方法
    @GetMapping("/devices")
    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

}
