package Usuario;
import Servidor.*;
import tanker.*;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class Main extends JFrame{
    static Socket cliente;
    int x,y;
    boolean click;
    static boolean cerrado=false;
    static CPanel C= new CPanel();

    public Main() {
       
        add(C);
        setTitle("Tanker");
        setSize(1000,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        setLocationRelativeTo(null);
        setVisible(true);
         x=C.x;
         y=C.y;
         click=C.click;
         
         
        
    }
    
    public static void main(String[]args){
        
         try {
            Main usuario= new Main();
           
             cliente = new Socket("10.203.150.166",8000);
            //3.Abriendo flujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            //4. Poniendo decoradores para leer informacion textual
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            
            //5.Solicitando datos al usuario
            BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("entrada de datos");
            String mensajeLeido="";
            String mensajeUsuario = "";
            
            while(true){
                cerrado=!usuario.isActive();
                if(cerrado){
                    cliente.shutdownInput();
                    escritura.println("");
                    cerrado=true;
                    System.out.println("  END");  
                    System.exit(0);
                    break;
                    
                }else{
                    escritura.println(C.toString());
                    //7.Recibiendo la respuesta
                    mensajeLeido = lectura.readLine();
                    System.out.println("Me contestaron " + mensajeLeido);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        
    }

    public static Socket getCliente() {
        return cliente;
    }

    public static void setCliente(Socket cliente) {
        Main.cliente = cliente;
    }
    
    
    public static boolean isCerrado() {
        return cerrado;
    }

    public static void setCerrado(boolean cerrado) {
        Main.cerrado = cerrado;
    }
    
       
}
