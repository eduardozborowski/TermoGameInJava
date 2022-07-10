import java.util.ArrayList;
import java.util.List;

public class Jogo {

    private final String palavra;
    private int tentativasRestantes;
    private int tentativas;
    private List<String> suspeita;

    public Jogo(String palavra) {
        this.palavra = palavra.toUpperCase();
        this.tentativas = 6;
        this.tentativasRestantes = tentativas;
        this.suspeita = new ArrayList<>();
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public String getPalavra() {
        return palavra;
    }

    public List<String> getSuspeita() {
        return suspeita;
    }

    public void setSuspeita(List<String> suspeita) {
        this.suspeita = suspeita;
    }

    public boolean fimDeJogo() {
        return tentativasRestantes == 0 || acerto();
    }

    public boolean acerto() {
        return suspeita.contains(palavra);
    }

    public void suspeita(String str) {
        if (str.length() != palavra.length()) return;

        suspeita.add(str);
        tentativasRestantes--;
    }
}
