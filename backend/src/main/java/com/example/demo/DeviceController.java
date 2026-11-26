// package:声明包的关键字
package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@RestController
public class DeviceController {
    private DeviceService deviceService;
    DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/devices")
    public List<Device> listDevices(){
        return deviceService.listDevices();
    }

    @PostMapping("/devices")
    public ResponseEntity<Device> createDevice(@Valid @RequestBody DeviceRequest request){
        Device created = deviceService.createDevice(request);
        return ResponseEntity.status(201).body(created);
    }
}
// 文件名含义：设备控制器，接收前端关于设备的请求（Controller就是接口入口）

