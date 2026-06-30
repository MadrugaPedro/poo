import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: java RelatorioCompras <caminho_arquivo_entrada> <caminho_arquivo_saida>");
            System.err.println("Exemplo: java RelatorioCompras compras.txt report.txt");
            return;
        }

        Path caminhoEntrada = Paths.get(args[0]);
        Path caminhoSaida = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue; 
                }

                String nomeCliente = partes[0].trim();
                double valorCompra;

                try {
                    valorCompra = Double.parseDouble(partes[2].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Erro de formatação numérica ignorado na linha: " + linha);
                    continue;
                }

                int indiceCliente = clientes.indexOf(nomeCliente);
                
                if (indiceCliente != -1) {
                    double valorAtual = totais.get(indiceCliente);
                    totais.set(indiceCliente, valorAtual + valorCompra);
                } else {
                    clientes.add(nomeCliente);
                    totais.add(valorCompra);
                }
            }

            ArrayList<String> relatorioSaida = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                relatorioSaida.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(caminhoSaida, relatorioSaida);
            System.out.println("Processamento concluído. Relatório salvo em: " + caminhoSaida.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler ou gravar os arquivos: " + e.getMessage());
        }
    }
}