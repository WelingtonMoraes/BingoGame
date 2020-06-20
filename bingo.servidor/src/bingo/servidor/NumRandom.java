/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo.servidor;

import java.util.Random;

/**
 *
 * @author welin
 */
public class NumRandom {
    
    public static int gerarNum() {
       
        //instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
        
        int num = (gerador.nextInt(99));
        
        return num;
    }
}
