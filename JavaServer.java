import java.io.*;
import java.net.*;

public class JavaServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor aguardando conexão na porta 5000...");
            Socket socket = serverSocket.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String mensagem = in.readLine();
            System.out.println("Recebido: " + mensagem);
            
            out.println("Mensagem recebida com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
