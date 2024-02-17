package com.basic.learning.programs;

public class Ticket {

    public Ticket(){}
    private String destination; //Using private var and accessing via public getter setter in any class- Encapsulation
    private double price;
    private boolean isReturn;

    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setisReturn(boolean isReturn){
        this.isReturn = isReturn;
    }
    public String getDestination(){
        return destination;
    }
    public double getprice(){
        return price;
    }
    public boolean getisReturn(){
        return isReturn;
    }

    public static void main(String args[]){
//        String menuTitle = "My Dream Meanu:";
//        System.out.println(menuTitle);
//        ArrayList<NearestPoint> menu = new ArrayList<>();
//        NearestPoint pnt = new NearestPoint();
//        menu.add(pnt);
    }

}
