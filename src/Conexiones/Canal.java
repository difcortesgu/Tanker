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
    private Scanner sc1;
    private File f;
    private final int numerotanque;
    private final Servidor s;
    private String mu;

    public Canal(Socket cliente,int numerotanque,Servidor s) {
        
        this.cliente = cliente;
        this.s = s;
        this.numerotanque = numerotanque;
        comunicacion();
    }

    public void comunicacion() {
        iniciarDatos();
        System.out.println("se conecto cliente"+(numerotanque+1));
        mu=sc1.nextLine();
 
       
    }

    private void iniciarDatos(){
        try {
            out = cliente.getOutputStream();
            in = cliente.getInputStream();
            sc1 = new Scanner(in);
            ps1 = new PrintStream(out);
            sc1.useDelimiter(",");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribir(String msm){
        ps1.print(msm);
    }

    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public PrintStream getPs1() {
        return ps1;
    }

    public void setPs1(PrintStream ps1) {
        this.ps1 = ps1;
    }

    public Scanner getSc1() {
        return sc1;
    }

    public void setSc1(Scanner sc1) {
        this.sc1 = sc1;
    }
    
    
    
}
