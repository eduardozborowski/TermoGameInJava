import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) throws IOException {
        var path = Path.of("br-utf8.txt");
        var palavras = Files
                .readAllLines(path)
                .stream()
                .filter(s -> s.length() == 5)
                .collect(Collectors.toList());

        var jogo = new Jogo(palavras.get(new Random().nextInt(palavras.size())));
        var input = new Scanner(System.in);
        var console = new Console(jogo, input);

        while (!jogo.fimDeJogo()) {
            console.exibir();
            console.solicitarChute();
        }

        console.exibir();

        if (jogo.acerto()) {
            System.out.println("Você acertou a palavra");
        } else {
            System.out.println("Você não acertou a palavra");
        }
        System.out.println("A palavra é: " + jogo.getPalavra());
        input.close();
    }
}
