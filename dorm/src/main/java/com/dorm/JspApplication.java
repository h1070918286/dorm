package com.dorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dorm.mapper")
public class JspApplication {
    //注意:不要直接启动该类,要以spring-boot:run命令方式启动才行,否则404!!!
    public static void main(String[] args) {
        SpringApplication.run(JspApplication.class, args);
    }
}
