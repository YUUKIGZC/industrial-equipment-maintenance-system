package com.industrial.controller;

import com.industrial.model.Device;
import com.industrial.model.DeviceStatus;
import com.industrial.repository.DeviceRepository;
import com.industrial.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController: 向Spring声明此类负责HTTP请求，并把返回值直接作为响应返回
@RestController
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //@GetMapping: 当有人使用GET请求访问“/devices”时，执行以下方法
    @GetMapping("/devices")
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }
    //@PathVariable: 获取路径变量，取值于URL路径{}占位符,@RequestParam： 获取查询参数，即？后参数
    @PutMapping("/devices/{id}/status")
    public boolean updateStatus(@PathVariable int id, @RequestParam DeviceStatus status){
        return deviceService.updateStatus(id, status);
    }

}
