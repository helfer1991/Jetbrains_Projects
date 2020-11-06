/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stage2;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = ler.nextInt();
        
        System.out.println("Enter the number of seats in each row:");
        int seats = ler.nextInt();
        System.out.println("Total income:");
        System.out.println("$"+returnIncome(rows,seats));
    }
    
    public static int returnIncome(int rows, int seats) {
        int income = 0, backSeats;
        
        if(rows*seats <= 60) {
            income = 10*rows*seats;
        } else {
            backSeats = rows*seats - rows/2*seats;
            income = rows/2*seats*10 + backSeats*8;
        }
        return income;
    }
}
