package com.springdev.springapi;

public class DevDB implements DB{
    @Override
    public String getData(){
        return "Dev DB";
    }
}
