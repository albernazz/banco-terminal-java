import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        Operacoes operacoes = new Operacoes();
        Scanner scanner = new Scanner(System.in); // Scanner criado aqui

        System.out.println("Seja Bem-vindo ao Banco via terminal !!");
        System.out.println("Para começar sua experiencia no noss banco e conseguir ganhar seu credito, vamos registrar seus dados: ");

        // Dados do cliente
        System.out.println("Qual é o seu nome?");
        String nomeCliente = scanner.nextLine();
        
        // Escolha da agência
        int agenciaEscolhida = operacoes.numeroAgencia();
        
        Operacoes.clear();  

        Random random = new Random();
        int numeroDoCliente = random.nextInt(1000); // numero do cliente adquirido de forma aleatória 

        // Nome da agência escolhida
        String nomeDaAgencia = operacoes.nomeDaAgencia(agenciaEscolhida);

        // Obter saldo do cliente
        int saldo = operacoes.creditoDoCliente(scanner); // Passa o scanner para o método de credito

        Operacoes.clear();
        
        //saldo maximo 
        if(saldo > 10000){
            System.out.println("Parabens, pelo seu belo histórico voce coneguiu o  credito maximo do nosso banco");
            saldo = 10000;
        }
       
        System.out.println("Seus dados:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Agência: " + nomeDaAgencia + " (" + agenciaEscolhida + ")");
        System.out.println("Número do Cliente: " + numeroDoCliente);
        System.out.println("Credito disponível: R$ " + saldo);

        
        scanner.close();
    }
}
