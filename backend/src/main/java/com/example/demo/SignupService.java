package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

// @Service 是给类贴的标签，告诉 Spring：这是一个业务类，启动时请创建它的对象并管起来。
    // 作用和 @RestController 类似：
@Service 
public class SignupService {
    
    private final SignupRepository signupRepository;
    
    public SignupService (SignupRepository signupRepository){
        this.signupRepository = signupRepository;
    }

    public List<Signup> listSignups(){
        return signupRepository.findAll();
    }

    // public：公开方法，Spring能从别的包调用
    // Signup：返回值类型：方法最后必须返回一个Signup对象
    // @RequestBody：注解：告诉Spring从HTTP请求体中读JSON，再转成Java对象
    // SignupRequest：参数类型：把JSON转成SignupRequest这种对象
    // request：参数变量名，接住转出来的对象
    public Signup createSignup(SignupRequest request){
        Signup signup = new Signup(
            // 为什么是request.name()而不是request.name？
            // 因为SignupRequest是record，record对外读数据用的是同名方法，所以加括号
            request.name(),
            request.major(),
            request.gender(),
            request.interests()
        );
        return signupRepository.save(signup);

    }
}


