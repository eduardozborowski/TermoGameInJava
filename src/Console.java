import java.util.Scanner;

public class Console {
    private final Jogo jogo;
    private final Scanner input;

    public static final String normal = "\u001B[0m";
    public static final String verde = "\u001B[32m";
    public static final String amarelo = "\u001B[33m";

    public Console(Jogo jogo, Scanner input) {
        this.jogo = jogo;
        this.input = input;
    }

    public void exibir() {
        exibirChutes();
        exibirLinhas();
    }

    public String solicitarChute() {
        System.out.printf("Digite a palavra: (Tentativas restantes: %d)\r\n", jogo.getTentativasRestantes());
        String suspeita = input.nextLine().toUpperCase();
        if (suspeita.length() != jogo.getPalavra().length()) {
            System.out.println("Digite uma palavra com 5 letras.");
        } else {
            jogo.suspeita(suspeita);
        }
        return suspeita;
    }

    public void exibirChutes() {
        StringBuilder b = new StringBuilder();
        for (String s : jogo.getSuspeita()) {
            for (int i = 0; i < s.length(); i++) {
                String answer = jogo.getPalavra();
                char c = s.charAt(i);
                if (answer.charAt(i) == c) {
                    b.append(verde).append(c).append(normal);
                } else if (answer.contains(Character.toString(c))) {
                    b.append(amarelo).append(c).append(normal);
                } else {
                    b.append(c);
                }
                b.append("|");
            }
            b.setLength((b.length() - 1));
            System.out.println(b);
            b = new StringBuilder();
        }
    }

    public void exibirLinhas() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < jogo.getTentativasRestantes(); i++) {
            b.append("_|".repeat(jogo.getPalavra().length()));
            b.setLength(b.length() - 1);
            System.out.println(b);
            b = new StringBuilder();
        }
    }
}