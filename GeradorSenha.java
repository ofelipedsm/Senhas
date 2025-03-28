import java.security.SecureRandom;

public class GeradorSenha{
    //conjunto dos possiveis caracteres para a senha
    private static final String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()-_=+[]{};:'\",.<>?/";

    public static String gerarSenha(int tamanho, boolean incluirMaiusculas, boolean incluirMinusculas, boolean incluirNumeros, boolean incluirEspeciais) {
        StringBuilder caracteres = new StringBuilder();

        //inclui os conjuntos pedidos na string caracteres
        if (incluirMaiusculas) caracteres.append(LETRAS_MAIUSCULAS);
        if (incluirMinusculas) caracteres.append(LETRAS_MINUSCULAS);
        if (incluirNumeros) caracteres.append(NUMEROS);
        if (incluirEspeciais) caracteres.append(CARACTERES_ESPECIAIS);

        //garante que haja pelo menos 1 tipo de caracteres
        if (caracteres.length() == 0) {
            throw new IllegalArgumentException("Pelo menos um tipo de caractere deve ser selecionado!");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        //gera a senha
        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        //devolve a senha gerada
        return senha.toString();
    }
}
