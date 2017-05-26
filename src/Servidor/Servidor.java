/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import Usuario.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    
    public static void main(String[] args) {
        try {
            
            int x=0,y=0;
             
            //1:ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            //2.Escuchando conexion de un cliente
            System.out.println("Servidor esperando conexiones");
            Socket cliente = serverSocket.accept();
            System.out.println("Se ha conectado un cliente");
            //3.Abriendo flujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            //4. Poniendo decoradores para leer informacion textual
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            String mensajeLeido="";
           
            //Scanner sc= new Scanner(flujoEntrada," ");
            while(true){
                if(!Usuario.Main.isCerrado()){
                    mensajeLeido = lectura.readLine();
                    System.out.println(mensajeLeido+" END");
                    cliente.shutdownInput();
                    cliente.shutdownOutput();
                    
                    break;
                }else{
                    //5. Recibo la informacion
                    mensajeLeido = lectura.readLine();
                    //6. Mensaje Respuesta (Realizacion ECO)
                    System.out.println(mensajeLeido);
                
                    //x=sc.nextInt(); 
                    //y=sc.nextInt();
                    //System.out.println(x);
                    escritura.println("ECO " + mensajeLeido);
                }
                
                
              
              
            }
            
            
        } catch (IOException ex) {
        System.out.println("coneccion perdida.  END");  
        System.exit(0);
        }
        
        
    }
    
}
