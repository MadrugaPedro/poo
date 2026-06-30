package flix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres"; 
    private static final String PASSWORD = "senha"; 

    public static final void main(String[] args) {
        String caminhoArquivo = "data.txt";
        
        List<Film> filmesParaImportar = LeitorFilmes.lerArquivo(caminhoArquivo);

        if (filmesParaImportar.isEmpty()) {
            System.out.println("Nenhum filme válido foi carregado do arquivo.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão com o banco dvd_rental estabelecida com sucesso!\n");

            String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {
                for (Film f : filmesParaImportar) {
                    pstmtInsert.setString(1, f.getTitle());
                    pstmtInsert.setInt(2, f.getLanguageId());
                    pstmtInsert.setInt(3, f.getRentalDuration());
                    pstmtInsert.setDouble(4, f.getRentalRate());
                    pstmtInsert.setDouble(5, f.getReplacementCost());
                    
                    pstmtInsert.executeUpdate();
                }
                System.out.println("-> Importação concluída: " + filmesParaImportar.size() + " filmes inseridos.");
            }

            String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
                int linhasAtualizadas = pstmtUpdate.executeUpdate();
                System.out.println("-> Atualização concluída: " + linhasAtualizadas + " filmes tiveram a taxa aumentada em 10%.");
            }

            String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
                 ResultSet rs = pstmtSelect.executeQuery()) {
                
                System.out.println("\n-> Filmes com duração de locação igual a 99:");
                System.out.println("-------------------------------------------------");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate = rs.getDouble("rental_rate");
                    System.out.printf("Título: %-25s | Taxa: %.2f%n", title, rate);
                }
                System.out.println("-------------------------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Erro na comunicação com o banco de dados: " + e.getMessage());
        }
    }
}