package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
// Spring 启动扫描到带这个注解的类，才会去 创建它的对象
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
// 类
// 文件名是SignupController.java是因为文件里的公开类是 public class SignupController
// 文件名必须与公开类名一致
public class SignupController {

    // 声明   类型和变量名    这里的变量名记作 R1
    // 这行是在 Controller 里准备一个格子（变量），名字叫 signupRepository。
    // 类里写了字段，每个 new 出来的 Controller 对象都会自带这个格子。
    private final SignupService signupService;   

    // SignupController：构造器
    // 判断构造器：
            // 名字与类名 SignupController 完全相同。
            // 前面没有 void 等返回类型。
            // 不能被static、final等修饰
    // 上面的类和这里的构造器必须同名，是语法规定。构造器属于这个类，不代表类本身变成了构造器。
    // SignupRepository：参数的数据类型，是接口引用类型。
    // signupRepository：参数变量名，临时接收 Spring 传来的对象引用。记作 R2  
        // 为什么？Spring 创建 Controller 时，相当于：
        // new SignupController( 仓库 );
        // 在 Java 里：括号里传进来的，对应的是构造器括号里声明的参数（你的第 32 行附近），这是写法规定。
    // Spring传入的是：Spring Data JPA在启动时生成的、实现了 SignupRepository 接口的代理对象引用。
    public SignupController(SignupService signupService) {
        // this指正在被创建的这个 SignupController 对象本身。
        // this.signupRepository：该 Controller 对象的字段。
        // 左边的 signupRepository 就是上面的 R1
        // 赋值
        // 右边的signupRepository：构造器参数，也就是上面的 R2
        this.signupService = signupService;
    }

    @GetMapping("/signups")
    public List<Signup> listSignups() {
        return signupService.listSignups();
    }

    @PostMapping("/signups")
    // request：方法参数。
    public ResponseEntity<Signup> createSignup(@Valid @RequestBody SignupRequest request) {
        Signup created = signupService.createSignup(request);
        return ResponseEntity.status(201).body(created);
    }
}
// 文件名含义：注册接口控制器，前端发注册请求，先到这个类，@PostMapping写在这里，接收请求、调用逻辑