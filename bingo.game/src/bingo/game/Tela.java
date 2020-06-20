/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo.game;

import java.io.IOException;
/**
 *
 * @author welin
 */
public class Tela {
    public void display(int[] cartela, int num) {
        cartela = cartela;
        num = num;
        
        System.out.println("");
        System.out.println("   Numero sorteado");
        System.out.println("");
        System.out.println("      ________");
        System.out.println("      |  "+ num +"  |");
        System.out.println("  -----------------");
        System.out.println("");
        System.out.println("  ____  ____  ____");
        System.out.println("  |"+cartela[0]+"|  |"+cartela[1]+"|  |"+cartela[2]+"|");
        System.out.println("  ____  ____  ____");
        System.out.println("  |"+cartela[3]+"|  |"+cartela[4]+"|  |"+cartela[5]+"|");
        System.out.println("  ____  ____  ____");
        System.out.println("  |"+cartela[6]+"|  |"+cartela[7]+"|  |"+cartela[8]+"|");
        System.out.println("  ----  ----  ----");  
    }
}
