package com.example.flagapp;

public class Item {

    private String txtItem;
    private int imgItem;


    public Item(String txtItem, int imgItem) {
        this.txtItem = txtItem;
        this.imgItem = imgItem;
    }

    public String getTxtItem() {
        return txtItem;
    }

    public int getImgItem() {
        return imgItem;
    }
}
