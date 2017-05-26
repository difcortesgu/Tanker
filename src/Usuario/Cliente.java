package Usuario;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable{
    
    private Socket cliente;
    private int x,y;
    
    public Cliente () {
        Thread t= new Thread(this, "client");
        t.start();
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
            
             
            cliente = new Socket("localhost",8000);
            
            //3.Abriendo flujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
                       
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            
            //5.Solicitando datos al usuario
            Scanner sc= new Scanner(flujoEntrada);
            
            System.out.println("entrada de datos");
            String mensajeLeido="";
            String mensajeUsuario = "mensaje";
            
          
            while(true){               
               escritura.println(mensajeUsuario);
               mensajeLeido= sc.nextLine();
               System.out.println(mensajeLeido);
            }

        } catch (IOException ex) {
            System.out.println("coneccion perdida.  END");  
            
        }
        
    }
    
    
       
}
