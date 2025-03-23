import java.util.Scanner;

public class Operacoes {

    
    @SuppressWarnings("resource")
   public int numeroAgencia() {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("+----------------+-------------------+");
        System.out.println("| Código Agência | Localização        |");
        System.out.println("+----------------+-------------------+");
        System.out.println("| 1              | Asa Sul           |");
        System.out.println("| 2              | Asa Norte         |");
        System.out.println("| 3              | Aguas Claras      |");
        System.out.println("| 4              | Ceilândia         |");
        System.out.println("| 5              | Samambaia         |");
        System.out.println("+----------------+-------------------+");
        System.out.print("Escolha a agência mais perto de você: ");
        
        int agencia = scanner.nextInt(); 
        scanner.nextLine(); 

       
        if (agencia < 1 || agencia > 5) {
            agencia = 0; 
        }
        
        return agencia; 
    }

    public String nomeDaAgencia(int agencia) {
        String nomeAgencia = "";
        
        switch (agencia) {
            case 1:
                nomeAgencia = "Asa Sul";
                break;
            case 2:
                nomeAgencia = "Asa Norte";
                break;
            case 3:
                nomeAgencia = "Aguas Claras";
                break;
            case 4:
                nomeAgencia = "Ceilândia";
                break;
            case 5:
                nomeAgencia = "Samambaia";
                break;
            default:
                nomeAgencia = "Você não escolheu uma agência válida";
                break;
        }

        return nomeAgencia;
    }

    public static void clear() {
        String os = System.getProperty("os.name");

        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para calcular o saldo
    public int creditoDoCliente(Scanner scanner) {
        System.out.println("Para que possamos liberar seu crédito inicial, responda as seguintes perguntas:");

        System.out.print("Qual é a sua renda mensal? ");
        int renda = scanner.nextInt(); 
        scanner.nextLine(); 

        System.out.print("Qual é o valor médio das suas despesas mensais? ");
        int despesa = scanner.nextInt(); 
        scanner.nextLine(); 

        
        renda = renda - despesa;

        
        boolean respostaValidaEmprestimo = false;
        String emprestimoAtivo = "";
        while (!respostaValidaEmprestimo) {
            System.out.println("Você tem algum outro tipo de empréstimo ou crédito ativo? (Responda com SIM ou NAO)");
            emprestimoAtivo = scanner.nextLine().toUpperCase();

            if (emprestimoAtivo.equals("SIM") || emprestimoAtivo.equals("NAO")) {
                respostaValidaEmprestimo = true; // Resposta válida, sai do loop
            } else {
                System.out.println("Resposta inválida. Por favor, responda com SIM ou NÃO.");
            }
        }

        boolean respostaValidaAtraso = false;
        String atraso = "";
        while (!respostaValidaAtraso) {
            System.out.println("Você já teve algum histórico de atraso em pagamentos? (Responda com SIM ou NAO)");
            atraso = scanner.nextLine().toUpperCase();

            if (atraso.equals("SIM") || atraso.equals("NAO")) {
                respostaValidaAtraso = true; // Resposta válida, sai do loop
            } else {
                System.out.println("Resposta inválida. Por favor, responda com SIM ou NÃO.");
            }
        }

        // Se tiver empréstimo ou atraso, aplicar um desconto de 15% na renda
        if (emprestimoAtivo.equals("SIM")) {
            renda = (int)(renda * 0.85); // Desconto de 15%
        }

        if (atraso.equals("SIM")) {
         renda = (int)(renda * 0.85); 
       }

        return renda;
    }

    public int creditoMaximo(int saldo){
      
      return 0;
    }
}
