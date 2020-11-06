/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stage3;

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
        
        showSeats(rows, seats, 0, 0);
        
        System.out.println("Enter a row number:");
        int chosenRow = ler.nextInt();
        
        System.out.println("Enter a seat number in that row:");
        int chosenSeat = ler.nextInt();
        
        System.out.println("Ticket price: $" + returnIncome(rows, seats, chosenRow));
        showSeats(rows, seats, chosenRow, chosenSeat);
    }
    
    public static int returnIncome(int rows, int seats, int chosenRow) {
        int price = 0;
        
        if(rows*seats <= 60) {
            price = 10;
        } else {
            if(chosenRow <= rows/2) {
                price = 10;
            } else {
                price = 8;
            }
        }
        return price;
    }
    
    public static void showSeats(int rows, int seats, int chosenRow, int chosenSeat) {
        System.out.println("Cinema:");
        for(int i = 0; i <= rows; i++) {            
            if(i > 0) {
                System.out.printf("%d", i);
            }
            for(int j = 0; j <= seats; j++) {
                if(i == 0) {
                    if(j == 0) {
                        System.out.printf("  ");
                    } else {
                        System.out.printf("%d ", j);
                    }
                } else {
                    if(j < seats) {
                        if(i == chosenRow && j == chosenSeat - 1) {
                            System.out.printf(" B");
                        } else {
                            System.out.printf(" S");                            
                        }                        
                    }
                }         
            }
            System.out.println();
        }
    }
}
