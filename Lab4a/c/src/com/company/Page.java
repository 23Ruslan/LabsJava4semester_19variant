package com.company;
public class Page extends Photo {
    private int page_number;

    public Page(){
        super();
    }
    public double getPage() {
        return page_number;
    }
    public void setPage(int page_number){
        this.page_number = page_number;
    }
    public void changeRadius(int change){
        this.page_number += change;
    }
}