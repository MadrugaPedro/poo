import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FilmApp {

    public static void main(String[] args) {
        
        
        Properties props = new Properties();
        try (InputStream input = Files.newInputStream(Path.of("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        
        Path caminho = Paths.get("/workspaces/poo-3-semestre/assignments/01-programming/09-jdbc/17-jdbc/data/new_films.txt");
        FilmFileRead filmFileRead = new FilmFileRead(caminho);
        List<String> linhas = filmFileRead.lerLinhas();
        
        List<Film> listaFilmes = new ArrayList<>();
        
        if (!linhas.isEmpty()) {
            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                if (linha.trim().isEmpty()) continue;
                
                String[] dados = linha.split(";");
                if (dados.length == 5) {
                    try {
                        String title = dados[0].trim();
                        int languageId = Integer.parseInt(dados[1].trim());
                        int rentalDuration = Integer.parseInt(dados[2].trim());
                        double rentalRate = Double.parseDouble(dados[3].trim());
                        double replacementCost = Double.parseDouble(dados[4].trim());
                        
                        listaFilmes.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro de conversão na linha " + (i + 1));
                    }
                }
            }
        }

        System.out.println("Total de filmes carregados do arquivo: " + listaFilmes.size());

       
        String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
        String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            
            
            System.out.println("\n=== Importando filmes para o banco de dados ===");
            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                int totalInserido = 0;
                for (Film filme : listaFilmes) {
                    psInsert.setString(1, filme.getTitle());
                    psInsert.setInt(2, filme.getLanguafeId());
                    psInsert.setInt(3, filme.getRentalDuration());
                    psInsert.setDouble(4, filme.getRentalRate());
                    psInsert.setDouble(5, filme.getReplacementCost());
                    totalInserido += psInsert.executeUpdate();
                }
                System.out.println("Sucesso: " + totalInserido + " filmes inseridos.");
            }

            
            System.out.println("\n=== Atualizando o valor de locação de todos os filmes (* 1.1) ===");
            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                int linhasAfetadas = psUpdate.executeUpdate();
                System.out.println("Sucesso: " + linhasAfetadas + " filmes atualizados.");
            }

            
            System.out.println("\n=== Filmes com duração de locação igual a 99 ===");
            try (PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
                 ResultSet rs = psSelect.executeQuery()) {
                
                int contador99 = 0;
                while (rs.next()) {
                    contador99++;
                    System.out.printf("%d. Título: %s | Nova Taxa: %.2f%n", 
                            contador99, rs.getString("title"), rs.getDouble("rental_rate"));
                }
                if (contador99 == 0) {
                    System.out.println("Nenhum filme encontrado com duração de locação igual a 99.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao operar no banco de dados: " + e.getMessage());
        }
    } 
} 