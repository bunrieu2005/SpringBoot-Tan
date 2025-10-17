package com.example.javalayer.infra;
//KI THUAT SINGLETON : dành cho những class chạy duy nhất 1 lần trong RAM , KHÔNG được new nhiều lần
//CLASS này chịu trách nhiem ket noi CSDL thông qua EntityManagerFactory emf,HAO RAM ,time để kết nối SQL SERVER

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class JpaUtil {

    private static final EntityManagerFactory emf ;
    static{
        try{
            emf = Persistence.createEntityManagerFactory("com.giaolang.superapp-PU");//load thong tin server tu file percisten.xml
            
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    private  JpaUtil(){}


    public static EntityManager getEntityManager() {
        return emf.createEntityManager();

    }
}


