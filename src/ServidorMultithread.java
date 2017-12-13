<<<<<<< HEAD
=======

>>>>>>> 4046ca310a01d0d5572fa3b6f6a8ed19be3b8cf2
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorMultithread implements Runnable {

   
    Socket socketConexao;

    public ServidorMultithread(Socket socketConexao) {
        this.socketConexao = socketConexao;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket socketBoasVindas = new ServerSocket(6789);
        
        while(true){
            Socket socketConexao = socketBoasVindas.accept();
            ServidorMultithread tratar = new ServidorMultithread(socketConexao);
            Thread t = new Thread(tratar);
            t.start();
        }
        

    }

    public void run() {
        String fraseCliente; // Frase recebida do cliente
       
       
<<<<<<< HEAD
        String nomeDiretorio = "C:\\Prova"; // Armazena o caminho do diretorio"C:\\Users\\Renato Macêdo\\Desktop"
=======
        String nomeDiretorio = "C:\\Users\\Renato Macêdo\\Desktop"; // Armazena o caminho do diretorio"C:\\Users\\Renato Macêdo\\Desktop"
>>>>>>> 4046ca310a01d0d5572fa3b6f6a8ed19be3b8cf2
        
        //String nomeDiretorio = System.getProperty("user.dir");
        File diretorio = new File(nomeDiretorio); // Armazena o arquivo
        String[] arquivos; // Arquivos no diretorio
       
        
            try {
                // Cabeçalho
                System.out.println("Teste de Socket - Servidor");
                System.out.println("--------------------------\n");
                // Abre um socket para escutar na porta 6789
<<<<<<< HEAD

                
                BufferedReader doCliente
                        = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));

                // Prepara para enviar as informações ao cliente
                DataOutputStream paraCliente
                        = new DataOutputStream(socketConexao.getOutputStream());
                fraseCliente = doCliente.readLine();
                // Verifica o comando que foi dado
                if (fraseCliente.equals("INDEX")) {
                    // Verifica se é um diretório
                    if (diretorio.isDirectory() == false) {
                        // Verifica se o diretorio existe
                        if (diretorio.exists() == false) {
                            // Responde ao cliente que o diretório não existe
                            paraCliente.writeBytes("O diretorio nao existe!\n");
                            // Flag de fim de mensagem
                            paraCliente.writeBytes("-1\n");
                        } else {
                            // Responde ao cliente que nao é um diretório
                            paraCliente.writeBytes("Esse nome nao corresponde a um diretorio.\n");
                            // Flag de fim de mensagem
                            paraCliente.writeBytes("-1\n");;
                        }
                    } else {
                        // Lista em arquivos todos os arquivos presentes em diretório
                        arquivos = diretorio.list();
                        // Manda mensagem inicial para cliente
                        paraCliente.writeBytes("Arquivos no diretorio " + diretorio + ".\n");
                        // Manda lista de arquivos para o cliente
                        for (int i = 0; i < arquivos.length; i++) {
                            paraCliente.writeBytes(" " + arquivos[i] + "\n");
                        }
                        // Flag de fim de mensagem
                        paraCliente.writeBytes("-1\n");
                    }
                    // Verifica se o comando é GET <nome do arquivo>
                } else if (fraseCliente.charAt(0) == 'G' && fraseCliente.charAt(1) == 'E' && fraseCliente.charAt(2) == 'T') {
                    // Separa em um array que tera apenas dois espaços, o primeiro null e o segundo o nome recebido
                    String nomeArquivo[] = fraseCliente.split("GET ");
                    // Lista em arquivos todos os arquivos presentes em diretório
                    arquivos = diretorio.list();
                    // Inicia variavel para verificar existencia de arquivo
                    int verificador = -1;
                    // Verifica se o nome recebido pertence a algum arquivo nesse diretorio
                    for (int i = 0; i < arquivos.length; i++) {
                        if (arquivos[i].equals(nomeArquivo[1])) {
                            verificador = i;
                            break;
                        }
                    }
                    // Caso o arquivo exista
                    if (verificador != -1) {
                        // Enviando OK para cliente
                        paraCliente.writeBytes("OK\n");
                        // Muda o nome do diretorio para o com o arquivo solicitado
                        String nomeDiretorioNovo = nomeDiretorio + "\\" + nomeArquivo[1];
                        // Prepara para ler arquivo
                        BufferedReader lerArquivo = new BufferedReader(new InputStreamReader(new FileInputStream(nomeDiretorioNovo), "ISO-8859-1"));
                        // String que receberá o conteúdo do arquivo
                        String conteudo;
                        // Lendo todo o arquivo
                        while ((conteudo = lerArquivo.readLine()) != null) {
                            if (conteudo == null) {
                                break;
                            }
                            paraCliente.writeBytes(conteudo + "\n");
                        }
                        // Flag de fim da mensagem
                        paraCliente.writeBytes("-1\n");
                        // Fecha a conexão
                        //socketConexao.shutdownInput();
                        //socketConexao.shutdownOutput();
                        socketConexao.close();

                    } // Caso o arquivo n exista
                    else {
                        // Responde ao cliente que o diretório não existe
                        paraCliente.writeBytes("ERROR\n");
                        // Flag de fim da mensagem
                        paraCliente.writeBytes("-1\n");
                        // Fecha a conexão
                        //socketConexao.shutdownInput();
                        //socketConexao.shutdownOutput();
                        socketConexao.close();

                    }
                    
                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorMultithread.class.getName()).log(Level.SEVERE, null, ex);
            }
   
    }

}
=======

                
                BufferedReader doCliente
                        = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));

                // Prepara para enviar as informações ao cliente
                DataOutputStream paraCliente
                        = new DataOutputStream(socketConexao.getOutputStream());
                fraseCliente = doCliente.readLine();
                // Verifica o comando que foi dado
                if (fraseCliente.equals("INDEX")) {
                    // Verifica se é um diretório
                    if (diretorio.isDirectory() == false) {
                        // Verifica se o diretorio existe
                        if (diretorio.exists() == false) {
                            // Responde ao cliente que o diretório não existe
                            paraCliente.writeBytes("O diretorio nao existe!\n");
                            // Flag de fim de mensagem
                            paraCliente.writeBytes("-1\n");
                        } else {
                            // Responde ao cliente que nao é um diretório
                            paraCliente.writeBytes("Esse nome nao corresponde a um diretorio.\n");
                            // Flag de fim de mensagem
                            paraCliente.writeBytes("-1\n");;
                        }
                    } else {
                        // Lista em arquivos todos os arquivos presentes em diretório
                        arquivos = diretorio.list();
                        // Manda mensagem inicial para cliente
                        paraCliente.writeBytes("Arquivos no diretorio " + diretorio + ".\n");
                        // Manda lista de arquivos para o cliente
                        for (int i = 0; i < arquivos.length; i++) {
                            paraCliente.writeBytes(" " + arquivos[i] + "\n");
                        }
                        // Flag de fim de mensagem
                        paraCliente.writeBytes("-1\n");
                    }
                    // Verifica se o comando é GET <nome do arquivo>
                } else if (fraseCliente.charAt(0) == 'G' && fraseCliente.charAt(1) == 'E' && fraseCliente.charAt(2) == 'T') {
                    // Separa em um array que tera apenas dois espaços, o primeiro null e o segundo o nome recebido
                    String nomeArquivo[] = fraseCliente.split("GET ");
                    // Lista em arquivos todos os arquivos presentes em diretório
                    arquivos = diretorio.list();
                    // Inicia variavel para verificar existencia de arquivo
                    int verificador = -1;
                    // Verifica se o nome recebido pertence a algum arquivo nesse diretorio
                    for (int i = 0; i < arquivos.length; i++) {
                        if (arquivos[i].equals(nomeArquivo[1])) {
                            verificador = i;
                            break;
                        }
                    }
                    // Caso o arquivo exista
                    if (verificador != -1) {
                        // Muda o nome do diretorio para o com o arquivo solicitado
                        String nomeDiretorioNovo = nomeDiretorio + "\\" + nomeArquivo[1];
                        // Prepara para ler arquivo
                        BufferedReader lerArquivo = new BufferedReader(new InputStreamReader(new FileInputStream(nomeDiretorioNovo), "ISO-8859-1"));
                        // String que receberá o conteúdo do arquivo
                        String conteudo;
                        // Lendo todo o arquivo
                        while ((conteudo = lerArquivo.readLine()) != null) {
                            if (conteudo == null) {
                                break;
                            }
                            paraCliente.writeBytes(conteudo + "\n");
                        }
                        // Flag de fim da mensagem
                        paraCliente.writeBytes("-1\n");
                        // Fecha a conexão
                        //socketConexao.shutdownInput();
                        //socketConexao.shutdownOutput();
                        //socketConexao.close();

                    } // Caso o arquivo n exista
                    else {
                        // Responde ao cliente que o diretório não existe
                        paraCliente.writeBytes("ERROR\n");
                        // Flag de fim da mensagem
                        paraCliente.writeBytes("-1\n");
                        // Fecha a conexão
                        //socketConexao.shutdownInput();
                        //socketConexao.shutdownOutput();
                        socketConexao.close();

                    }
                    //*/
                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorMultithread.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
        
        
        
    }

}
>>>>>>> 4046ca310a01d0d5572fa3b6f6a8ed19be3b8cf2
