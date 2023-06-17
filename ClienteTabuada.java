import java.io.*;
import java.net.*;

public class ClienteTabuada {
    public static void main(String[] args) {
        try {
            // Conecta-se ao servidor na porta 12345
            Socket servidor = new Socket("192.168.56.1", 12345);
            System.out.println("Conexao estabelecida com o servidor");

            // Cria um BufferedReader para ler a entrada do usuario
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

            // Cria um PrintWriter para enviar o numero para o servidor
            PrintWriter saida = new PrintWriter(servidor.getOutputStream(), true);

            System.out.print("Digite um numero inteiro: ");
            String input = entradaUsuario.readLine();

            try {
                int numero = Integer.parseInt(input);

                // Envia o numero para o servidor
                saida.println(numero);

                // Cria um BufferedReader para ler a resposta do servidor
                BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(servidor.getInputStream()));

                //System.out.println("Tabuada do " + numero + ":");
                String linha;
                while ((linha = entradaServidor.readLine()) != null) {
                    System.out.println(linha);
                }

                // Fecha os recursos
                entradaServidor.close();
            } catch (NumberFormatException e) {
                System.out.println("Tipo de numero invalido");
            }

            // Fecha os recursos
            saida.close();
            entradaUsuario.close();
            servidor.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
