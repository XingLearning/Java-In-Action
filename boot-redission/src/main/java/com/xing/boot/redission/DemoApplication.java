package com.xing.boot.redission;

import com.xing.boot.redission.service.AsyncService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 简要描述
 *
 * @author yangweixing
 * @date $ $
 */
@SpringBootApplication
@RestController
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Resource
    AsyncService as;


    @GetMapping("")
    public void test(){
        for(int i = 0 ;i<10000;i++){
            as.addNoAsync();
        }
    }

    @GetMapping("lock")
    public void  test2(){
        for(int i = 0 ;i<10000;i++){
            as.addAsync();
        }
    }
}
