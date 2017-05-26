package Usuario;



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
    
    static boolean cerrado=false;
    public static boolean end=false;
    static CPanel C= new CPanel();

    public Main () {
       
        add(C);
        setTitle("Tanker");
        setSize(1000,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        setLocationRelativeTo(null);
        setVisible(true);
         x=C.x;
         y=C.y;

        
    }
    
    public static void main(String[]args){
        
         try {
            Main usuario= new Main();
          //  Socket cliente2= new Socket("192.168.0.26");
             cliente = new Socket("localhost",8000);
            //3.Abriendo flujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            //4. Poniendo decoradores para leer informacion textual
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            
            //5.Solicitando datos al usuario
            Scanner sc= new Scanner(flujoEntrada);
            
            System.out.println("entrada de datos");
            String mensajeLeido="";
            String mensajeUsuario = "";
            
            
             int i, x1, x2, y1, y2;
            while(true){               
              
                 
               escritura.println(C.toString());
               mensajeLeido= sc.nextLine();
                System.out.println(mensajeLeido);
               /* i=sc.nextInt();
               x1=sc.nextInt();
               y1=sc.nextInt();
               // x2=sc.nextInt();
               //y2=sc.nextInt();
               C.setX(x1);
               C.setY(y1);
               C.setX2(x1);
               C.setY2(y1);
               
               C.repaint();
               mensajeLeido = "";
               System.out.println("Me contestaron " +i+" "+x1+" "+y1);
               */
            }

        } catch (IOException ex) {
            System.out.println("coneccion perdida.  END");  
            
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
