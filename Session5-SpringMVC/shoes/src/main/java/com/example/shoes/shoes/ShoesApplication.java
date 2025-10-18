package com.example.shoes.shoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//class này là class trung tâm,nơi chứa các khai báo  về các loại bean có trong app này
public class ShoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoesApplication.class, args);
    }

}
