package Conexiones;

import Menus.Ventana;
import Tanker.Tablero;
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
        //envio inicial
        ps1.println(sc2.nextLine());
        
        //Construccion de todos los Tableros de cada servidor
        int j = sc1.nextInt();//numero del jugador
        this.tablero=new Tablero(sc1.next(),sc1.next(), sc1.nextBoolean(), ventana);
        int n = sc1.nextInt();
        System.out.println(j);
        System.out.println(n);
        for(int i=0;i<n;i++){
            tablero.addTanque(sc1.next(),sc1.nextInt(),sc1.nextInt(), 100,100, sc1.nextBoolean(), j);    
        }
        ventana.getPaneles().put("Tablero", tablero);
        ventana.add(ventana.getPanel("Tablero"));
        ventana.Cambiar_panel("Tablero", "Espera");
        
        //Ciclo principal del juego
        while(true){
            if(!tablero.getTanque(j).die()){
                ps1.println((int)tablero.getTanque(j).getMx()+","+(int)tablero.getTanque(j).getMy()+","+tablero.getTanque(j).isClick()+","+(int)tablero.getTanque(j).getAceleracion());
            }
            for(int i=0;i<n;i++){
                if(i!=j){
                    tablero.getTanque(i).setMx(sc1.nextInt());
                    tablero.getTanque(i).setMy(sc1.nextInt());
                    tablero.getTanque(i).setClick(sc1.nextBoolean());
                    tablero.getTanque(i).setAceleracion(sc1.nextDouble());
                }else{
                    sc1.next();
                    sc1.next();
                    sc1.next();
                    sc1.next();
                }
                
            }
        }
    }
    
    public void escribir(String sms){
        ps1.print(sms);
    }
    
    private void iniciarDatos(){
        datos = new File("datos_J.txt");
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
