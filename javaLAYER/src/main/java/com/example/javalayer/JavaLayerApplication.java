package com.example.javalayer;

import com.example.javalayer.entity.Product;
import com.example.javalayer.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaLayerApplication {
//UI------SERVICE
    public static void main(String[] args) {
        SpringApplication.run(JavaLayerApplication.class, args);
        ProductService productService = new ProductService();
        //1: tạo mới hồ sơ product:
        //Product s1=new Product("Nike",1,1,123231,"shoes1.img");
       // Product s2=new Product("Adidas",2,2,123231,"shoes2.img");
        //Product s3=new Product("Puma",3,3,123231,"shoes3.img");
      //  Product s4=new Product("Converse",4,4,123231,"shoes4.img");
       // Product s5=new Product("Fantom",5,5,123231,"shoes5.img");
        //productService.createProduct(s1);
       // productService.createProduct(s2);
        //productService.createProduct(s3);
       // productService.createProduct(s4);
        //productService.createProduct(s5);
        //2: show all:
        System.out.println("The list of products has been created: ");
     productService.getAllProducts().forEach(System.out::println);
        //3: update:
       // Product s5=new Product("MLB",5,5,123231,"shoes5.img");
       // productService.updateProduct(s5);
       // System.out.println("The product has been updated");
      //  productService.getAllProducts().forEach(System.out::println);
        //delete: còn 4 thằng
        productService.deleteProduct(5);
        System.out.println("The product has been deleted");
    }





}
