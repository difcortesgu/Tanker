package Conexiones;

import Menus.DibujitosTablero;
import Menus.Ventana;
import Tanker.Tablero;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JPanel;

public class Cliente implements Runnable{
    
    private Socket cliente;
    private int n_tanques,n_balas,n_obstaculos;
    private int x,y,angulo,click;
    private String ip;
    private Ventana ventana;
    private JPanel panel;
    private Tablero tablero;
    private DibujitosTablero cpanel;
    
    public Cliente (String ip,Ventana ventana, JPanel panel) {
        this.ip=ip;
        this.ventana=ventana;
        this.panel= panel;
        Thread t= new Thread(this, "client");
        t.start();
        tablero= (Tablero) ventana.getPanel("Tablero");
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public void run() {
    
         try {
            
             
            cliente = new Socket(ip,8000);
            
            //3.Abriendo flujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
                       
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            Scanner sc= new Scanner(flujoEntrada);
            System.out.println("entrada de datos");
            
            String mensajeLeido="";
            String mensajeUsuario = this.inicializar(sc);
            escritura.println(mensajeUsuario);
            mensajeLeido= sc.nextLine();
            
            ventana.Cambiar_panel("Tablero");
            panel.setVisible(false);
            
            
            int contador =0;
            while(true){               
               escritura.println(mensajeUsuario);
               mensajeLeido= sc.nextLine();
               if(contador>1000){
                   System.out.println("cliente: "+mensajeLeido);
                   contador=0;
               }
               contador++;
            }

        } catch (IOException ex) {
            System.out.println("coneccion perdida.  END");  
            
        }
        
    } 
    
    public void datos(Scanner sc){
        n_tanques=sc.nextInt();
        for (int i = 0; i < n_tanques; i++) {
            x=sc.nextInt();
            y=sc.nextInt();
            angulo=sc.nextInt();
            n_balas=sc.nextInt();
            for (int j = 0; j < 10; j++) {
                x=sc.nextInt();
                y=sc.nextInt();
            }
        }
        n_obstaculos=sc.nextInt();
        for (int i = 0; i < n_obstaculos; i++) {
            x=sc.nextInt();
            y=sc.nextInt();
        }   
    }
    
    public String inicializar(Scanner sc){
        String datos_in;
        int tipoOruga=1,tipoArmazon=11;
         
        datos_in=tipoOruga+" "+tipoArmazon;
        return datos_in;
     }   
}
