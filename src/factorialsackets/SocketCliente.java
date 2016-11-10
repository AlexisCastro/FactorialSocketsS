/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialsackets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class SocketCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ip = "127.0.0.1";
        int puerto = 6000;
        System.out.println(" socket " + ip + " " + puerto);
        int numero;
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;
        Scanner sc =new Scanner(System.in);
        try {
            //el cliente crea un socket para solicitar una conexion al SocketServer
            socketCliente = new Socket(ip, puerto);
            System.out.println("Enviando solicitud de conexion...");
            System.out.println("Coloca el numero el cual quieres sacar el factorial");
           numero=Integer.parseInt(sc.nextLine());
            //obtengo la entrada y la salida de bytes 
            entrada = new BufferedReader( new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter( new OutputStreamWriter(socketCliente.getOutputStream()), true);
            
            //añado el nombre que envia el cliente
           
             salida.println(numero);
            //leo la respuesta del server 
            System.out.println("recibiendo ... " + entrada.readLine());
            
            //cerramos la conexion
            socketCliente.close();
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }
    
}
