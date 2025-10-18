package com.example.shoes.javashoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//BAO :@ConfigBootApplication
//     @ComponentScan()scann ngay những class trong .shoes chứa @Service,@Repository,@RestController
//     @new những đứa này tiêm chúng vào những class tương ứng
// @EnableAutoConfiguration : tự neww tự cấu hình: JPA Hypernate,TomCat,MVC
@SpringBootApplication
public class JavaShoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaShoesApplication.class, args);
    }
//@Bean o day để chủ động new riêng  những dependency new xong gửi cho IOC:

}
