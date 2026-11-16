// package:声明包的关键字
package com.example.demo;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DeviceController {
    @GetMapping("/devices")
    public List<Map<String,String>> listDevices(){
        return List.of(
            Map.of("name","Go2"),
            Map.of("name","As2")
        );
    }
}
// 文件名含义：设备控制器，接收前端关于设备的请求（Controller就是接口入口）

