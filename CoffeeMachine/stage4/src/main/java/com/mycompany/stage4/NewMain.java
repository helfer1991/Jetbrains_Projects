/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stage4;
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
    static int WATER = 400;
    static int MILK = 540;
    static int COFFEE = 120;
    static int MONEY = 550;
    static int DISP_CUPS = 9;
    
    public static void main(String[] args) {
        machineHas();
        
        System.out.println("Write action (buy, fill, take):");
        String action = ler.nextLine();
        
        switch(action) {
            case "buy":
                buy();
                machineHas();
                break;
            case "fill":
                fill();
                machineHas();
                break;
            case "take":
                take();
                machineHas();
                break;
        }
        
//        For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
//        For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
//        And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.

            
    }
    
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int product = ler.nextInt();
        DISP_CUPS -= 1;
        
        switch(product) {
            case 1:
                WATER -= 250;
                COFFEE -= 16;
                MONEY += 4;
                break;
            case 2:
                WATER -= 350;
                MILK -= 75;
                COFFEE -= 20;
                MONEY += 7;
                break;
            case 3:
                WATER -= 200;
                MILK -= 100;
                COFFEE -= 12;
                MONEY += 6;
                break;
        }
    }
    
    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = ler.nextInt();
        WATER += addWater;
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = ler.nextInt();
        MILK += addMilk;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffe = ler.nextInt();
        COFFEE += addCoffe;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = ler.nextInt();
        DISP_CUPS += addCups;
    }
    
    public static void take() {
        System.out.println("I gave you " + MONEY);
        MONEY = 0;
    }
    
    public static void machineHas (){
        System.out.println("The coffee machine has:");
        System.out.println(WATER + " of water");
        System.out.println(MILK + " of milk");
        System.out.println(COFFEE + " of beans");
        System.out.println(DISP_CUPS + " of disposable cups");
        System.out.println(MONEY + " money");
    }
    
}
