package com.company;
import java.util.Objects;
public class Photo {
    private String x;
    private String y;
    public void setX(String x1){
        x=x1;
    }
    public void setY(String y1){
        y=y1;
    }
    public String getX() {
        return x;
    }
    public String getY() {
        return y;
    }
    public Photo(){
        super();
    }
    public void show(){
        System.out.println(toString());
        System.out.println("-------------------------------");
    }
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo point = (Photo) o;
        return point.x.compareTo(x) == 0 &&
                point.y.compareTo(y) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}