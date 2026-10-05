import java.io.*;
import java.net.*;

public class JavaClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Olá, servidor Python! Esta é uma requisição do cliente Java.");
            
            String resposta = in.readLine();
            System.out.println("Recebido do Python: " + resposta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
