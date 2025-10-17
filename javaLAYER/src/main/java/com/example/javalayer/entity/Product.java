package com.example.javalayer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product") //biến thành TABLE
public class Product
{
    @Id
    @Column(name="id")
    int id;

    @Column(name="name")
   String name;

    @Column(name="price")
   double price;
    @Column(name="img")
   String image;
    @Column(name="cid")
   int cid;

    public Product() {
    }

    public Product(String name, int id, int cid, double price, String image) {
        this.name = name;
        this.id = id;
        this.cid = cid;
        this.price = price;
        this.image = image;
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
