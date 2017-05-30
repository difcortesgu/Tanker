package Conexiones;

import Menus.Ventana;
import Tanker.Tablero;
import Tanker.Tanque;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{

    private String ip;
    private Ventana ventana;
    private Tablero tablero;
    private Socket cliente;
    private File datos;
    private Scanner sc1,sc2;
    private PrintStream ps1;
    private InputStream flujoEntrada;
    private OutputStream flujoSalida;
    private final Thread t;
    private int mx,my;
    private double a;
    
    
    public Cliente(String ip,Ventana ventana) {
        this.a=0;
        this.ip = ip;
        this.ventana=ventana;
        this.tablero=new Tablero(ventana);
        ventana.getPaneles().put("Tablero", tablero);
        ventana.Cambiar_panel("Tablero", "Espera");
        t = new Thread(this,"cliente");
        try {
            cliente = new Socket(ip,6000);
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {              
        iniciarDatos();
        while(true){  
            mx=(int) tablero.getTanque().getMx();
            my=(int) tablero.getTanque().getMy();
            a=(int) tablero.getTanque().getA();
            ps1.println(mx+","+my+","+a+",");
        }    
    }
    
    private void iniciarDatos(){
        File datos = new File("datos_J.txt");
        try {
            sc2 = new Scanner(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            ps1 = new PrintStream(cliente.getOutputStream());
            sc1 = new Scanner(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        sc1.useDelimiter(",");
        sc2.useDelimiter(",");        
    }
    
}
