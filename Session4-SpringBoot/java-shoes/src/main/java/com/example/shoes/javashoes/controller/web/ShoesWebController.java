package com.example.shoes.javashoes.controller.web;

import com.example.shoes.javashoes.entity.Shoes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // thằng này là bean được tự new từ đầu bời IOC container , chuyên trả lời các
// request đến từ url của trình duyệt web server
//có nhiều url khác nhau , thì ứng với nhiều hàm trong class này
// các hàm trả về html , trang web lung linh
public class ShoesWebController {
    @GetMapping("/") // uses gõ localhost8386: nhảy đến hàm này
    public String home(Model model) {
            model.addAttribute("shoes1", "Nike af1");
            model.addAttribute("shoes2", new Shoes(1,"GIÀY AF2","af2",20000));
        return "index"; // trả về cái trang cho trình duyệt

    }
}
