import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Uso: java Main <arquivoEntrada> <arquivoSaida>");
            return;
        }

        Path entrada = Path.of(args[0]);
        Path saida = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(entrada);

            for (String linha : linhas) {

                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String cliente = partes[0].trim();

                try {
                    double valor = Double.parseDouble(partes[2].trim());

                    int indice = clientes.indexOf(cliente);

                    if (indice == -1) {
                        clientes.add(cliente);
                        totais.add(valor);
                    } else {
                        totais.set(indice, totais.get(indice) + valor);
                    }

                } catch (NumberFormatException e) {
                    // Ignora valores inválidos
                }
            }

            ArrayList<String> relatorio = new ArrayList<>();

            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(saida, relatorio);

            System.out.println("Relatório gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}