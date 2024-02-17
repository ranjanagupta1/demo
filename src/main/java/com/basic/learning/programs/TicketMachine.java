package com.basic.learning.programs;

public class TicketMachine {
    public static void main(String args[]){
        Ticket ticket = new Ticket();
        ticket.setDestination("Newyork");
        ticket.setPrice(10.30);
        ticket.setisReturn(true);
        System.out.println(ticket.getDestination() + " " + ticket.getprice() + " " + ticket.getisReturn());
    }
}
