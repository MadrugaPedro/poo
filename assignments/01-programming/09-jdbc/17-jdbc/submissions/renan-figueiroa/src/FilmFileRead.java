import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilmFileRead {

    private Path caminho;

    // O construtor deve APENAS receber e guardar o caminho do arquivo
    public FilmFileRead(Path caminho) {
        this.caminho = caminho;
    }

    // Este método faz o trabalho de ler e retornar as linhas
    public List<String> lerLinhas() {
        if (Files.exists(this.caminho)) {
            System.out.println("Nome: " + caminho.getFileName());
            
            try {
                // Lê o arquivo e já retorna a lista preenchida
                return Files.readAllLines(caminho);
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                return List.of(); // Retorna lista vazia se der erro de leitura
            }
        } else {
            System.out.println("Arquivo não encontrado no caminho: " + caminho.toAbsolutePath());
            return List.of(); // Retorna lista vazia se o arquivo não existir
        }
    }

    // Métodos Getter e Setter originais (opcionais, mas bom manter)
    public Path getCaminho() {
        return caminho;
    }

    public void setCaminho(Path caminho) {
        this.caminho = caminho;
    }
}