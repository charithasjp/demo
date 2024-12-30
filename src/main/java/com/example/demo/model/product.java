package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product") 
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long code; 
    private String pname; 
    private float price;

    public product(){

    }
    public product(String pname,long code,float price){
        this.pname=pname;
        this.code=code;
        this.price=price;
    }
    
    
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    @Id
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    
    
    
}
