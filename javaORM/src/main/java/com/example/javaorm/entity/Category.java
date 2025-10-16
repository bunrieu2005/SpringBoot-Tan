package com.example.javaorm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
//SU DỤNG VỚI LOMBOX ĐỂ RÚT GỌN CODE JAVA:
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity // ánh xạ class này thành 1 table tương ứng với
@Table(name="Category")
public class Category
{
    @Id
    @Column(name="cid")
    private int cid;

    @Column(name="cname")
    private String cname;

}


