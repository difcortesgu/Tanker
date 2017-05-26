/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorPack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author juan sebastian
 */
public class Cliente  {
    
    OutputStream flujoSalida;
    InputStream flujoEntrada;
    Scanner sc;
    PrintWriter escritura;
    String mensaje;
    Socket socket;

    public Cliente() {
        
    }
    public void inicializar(Socket socket) throws IOException{
        this.socket= socket;
        flujoSalida= socket.getOutputStream();
        flujoEntrada=socket.getInputStream();
        sc=new Scanner(flujoEntrada);
        escritura= new PrintWriter(flujoSalida,true);
        mensaje= " ";
        
    }
    public String escribirMensaje(Scanner scanner){
        mensaje=scanner.nextLine();
        return mensaje;
    }

    public OutputStream getFlujoSalida() {
        return flujoSalida;
    }

    public void setFlujoSalida(OutputStream flujoSalida) {
        this.flujoSalida = flujoSalida;
    }

    public InputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    public void setFlujoEntrada(InputStream flujoEntrada) {
        this.flujoEntrada = flujoEntrada;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public PrintWriter getEscritura() {
        return escritura;
    }

    public void setEscritura(PrintWriter escritura) {
        this.escritura = escritura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    

    
    
}
