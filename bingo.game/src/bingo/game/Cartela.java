/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo.game;

import java.util.Random;

/**
 *
 * @author welin
 */
public class Cartela {
    public static int[] gerarCartela() {
        
        int[] cartela = new int[9];
        //instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
         
        //imprime sequência de 10 números inteiros aleatórios
        for (int i = 0; i < 9; i++) {
            cartela[i] = (gerador.nextInt(99));
        }
        return cartela;
    }
    
    public static int[] marcaCartela(int[] cartela, int num ) {
        
        //instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
        
        for (int i = 0; i < 9; i++) {
            if(cartela[i] == num){
                cartela[i] = 00;
            }    
        }
        return cartela;
    }
}
