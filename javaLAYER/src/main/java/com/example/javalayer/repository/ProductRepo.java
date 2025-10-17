package com.example.javalayer.repository;

import com.example.javalayer.entity.Product;
import com.example.javalayer.infra.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductRepo
{
//CLASS NÀY CHỨA CÁCC HÀM CRUD TRỰC TIẾP TABLE product
    //muốn crud table thì phải nhờ ông Entity-Manager được cấp từ JPAUtil
    //UI---SERVICE---REPO(ĐÂY)-----JPAUTILL(Entity Mânger, Factory)
// CÁC HÀM CRUD Ở ĐÂY THƯỜNG ĐẶT TÊN NGẮN GỌN, HƯỚNG HÀNH ĐỘNG GIỐNG SQL CHUẨN
    // save(),update(),delete(),remove(),find(),findBy()
    //tuỳ hamf , nhma nếu thay đổi table , hàm nhận vào opject(insert,update),hoặc key(delete)
   //nhớ dùng transaction cho(I,U,D)
    //hàm INSERT xuống DATABASA:
  public void  save(Product product){
      //gọi EntityManager nhờ giúp kèm transaction , kh gọi emf vì emf đã tạo r
      EntityManager em = JpaUtil.getEntityManager();
     em.getTransaction().begin();
     em.persist(product);
     em.getTransaction().commit();
     em.close(); // đừng đóng emf nka !
  }
   // hàm láy all SV:
    public List<Product> findAll(){
        EntityManager em = JpaUtil.getEntityManager();
        List<Product> products = em.createQuery("from Product",Product.class).getResultList();

        return products;
    }
    //sửa thông tin sản phâm -cập nhật
    public  void update(Product product){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(product);//tich hop objec dua vao trong em
    em.getTransaction().commit();
    }
    //xoá sản phẩm theo id
    public void delete(int id){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class,id));
        em.getTransaction().commit();
    }
    //làm thêm hàm where theo COT nào đó  , findBy(id) trả về 1 product
}
