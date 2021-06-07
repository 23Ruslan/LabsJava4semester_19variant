package com.company;

public class PhotoAlbum extends Page {
    public PhotoAlbum() {
        super();
    }
    public void show() {
        System.out.println("PhotoAlbum: " + '{' + this.getX() + ',' + this.getY() + "}"
                + " "  + " создан!");
    }
    public void show1(Photo point1) {
        System.out.println("PhotoAlbum: " + '{' + this.getX() + ',' + this.getY() +
                ',' + point1.getX() + ',' + point1.getY() + "}"
                + " "  + " создан!");
    }
    public int determining(Photo point1) {
        if ( this.getX().equals(point1.getX()) | this.getY().equals(point1.getY()) |
             this.getX().equals(point1.getY()) | this.getY().equals(point1.getX()) ) {return 2;}
            else {
            return 1;
        }
    }
}