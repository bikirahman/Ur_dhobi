package com.example.urdhobi;

public class user {
    String id;
    String number;
    String address;
    public user(String id,String number,String address){
        this.id=id;
        this.number=number;
        this.address=address;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }
}
