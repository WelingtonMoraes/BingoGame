
package bingo.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BingoGame {

    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        try{
        
            System.out.println("estabelecendo conexao");
            Socket socket = new Socket("localhost", 5555);
            System.out.println("conexao estabelecida");
            ObjectOutputStream output = new ObjectOutputStream( socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Scanner sk = new Scanner(System.in);
            Tela t = new Tela();
            Cartela c = new Cartela();
            
            int[] cartela = c.gerarCartela();
            int win = 0;
            
            while(win == 0){
                output.writeInt(win);
                output.flush();

                int num = input.readInt();
                t.display(cartela, num);
                c.marcaCartela(cartela, num);
                System.out.println("Gritar bungo ?");
                System.out.println("1 - sim");
                System.out.println("2 - não");
                int x = sk.nextInt();
                if(x == 1){
                    win = verificaWin(cartela);
                    if(win == 1){
                        System.out.println("BINGOOOOOOO !!!");
                        System.out.println("Voce ganhou");
                    }
                }else{
                  System.out.println("Continua o jogo");  
                } 
            }   
          
        }catch(IOException ex){
            System.out.println("erro no cliente");
            Logger.getLogger(BingoGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Scanner teclado = new Scanner(System.in);
    }
    
    public static int verificaWin(int[] cartela) {
       
        int num = 0;
        for (int i = 0; i < 9; i++) {
            if(cartela[i] != 0){
                num = 0;
                System.out.println("Não foi bingo");
                break;
            }else{
                num = 1;
            }    
        }
        return num;
    }
}
