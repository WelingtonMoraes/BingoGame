/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 *
 * @author welin
 */
public class SoketControl {
    
    public static Socket conectServer() throws UnknownHostException, IOException {
        System.out.println("estabelecendo conexao");
        Socket socket = new Socket("localhost", 5555);
        return socket;
    }
    
    public static String receber() throws UnknownHostException, IOException {
       
        ObjectOutputStream output = new ObjectOutputStream( SoketControl.conectServer().getOutputStream());
        ObjectInputStream input = new ObjectInputStream(SoketControl.conectServer().getInputStream());
        String msg = "ok";
        output.writeUTF(msg);
        output.flush();
        msg = input.readUTF();
        return msg;
    }
    
    public static void enviar(String msg) throws UnknownHostException, IOException {
        
        ObjectOutputStream output = new ObjectOutputStream( SoketControl.conectServer().getOutputStream());
        output.writeUTF(msg);
        output.flush();
    } 
}
