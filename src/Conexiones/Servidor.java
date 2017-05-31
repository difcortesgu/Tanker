package Conexiones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private boolean jugar,viento;
    private String ms,modo,fondo;
    private int x,y;

    public Servidor(String fondo, String modo, boolean viento) {
        jugar=false;
        this.fondo=fondo;
        this.modo=modo;
        this.viento=viento;
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
        System.out.println("iniciar tablero.end.");
        ms = fondo+","+modo+","+viento+",";  //lee datos servidor  para iniciar tablero
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
        
        int i=0,l=0;
        try {
            servidor= new ServerSocket(6000);
            while(!jugar){
                canales.add(new Canal(servidor.accept(),this));
                canales.get(i).escribir(i+",");
                i++;
            }
            ms+=i+",";
            for(Canal j:canales){
                x=(int)(100* Math.random());
                y=(int)( 700*Math.random());
                
                if(modo.equalsIgnoreCase("ffa")){
                    ms += "rojo,"+j.getMu();
                }else{
                    if(l%2 == 0){
                        ms += "rojo,"+j.getMu();
                    }else{
                        ms += "azul,"+j.getMu();
                    }
                }
                l++;
                ms+=x+","+y+",";
                
            }     
            System.out.println(ms+x+","+y+",");
            for(Canal j: canales){
                j.escribir(ms);
            }
            
            //ciclo principal del juego
            while(true){
                this.main(i);
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public synchronized void main(int i){
        ms="";
        for(int h=0;h<i;h++){
            ms+=canales.get(h).getSc1().nextLine()+",";
        }
        for(int h=0;h<i;h++){
            canales.get(h).escribir(ms);
        }

    }

}

