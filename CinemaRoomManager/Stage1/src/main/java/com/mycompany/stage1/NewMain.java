/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stage1;

/**
 *
 * @author Asus
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Cinema:");
        for(int i = 0; i < 8; i++) {            
            if(i > 0) {
                System.out.printf("%d", i);
            }
            for(int j = 0; j < 9; j++) {
                if(i == 0) {
                    if(j == 0) {
                        System.out.printf("  ");
                    } else {
                        System.out.printf("%d ", j);
                    }
                } else {
                    if(j < 8) {
                        System.out.printf(" S");                        
                    }
                }         
            }
            System.out.println();
        }
    }
    
}
