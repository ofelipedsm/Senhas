import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Gerador de Senhas!");

        //serviço que a senha será usada
        System.out.print("Digite o servico de uso da Senha: ");
        String servico = scanner.nextLine();

        //tamanho da senha
        System.out.print("Digite o tamanho da senha: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine(); 

        //confirma os tipos de caracteres presentes na senha
        System.out.print("Incluir letras maiúsculas? (true/false): ");
        boolean incluirMaiusculas = scanner.nextBoolean();

        System.out.print("Incluir letras minúsculas? (true/false): ");
        boolean incluirMinusculas = scanner.nextBoolean();

        System.out.print("Incluir números? (true/false): ");
        boolean incluirNumeros = scanner.nextBoolean();

        System.out.print("Incluir caracteres especiais? (true/false): ");
        boolean incluirEspeciais = scanner.nextBoolean();
        scanner.nextLine();  

        // Gera a senha
        String senhaGerada = GeradorSenha.gerarSenha(tamanho, incluirMaiusculas, incluirMinusculas, incluirNumeros, incluirEspeciais);
        System.out.println("Local: " + servico);
        System.out.println("Senha gerada: " + senhaGerada);

        //confirma se deve salvar em um arquivo local
        System.out.print("Você deseja salvar a senha em um arquivo? (sim/nao): ");
        String resposta = scanner.nextLine();

        //salva em um arquivo local
        if (resposta.equalsIgnoreCase("sim")) {
            SalvarEmArquivo.salvarSenha(servico, senhaGerada);
        }

        System.out.println(" Programa finalizado.");
        scanner.close();
    }
}
