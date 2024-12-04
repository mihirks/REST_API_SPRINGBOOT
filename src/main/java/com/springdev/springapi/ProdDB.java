package com.springdev.springapi;

public class ProdDB implements DB{
    @Override
    public String getData(){
        return "Prod DB";
    }
}
