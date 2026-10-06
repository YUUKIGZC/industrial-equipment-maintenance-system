package com.industrial.controller;

import com.industrial.model.Device;
import com.industrial.model.DeviceStatus;
import com.industrial.repository.DeviceRepository;
import com.industrial.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController: 向Spring声明此类负责HTTP请求，并把返回值直接作为响应返回
@RestController
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //@RequestBody: 把 HTTP 请求体（body）里面的 JSON 字符串，自动转成 Java 对象。
    @PostMapping("/devices")
    public Device createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }
    //@GetMapping: 当有人使用GET请求访问“/devices”时，执行以下方法
    @GetMapping("/devices")
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }
    //@ResponseEntity
    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable int id) {
        Device device = deviceService.getDeviceById(id);

        if (device == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(device);
    }
    //@PathVariable: 获取路径变量，取值于URL路径{}占位符,@RequestParam： 获取查询参数，即？后参数
    @PutMapping("/devices/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable int id, @RequestParam DeviceStatus status){
        boolean updated = deviceService.updateStatus(id, status);

        if (!updated) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/devices/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable int id){
        boolean deleted = deviceService.deleteDevice(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
