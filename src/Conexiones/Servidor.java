package Conexiones;

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
    private PrintStream ps;
    private Scanner sc;
    private boolean jugar;

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
            ps = new PrintStream(datos);
            sc = new Scanner(datos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
<<<<<<< HEAD
            servidor= new ServerSocket(6000);
            System.out.println("esperando clientes");
            while(!jugar){
                canales.add(new Canal(servidor.accept(),i,this));
                i++;
=======
           
            //1:ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            //2.Escuchando conexion de un cliente
            System.out.println("Servidor esperando conexiones");
            int numero=2;
            Canal cliente [] = new Canal [numero];
            Socket socket[]= new Socket [numero];
            for (int i = 0; i < numero; i++) {
                socket[i]= serverSocket.accept();
                System.out.println("Se ha conectado cliente "+(i+1));
                cliente[i]= new Canal();
                cliente[i].inicializar(socket[i]);                
            }
            
        String mensajeEntrante="";   
        String mensajeSaliente="";
        int contador=0;
        while(true){
            //mensajeSaliente=tablero.getDatos();
            mensajeSaliente="";
            for (int i = 0; i < numero; i++) {                    
                mensajeEntrante= cliente[i].escribirMensaje(cliente[i].getSc());  
               mensajeSaliente+=mensajeEntrante+" ";
            }
             for (int i = 0; i < numero; i++) {                    
               
                cliente[i].getEscritura().println((i+1)+" "+mensajeSaliente);
                
>>>>>>> b0e1ab40ccdfd152ae5066959ad7ff19b2916cd0
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}

