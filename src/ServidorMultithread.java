
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




public class ServidorMultithread {


    public static void main(String[] args) throws IOException  {
      ServerSocket socketBoasVindas = new ServerSocket(6789);
        
     
               ThreadDoServidor servidor = new ThreadDoServidor(socketBoasVindas);
               Thread t = new Thread(servidor);
               

        
            
           
     }

}  

   

