import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <arquivo-entrada> <arquivo-saida>");
            return;
        }

        Path entrada = Path.of(args[0]);
        Path saida = Path.of(args[1]);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        List<String> linhas;
        try {
            linhas = Files.readAllLines(entrada);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        for (String linha : linhas) {
            String[] campos = linha.split(",");
            if (campos.length < 3) {
                continue;
            }

            String nomeCliente = campos[0].trim();
            double valor;
            try {
                valor = Double.parseDouble(campos[2].trim());
            } catch (NumberFormatException e) {
                continue;
            }

            int indice = nomes.indexOf(nomeCliente);
            if (indice == -1) {
                nomes.add(nomeCliente);
                totais.add(valor);
            } else {
                totais.set(indice, totais.get(indice) + valor);
            }
        }

        StringBuilder conteudo = new StringBuilder();
        for (int i = 0; i < nomes.size(); i++) {
            conteudo.append(nomes.get(i)).append(": ").append(totais.get(i)).append(System.lineSeparator());
        }

        try {
            Files.writeString(saida, conteudo.toString());
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de saida: " + e.getMessage());
        }
    }
}
