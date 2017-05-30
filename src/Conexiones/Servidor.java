package Conexiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements Runnable{

    private final ArrayList<Canal> canales;
    private final Thread t;
    private File datos;
    private ServerSocket servidor;
    private Scanner sc;
    private boolean jugar;
    private String ms;

    public Servidor(boolean viento, String fondo, String modo) {
        jugar=false;
        datos = new File("datos_S.txt");
        if(!datos.exists()){
            try {
                datos.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            sc = new Scanner(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ms = sc.nextLine()+"\n";
        canales = new ArrayList();
        t= new Thread(this,"servidor");
        t.start();
    }

    public boolean isJugar() {
        return jugar;
    }

    public void setJugar(boolean jugar) {
        this.jugar = jugar;
    }

    
    
    public ArrayList<Canal> getCanales() {
        return canales;
    }

    public Thread getT() {
        return t;
    }

    @Override
    public void run() {
        
        int i=0;
        try {

            servidor= new ServerSocket(6000);
            System.out.println("esperando clientes");
            while(!jugar){
                canales.add(new Canal(servidor.accept(),i,this));
                i++;
            }
            for(Canal j:canales){
                ms += j.getMu()+(i-1)+","+"\n";
            }
            System.out.println(ms);
            canales.forEach((j)->{
                j.escribir(ms);
            });
            

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}

