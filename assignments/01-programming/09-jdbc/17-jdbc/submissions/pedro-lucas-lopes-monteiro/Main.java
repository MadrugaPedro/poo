package submissions.pedro_lucas_lopes_monteiro.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    // Configurações do Banco de Dados - Altere conforme seu ambiente de sala de aula
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "sua_senha_aqui";
    
    // Caminho do arquivo de dados solicitado no enunciado
    private static final String FILE_PATH = "./data/new_films.txt";

    public static void main(String[] bounds) {
        // 1. Ler os filmes do arquivo de texto
        System.out.println("Lendo filmes do arquivo...");
        List<Film> filmsToImport = FileReaderUtil.readFilmsFromFile(FILE_PATH);
        
        if (filmsToImport.isEmpty()) {
            System.out.println("Nenhum filme encontrado para importar. Encerrando.");
            return;
        }

        // 2. Operações no Banco de Dados via JDBC
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            // --- OPERAÇÃO 1: Inserir filmes importados ---
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                for (Film film : filmsToImport) {
                    insertStmt.setString(1, film.getTitle());
                    insertStmt.setInt(2, film.getLanguageId());
                    insertStmt.setInt(3, film.getRentalDuration());
                    insertStmt.setDouble(4, film.getRentalRate());
                    insertStmt.setDouble(5, film.getReplacementCost());
                    insertStmt.addBatch(); // Adiciona ao lote para performance
                }
                int[] rowsInserted = insertStmt.executeBatch();
                System.out.println(rowsInserted.length + " novos filmes importados com sucesso!");
            }

            // --- OPERAÇÃO 2: Atualizar o valor de locação em 10% ---
            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                int rowsUpdated = updateStmt.executeUpdate();
                System.out.println("Valor de locação atualizado em 10% para " + rowsUpdated + " filmes.");
            }

            // --- OPERAÇÃO 3: Listar filmes com rental_duration igual a 99 ---
            // Nota: O enunciado menciona 'rent_duration = 99' no SQL, ajuste para o nome exato da coluna da tabela caso mude
            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                
                System.out.println("\n--- FILMES COM DURAÇÃO DE LOCAÇÃO IGUAL A 99 ---");
                System.out.printf("%-30s | %-12s\n", "Título", "Taxa de Aluguel");
                System.out.println("-------------------------------------------------");
                
                boolean mudou = false;
                while (rs.next()) {
                    mudou = true;
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("%-30s | R$ %.2f\n", title, rentalRate);
                }
                
                if (!mudou) {
                    System.out.println("Nenhum filme encontrado com duração igual a 99.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro nas operações do banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}