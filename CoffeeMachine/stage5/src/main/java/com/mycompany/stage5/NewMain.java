/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stage5;

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
        String action;        
            
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = ler.nextLine();

            switch(action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                     machineHas();
                     break;
                case "exit":
                    break;
            }
        } while(!action.equalsIgnoreCase("exit"));
    }
    
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int product = ler.nextInt();
        ler.nextLine();
        
        switch(product) {
            case 1:
                if(WATER >= 250 && COFFEE >= 16) {
                    printMakeCoffe();
                    WATER -= 250;
                    COFFEE -= 16;
                    DISP_CUPS -= 1;
                    MONEY += 4;
                } else if(WATER < 250) {
                    printNoResources("water");
                } else {
                    printNoResources("coffee");
                }
                break;
            case 2:
                if(WATER >= 350 && MILK >= 75 && COFFEE >= 20) {
                    printMakeCoffe();
                    WATER -= 350;
                    MILK -= 75;
                    COFFEE -= 20;
                    DISP_CUPS -= 1;
                    MONEY += 7;
                } else if(WATER < 350) {
                    printNoResources("water");
                } else if(MILK < 75) {
                    printNoResources("milk");
                } else {
                    printNoResources("coffee");
                }
                break;
            case 3:
                if(WATER >= 200 && MILK >= 100 && COFFEE >= 12) {
                    printMakeCoffe();
                    WATER -= 200;
                    MILK -= 100;
                    COFFEE -= 12;
                    DISP_CUPS -= 1;
                    MONEY += 6;
                } else if(WATER < 200) {
                    printNoResources("water");
                } else if(MILK < 100) {
                    printNoResources("milk");
                } else {
                    printNoResources("coffee");
                }
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
    
    public static void printMakeCoffe() {
        System.out.println("I have enough resources, making you a coffee!");
    }
    
    public static void printNoResources(String res) {
        System.out.println("Sorry, not enough " + res + "!");
    }
}
