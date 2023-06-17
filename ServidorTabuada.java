import java.io.*;
import java.net.*;

public class ServidorTabuada {
    public static void main(String[] args) {
        try {
            // Cria o ServerSocket ouvindo a porta 12345
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");

            while (true) {
                // Espera a conexao de um cliente
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                // Cria um BufferedReader para ler a mensagem enviada pelo cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String input = entrada.readLine();

                try {
                    int numero = Integer.parseInt(input);

                    // Cria um PrintWriter para enviar a tabuada de volta para o cliente
                    PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);

                    saida.println("Tabuada do " + numero + ":");

                    for (int i = 1; i <= 10; i++) {
                        int resultado = numero * i;
                        saida.println(numero + " x " + i + " = " + resultado);
                    }

                    // Verificar se e par ou impar
                    if (numero % 2 == 0) {
                        saida.println(numero + " e um numero par");
                    } else {
                        saida.println(numero + " e um numero impar");
                    }

                    // Verificar se e primo
                    boolean isPrime = true;
                    if (numero < 2) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i <= Math.sqrt(numero); i++) {
                            if (numero % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        saida.println(numero + " eh um numero primo");
                    } else {
                        saida.println(numero + " nao e um numero primo");
                    }

                    // Fecha os recursos
                    saida.close();
                } catch (NumberFormatException e) {
                    PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
                    saida.println("Entrada invalida");

                    // Fecha os recursos
                    saida.close();
                }

                entrada.close();
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
