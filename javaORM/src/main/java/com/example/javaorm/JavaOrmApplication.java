package com.example.javaorm;
import com.example.javaorm.entity.Category;
import com.example.javaorm.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.Permission;
import java.util.List;

@SpringBootApplication
public class JavaOrmApplication {
   private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.superapp-PU");
    public static void main(String[] args) {

        SpringApplication.run(JavaOrmApplication.class, args);
         //InserProduct(); // taạo banngr ,chèn data qua OOP, code FIRST
         getAllProducts(); //SELECT*FROM CODE FIRST OOP, CODE FIRST
      InsertCategory();
       getAllCategories();
    }
    public static void InserProduct(){
        // Gửi thông số cấu hình sever , nhà thau JPA : HIbernate, nhà thầu JDBC cho Class lo
        //Tạo kết nối tới CSDL cụ thể SQL sever
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.superapp-PU");
        //tạo ra 1 object để ql các entity class - mgang sang table.Class prodcut chịu su quan li của emf/EntityManager
        EntityManager em = emf.createEntityManager();
       //em/EntityManager sẽ lo CRUB lên 1 table nào đó
        //Toàn chơi Oject , đằng sau là Table bị ảnh hưởng -Tự sinh SQL ngầm , nó cho luôn câu lệnh khi minhf chấm các hàm trên
        //.persit() .find() .merge() .remove()

        //chuẩn bị data Product- (Oject nha , OPP nha)
        Product p11 = new Product(11,"Nike11",1000323,"shoe11.img",1);
        Product p12 = new Product(12,"Nike12",1222323,"shoe12.img",1);
        Product p13 = new Product(13,"Nike13",1333323,"shoe13.img",1);

        //xong thì gọi sếp EntityManager để CRUB: p11,p22,p13 (class Produc : mà thằng này chính là Table Product
        em.getTransaction().begin();// BẮT buộC TRAN khi có sự thay đổi trong DataBase
            em.persist(p11);     // create TABLE dien ra ngầm , gọi là code FIRST , code ra TABLE,DATA
            em.persist(p12);      //INSERT INTO PRODUCT
            em.persist(p13);
        em.getTransaction().commit();// nếu p11 xuống được thì p12 -> p13 được , nếu 1 trong 3 đứa không được thì back
          em.close();// sa thải ông sếp
        // đừng đóng emf kẻo thằng dưới không có mà xài
    }
 public static void getAllProducts(){
        //chú ý nếu để create ở đây thì sẽ mất data:thì nguyên đoạn per sẽ lăp lại
        // cắt nó vao static để dùng chung
       //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.giaolang.superapp-PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> products = em.createQuery(" FROM Product ",Product.class).getResultList();
        //JSQL , HSQL
     System.out.println("The list of  products is :");
     for(Product x:products){
         System.out.println(x.toString());
     }
     em.close();// sa thải ông sếp


                                  }
     public static void InsertCategory(){
        //opcion xml create, update đều được , đi làm thật thì câm option CREAT trên máy khách hàng
        EntityManager em = emf.createEntityManager();
         Category c1 = new Category(1,"Nike");
         Category c2 = new Category(2,"Adidas");
         Category c3 = new Category(3,"Puma");
         Category c4 = new Category(4,"MLB");
         Category c5 = new Category(5,"Champion");

        //vì có thay đổi trên csdl nên theo dõi các câu lệnh bằng transtraction[Hoặc tất cả hoặc khôg gì cả]
         //rớt 1/n thì rool back
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);
        em.getTransaction().commit();
    em.close();
     }
     public static void getAllCategories(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Category> categories = em.createQuery("FROM Category",Category.class).getResultList();
        System.out.println("The list of  categories is :");
        for(Category x:categories){
            System.out.println(x.toString());
        }
     }

    }



