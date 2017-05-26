/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPack;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabian.giraldo
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException {
        
        try {
           
            //1:ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            //2.Escuchando conexion de un cliente
            System.out.println("Servidor esperando conexiones");
            int numero=2;
            Cliente cliente [] = new Cliente [numero];
            Socket socket[]= new Socket [numero];
            for (int i = 0; i < numero; i++) {
                socket[i]= serverSocket.accept();
                System.out.println("Se ha conectado cliente "+(i+1));
                cliente[i]= new Cliente();
                cliente[i].inicializar(socket[i]);
                
                
            }
            
            /*Socket jugador []= new Socket[numero];
            OutputStream flujoSalida[]= new OutputStream [numero];
            InputStream flujoEntrada[]= new InputStream[numero];
            Scanner sc[]= new Scanner[numero];
            PrintWriter escritura[] = new PrintWriter[numero];
            
            
            for (int i = 0; i < numero; i++) {
            jugador [i]= serverSocket.accept();
            System.out.println("Se ha conectado cliente "+(i+1));
            flujoEntrada[i]=jugador[i].getInputStream();
            flujoSalida[i]= jugador[i].getOutputStream();
            sc[i]= new Scanner(flujoEntrada[i]);
            escritura[i]= new PrintWriter(flujoSalida[i],true);
            }
            
            */
            String mensajeLeido="";
           
            
            
            while(true){
               
                for (int i = 0; i < numero; i++) {
                    
                    mensajeLeido= cliente[i].escribirMensaje(cliente[i].getSc());
                    cliente[i].getEscritura().println(mensajeLeido);
                    System.out.print(mensajeLeido+"\t");
                }
                System.out.println("");
                /*mensajeLeido="";
                
                mensajeLeido=sc[0].nextLine();
                //mensajeLeido+=" "+sc[1].nextLine();
                
                System.out.println(mensajeLeido);
                for (int i = 0; i < numero; i++) {
                escritura[i].println(i+" "+mensajeLeido);
                }
                }*/
            }
            
        } catch (IOException ex) {
           
            System.out.println("coneccion perdida.  END");
            System.exit(0);
        }
        
    }
    
}
