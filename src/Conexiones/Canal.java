package Conexiones;

import Conexiones.Servidor;
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

public class Canal{

    private InputStream in ;
    private OutputStream out;
    private final Socket cliente;
    private PrintStream ps1,ps2;
    private Scanner sc1,sc2;
    private File f;
    private final int numerotanque;
    private final Servidor s;

    public Canal(Socket cliente,int numerotanque,Servidor s) {
        
        this.cliente = cliente;
        this.s = s;
        this.numerotanque = numerotanque;
        run();
    }

    public void run() {
        iniciarDatos();
        System.out.println("se conecto cliente"+(numerotanque+1));
        while(true){
            System.out.println(sc1.nextLine());
        }
    }

    private void iniciarDatos(){
        f= new File("datos_S.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        try {
            sc2= new Scanner(f);
            ps2=new PrintStream(f);
            out = cliente.getOutputStream();
            in = cliente.getInputStream();
            sc1 = new Scanner(in);
            ps1 = new PrintStream(out);
            sc1.useDelimiter(",");
            sc2.useDelimiter(",");        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
