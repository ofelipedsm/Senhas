import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalvarEmArquivo {
    //Criando um caminho para a pasta "Senhas" na Área de Trabalho
    private static final String CAMINHO_PASTA = Paths.get(System.getProperty("user.home"), "Desktop").toString();
    private static final String CAMINHO_ARQUIVO = Paths.get(CAMINHO_PASTA, "senhas.txt").toString();

    public static void salvarSenha(String servico, String senha) {
        try {
            //Cria o arquivo "senhas.txt" dentro da pasta, se não existir
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (!arquivo.exists()) {
                if (arquivo.createNewFile()) {
                    System.out.println("Arquivo 'senhas.txt' criado com sucesso na pasta 'Senhas'.");
                } else {
                    System.out.println("Erro ao criar o arquivo 'senhas.txt'. Verifique permissões.");
                    return;
                }
            }

            //Escrevendo no arquivo a senha gerada
            try (FileWriter writer = new FileWriter(arquivo, true)) { 
                // 'true' adiciona sem apagar as outras senhas geradas
                String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                writer.write("Serviço: " + servico + "\n");
                writer.write("Senha: " + senha + "\n");
                writer.write("Criado em: " + dataHora + "\n");
                // Separador
                writer.write("--------------------------------------\n"); 

                System.out.println("Senha salva com sucesso no arquivo: " + CAMINHO_ARQUIVO);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar senha: " + e.getMessage());
        }
    }
}
