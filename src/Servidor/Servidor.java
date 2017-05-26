package Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable{

    public Servidor() {
        Thread t= new Thread(this, "server");
        t.start();
    }
    
    
    
    @Override
    public void run() {
        try {
           
            //1:ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            //2.Escuchando conexion de un cliente
            System.out.println("Servidor esperando conexiones");
            int numero=2;
            Canal cliente [] = new Canal [numero];
            Socket socket[]= new Socket [numero];
            for (int i = 0; i < numero; i++) {
                socket[i]= serverSocket.accept();
                System.out.println("Se ha conectado cliente "+(i+1));
                cliente[i]= new Canal();
                cliente[i].inicializar(socket[i]);                
            }
            
        String mensajeLeido="";   
        while(true){
            for (int i = 0; i < numero; i++) {                    
                mensajeLeido= cliente[i].escribirMensaje(cliente[i].getSc());
                cliente[i].getEscritura().println(mensajeLeido);
                System.out.print(mensajeLeido+"\t");
            }
            System.out.println("");
        }
            
        } catch (IOException ex) {
           
            System.out.println("coneccion perdida.  END");
            System.exit(0);
        }

    }
    
}
