/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stage4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args) {
        int action, chosenRow = 0, chosenSeat = 0, purchasedTickets = 0, currentIncome = 0, price = 0;    
        
        System.out.println("Enter the number of rows:");
        int rows = ler.nextInt();
        
        System.out.println("Enter the number of seats in each row:");
        int seats = ler.nextInt();
        
        String[][] matrix = new String[rows+1][seats+1];
        fillSeats(matrix, rows, seats);
        showSeats(matrix,rows,seats);

        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            action = ler.nextInt();
            
            switch(action) {
                case 1:
                    showSeats(matrix, rows, seats);
                    break;
                case 2:
                    price = fillSeat(matrix, chosenRow, chosenSeat, rows, seats);
                    purchasedTickets++;
                    currentIncome += price;                    
                    System.out.println("Ticket price: $" + price);
                    break;
                case 3:
                    showStats(purchasedTickets, seats, rows, currentIncome);
                    break;
                case 0:
                    break;
            }
        } while(action != 0);
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
    
    public static void fillSeats(String[][] matrix, int rows, int seats) {
        for(int i = 0; i <= rows; i++) {
            if(i > 0) {
                matrix[i][0] = String.valueOf(i);
            }
            for(int j = 0; j <= seats; j++) {
                if(i == 0)  {
                    if(j == 0) {
                        matrix[i][j] = " ";
                    } else {
                        matrix[i][j] = String.valueOf(j);
                    }
                } else {
                    if(j > 0) {
                        matrix[i][j] = "S";                        
                    }
                }
            }
        } 
    }
    
    public static void showSeats(String[][] matrix, int rows, int seats) {
        System.out.println("Cinema:");
        for(int k = 0; k <= rows; k++) {
            for(int l = 0; l <= seats; l++) {
                System.out.printf(" %s", matrix[k][l]);
            }
            System.out.println();
        }
    }    
        
    public static int fillSeat(String[][] matrix, int chosenRow, int chosenSeat, int rows, int seats) {
        boolean flag = false;
        do {
            System.out.println("Enter a row number:");
            chosenRow = ler.nextInt();
            System.out.println("Enter a seat number in that row:");
            chosenSeat = ler.nextInt();
            
            if(chosenRow <= rows && chosenSeat <= seats) {                
                if(checkSeat(matrix, chosenRow, chosenSeat)) {
                    System.out.println("That ticket has already been purchased");
                } else {
                    matrix[chosenRow][chosenSeat] = "B";
                    flag = true;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while(!flag);
        return returnIncome(rows, seats, chosenRow);
    }
    
    public static boolean checkSeat(String[][] matrix, int chosenRow, int chosenSeat) {
        return matrix[chosenRow][chosenSeat].equalsIgnoreCase("B");
    }
    
    public static void showStats(int purchasedTickets, int seats, int rows, int currentIncome) {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        float percentage = (float) purchasedTickets * 100 / (seats*rows);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome(rows, seats));
    }
    
    public static int totalIncome(int rows, int seats) {
        int total = 0;
        if(seats * rows <= 60) {
            total = 10 * seats * rows;
        } else {
            total = rows/2 * seats * 10 + (rows - rows/2) * seats * 8;
        }
        return total;
    }
}
