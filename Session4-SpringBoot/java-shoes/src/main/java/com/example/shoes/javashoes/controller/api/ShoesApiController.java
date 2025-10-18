package com.example.shoes.javashoes.controller.api;

import com.example.shoes.javashoes.entity.Shoes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //phụ vụ các url mà muốn lấy data thô , trả ve JSON
// hoac nhận JSON từ web gửi lên
//thường url API tách hẳn so với url của wen
//http:...../api/v1/???
//........../api/v2/???
@RequestMapping("/api/v1")
public class ShoesApiController {
    @GetMapping("/couple") //localhost:8386/api/v1/cup
public Shoes getShoes(){
 return new Shoes(1,"adidas","Adisdas Campus",2000000);//lấy từ DB lên qua Service/Repository/JPA-Hipernate/JDBC/Table
}
//data thôi: web API : gọi hàm qua URL trả về JSON
    //SwaggerUI: hellp,document chứa url dùng thử api


    //em muốn gui data lên sever,JSON guiwr lên, xửi lí giúp em
    @PostMapping("/add")
   public Shoes addShoes(Shoes shoes){
 //sửa objectdđã nhận,xong trả về mn bt mình đã nhânj từ cline,chỉnh ít info
        String  oldName = shoes.getName();
        String  newName = oldName + "đẹp trai 123213213";
        shoes.setName(newName);
     return shoes;// đã chỉnh info
    }
}
