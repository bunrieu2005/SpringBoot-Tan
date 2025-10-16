package com.example.javaorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

// CLASS nay duoc khai bao de bien doi/ anh xa , map thanh TABLE tuong ung:
@Entity //bao rang day no se bien thanh TABLE
@Table(name="Product") // neu khong co thong bao nay thi mac dinh lay ten class thanh ten table
public class Product {
@Id
    @Column(name="id") // lay ten cot
    int id;

    @Column(name="name")
    String name;

    @Column(name="price")
    double price;

    @Column(name= "image")
    String image;

    @Column(name="cid")
    int cid;




    //SAU NÀY KHÔNG CẦN LÀM TAY NỮA , THÊM DEPENDENCY LOMBOX VÀO trên mvnrepositor
    public Product(){
    }
    public Product(int id, String name, double price, String image, int cid) {
        this.id = id;
        this.name = name;

        this.price = price;
        this.image = image;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }





    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", price=" + price +
                ", image='" + image + '\'' +
                ", cid=" + cid +
                '}';
    }
}
