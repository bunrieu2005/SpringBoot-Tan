package com.example.shoes.shoes.controller;

import com.example.shoes.shoes.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

//class này sẽ lo xử lí liên quan đến sản phẩm product bao gồm
//CRUD PRODUCT   ,xử lí Resquest,Response
//nó phụ trách url dính dáng đến crub product,nhưng lát hồi sẽ chuyển dần cho service,repo
//nó lắng nghe url, xem url nào phù hợp với ham trong classs này thì gọi hàm đó
//METHOD MAPPING với url
//Gồm 2 Việc:
//V1: nó phải là 1 bean được new tự động, vào ram lắng nghe
//V2:NGHE-mày là @Controller: bean và lắng nghe
//Hàm nào ứng vơis URL nào , trả về html
//QUAN TRỌNG : 1 URL GET->ỨNG VỚI 1 HÀM RETURN "Trang HTML nào đó"
@Controller
public class ProductController {
        @RequestMapping("/products")//url map voi hàm list() trả về trang: localhoos:8080/vutan
     public String list(Model model ){//show dssp nằm trong trang product.html
            model.addAttribute("key","Xin chào vũ tân");
            //hard-code test , thực tế thì gọi sever và repo , không cần new
            List<Product> productsL= new ArrayList<Product>();
            productsL.add(new Product("1","Nike",123213));
            productsL.add(new Product("2","Adidas",123213));
            productsL.add(new Product("3","Puma",123213));
            productsL.add(new Product("4","FanTon",123213));
            model.addAttribute("key2",productsL); //gửi key +thùng đồ
              return "products";//return trang-view ,không cần html thymleaf tuwj thêm
     }
     @GetMapping("/key2/edit/{pid}")//tach url thanh 2 phan , phan thay doi path vriavble
     public String showProductForm(Model model,@PathVariable("pid") String id){
            //TODO: DÙNG SERVICE GỌI REPO ĐỂ WHERE TRONG TABLE PRODUCT RA SP MỚI
         Product selectedProduct = new Product();
         if(id.equals("1")){
            selectedProduct = new Product("1","Nike",123213);
         } else if(id.equals("2")){
           selectedProduct=  new Product("2","Adidas",123213);
         }
         // ném vào thùng cho render
         model.addAttribute("key3",selectedProduct);



           return "product-form";
     }
     @PostMapping("products/edit")
//@RequestParrqam: nhap tung o cua form len sever,map  vao bien hung trog ham
     public String update(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("price") String price , Model model, RedirectAttributes redirectAttributes){
           redirectAttributes.addFlashAttribute("formMgs","da update -Moke mesage!!!!");
           redirectAttributes.addFlashAttribute("pname",name);
           // 2 lệnh này sẽ vô dụng nếu chơi redirect
         //redirectAttributes.addFlashAttribute("msg","da update!!!!");
         //redirectAttributes.addFlashAttribute("pname",name);
            //return"result";
        // return "redirect:/msg";//gọi url đổi trên trinhd duyệt ln , lỡ f5 thì là f5 của result k còn f5 post nx
     return "redirect:/products";
        }

    @GetMapping("/mgs")
    public String result(Model model){
 //làm sao lấy được name ở bên post
            //1 url 1 hàm tương ứng , 1 thùng modal tương ứng mới tính để ta bỏ đô vô trước khi return
        //kĩ thuật chuyển data từ model kia sang model này ở Redirect.lí do redirect laf gọi url moiws
        //trươ khi redirect, gửi ké thêm data từ model cũ sang model mơi
        //từ ,model của post , ké sang model thằng get này
        //MODEL chính chủ + ké thêm bên POST gửi sang
            return  "result";
    }

     //vơi hàm post bản chất là get nhưng gửi càng nhiều data khi get
    // khi hàm post trả về 1 trang kq qua lệnh return"tentrang"
    //thì url post vẫn giữ nguyên ,trong khi đó thân trang có data được trả về -trang trả về
    //hiện tượng url get i chang ,trong khi đó thân trang có data được trả về - trang trả về
    //ý nghĩa của việc giữ nguyên url: gọi hàm khi kq trả
    //NHƯNG VỚI F5 VỚI POST: vẫn trả về nhưng gửi lại đống data
    //Resubmid Form,giống như nhấn lại submit
    //Cực kì nguy hiểm với tính năng create,chạy lại xử l->doublecateddataa
    //cách xử lí: Redirect Method: định hướng lại url ,gọi url mới nhưng cùng kết quả trả về
}
//KHI CONTROLLER TÌM THẤY HÀM XỬ LÍ URL TƯNG ỨNG , NHƯNG GỬI CHO HÀM 1 THÙNG CHỨA ĐỒ RỖNG GỌI LÀ
//MODAL: NHÉT DATA VÀO THÙNG CHỨA NÀY, THÙNG ĐỒ ĐC NEW TỰ ĐÔNG VÀ CHÍCH VÀO HÀM XỬ LÍ URL
//khi return , thì spring boot sẽ đính kèm cái thùng đồ cùng trang trả về,đưa tên trang + thùng đồ thymleaf mix,trộn
//thymeleaf lấy đồ trong thùng , trộn với tag html,trộn xong  trả cho tomcat trang html ngon
//CÂU HỎI : LÀM SAO NHÉT ĐỒ VÀO THÙNG
//CONTROLLER là nhét đồ vào thùng;
//html/thymleaf lấy đồ ra và mix

//VIS DỤ : Bỏ đồ vào tủ :Chìa Khoá gọi là key , mon đồ  gọi là value
//có chìa khoá /key thì laays được món đồ/value

//Controller:GỬI ĐỒNG VÀO THÙNG
//modal.addAtrribute(key ,          value)
                    //chuỗi         //object b muốn cất



//lát hồi bên trang view , lấy đồ thì dùng key
//   ${tên-kêy} -> trả về món đồ