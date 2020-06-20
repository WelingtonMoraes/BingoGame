
package bingo.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class BingoServidor {
    
    int port;
    ServerSocket server=null;
    Socket client=null;
    ExecutorService pool = null;
    int clientcount=0;
    
    private ServerSocket serverSocket;
    
    public static void main(String[] args){
        try{
            BingoServidor server = new BingoServidor();
            System.out.println("aguardando conexao...");
            server.criarServerSocket(5555);
            while (true){
                Socket socket = server.esperaConexao();
                System.out.println("cliente conectado");
                server.trataConexao(socket);
            }
        } catch (IOException e){
            //trata exceção
        }
    }
    
    private void criarServerSocket( int porta ) throws IOException{
        serverSocket = new ServerSocket(porta);
    }
    
    private Socket esperaConexao() throws IOException{
        Socket socket = serverSocket.accept();
        return socket;
    }
   
    private void fechaSocket(Socket s) throws IOException{
        s.close();
    }
    
    private void trataConexao( Socket socket ) throws IOException{
        //recebe e envia menssagens 
        try{
            ObjectOutputStream output = new ObjectOutputStream( socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            //protocolo
            int win = 0;
            
            while(win == 0){
                win = input.read();

                output.writeInt(NumRandom.gerarNum());
                output.flush();
                System.out.println(win);
            }
            input.close();
            output.close();
            
            //fim
        }catch(IOException e){
            //tratamento
            System.out.println("Problrmas no tratamento com o cliente: "+socket.getInetAddress());
            System.out.println("erro: " + e.getMessage());
        }finally{
            fechaSocket(socket);
        }
    }
}
