
package com.example.javalayer.service;

import com.example.javalayer.entity.Product;
import com.example.javalayer.repository.ProductRepo;

import java.util.List;

public class ProductService {
    //class này hứng info từ uses, Tạo product đẩy xuống cho Repo lo giúp
    //nhờ repo lấy product từ table , đẩy ngược lên ui cho use xem
    //UI -----------(SERVICE)----------REPO--------JPAUNTILL------TABLE
    private final ProductRepo productRepo = new ProductRepo();
    //dùng chung
    public void createProduct(Product product) {
   productRepo.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public void updateProduct(Product product) {
        productRepo.update(product);

    }
    public void deleteProduct(int id) {
        productRepo.delete(id);
    }
}
