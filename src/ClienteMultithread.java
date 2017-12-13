


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Renato Macêdo
 */
public class ClienteMultithread implements Runnable {
    Socket Cliente;
    static Socket socketCliente1;
    public ClienteMultithread(Socket cliente){
        this.Cliente = cliente;
    }
    
    public static void main(String[] args) throws IOException {
       Socket socketCliente = new Socket("localhost", 6789);
        
        ClienteMultithread cliente = new ClienteMultithread(socketCliente);
       socketCliente1= socketCliente;
        Thread t = new Thread(cliente);
        t.start();
        
    }

    public void run() {
        String frase; // frase digitada pelo usuário
        String fraseModificada; // frase modificada pelo servidor
        String servidor; // Nome do servidor

        System.out.println("Teste de Socket - Cliente");
        System.out.println("-------------------------\n");

        // Prepara a leitura da variável do teclado
        BufferedReader doUsuario
                = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {
                // Inicia o socket do cliente com o computador especificado em servidor
                 

                // Prepara para escrever no socket
                DataOutputStream paraServidor
                        = new DataOutputStream(socketCliente1.getOutputStream());

                // Prepara para ler do socket
                BufferedReader doServidor
                        = new BufferedReader(new InputStreamReader(socketCliente1.getInputStream()));

                //Lendo Comando
                System.out.println("Digite o Comando:");
                frase = doUsuario.readLine();
                paraServidor.writeBytes(frase + "\r\n");

                //Lendo Resposta
                frase = doServidor.readLine();
                while (!frase.equals("-1")) {
                    System.out.println(frase);
                    frase = doServidor.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteMultithread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
