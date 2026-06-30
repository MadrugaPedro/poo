import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();

        try (Connection conn = DBConnection.getConnection()) {
            boolean sair = false;

            while (!sair) {
                System.out.println();
                System.out.println("1 - Inserir novo filme");
                System.out.println("2 - Buscar filme por ID");
                System.out.println("3 - Atualizar filme");
                System.out.println("4 - Listar atores de um filme");
                System.out.println("5 - Excluir ator por ID");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1:
                        inserirFilme(conn, scanner, filmDAO);
                        break;
                    case 2:
                        buscarFilme(conn, scanner, filmDAO);
                        break;
                    case 3:
                        atualizarFilme(conn, scanner, filmDAO);
                        break;
                    case 4:
                        listarAtores(conn, scanner, filmDAO);
                        break;
                    case 5:
                        excluirAtor(conn, scanner, actorDAO);
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco de dados: " + e.getMessage());
        }

        scanner.close();
    }

    private static void inserirFilme(Connection conn, Scanner scanner, FilmDAO filmDAO) throws SQLException {
        System.out.print("Título: ");
        String title = scanner.nextLine().trim();

        System.out.print("ID do idioma: ");
        int languageId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Duração da locação (dias): ");
        int rentalDuration = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Valor da locação: ");
        double rentalRate = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Custo de reposição: ");
        double replacementCost = Double.parseDouble(scanner.nextLine().trim());

        Film film = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
        int filmId = filmDAO.insert(conn, film);

        System.out.println("Filme inserido com ID " + filmId + ".");
        AuditLogger.log("INSERT", "filme id=" + filmId + " title=" + title);
    }

    private static void buscarFilme(Connection conn, Scanner scanner, FilmDAO filmDAO) throws SQLException {
        System.out.print("ID do filme: ");
        int filmId = Integer.parseInt(scanner.nextLine().trim());

        Film film = filmDAO.findById(conn, filmId);

        if (film == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println(film);
        }
    }

    private static void atualizarFilme(Connection conn, Scanner scanner, FilmDAO filmDAO) throws SQLException {
        System.out.print("ID do filme a atualizar: ");
        int filmId = Integer.parseInt(scanner.nextLine().trim());

        Film filmAtual = filmDAO.findById(conn, filmId);
        if (filmAtual == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.print("Novo título: ");
        String title = scanner.nextLine().trim();

        System.out.print("Novo ID do idioma: ");
        int languageId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Nova duração da locação (dias): ");
        int rentalDuration = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Novo valor da locação: ");
        double rentalRate = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Novo custo de reposição: ");
        double replacementCost = Double.parseDouble(scanner.nextLine().trim());

        Film film = new Film(filmId, title, languageId, rentalDuration, rentalRate, replacementCost);
        boolean atualizou = filmDAO.update(conn, film);

        if (atualizou) {
            System.out.println("Filme atualizado com sucesso.");
            AuditLogger.log("UPDATE", "filme id=" + filmId + " title=" + title);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private static void listarAtores(Connection conn, Scanner scanner, FilmDAO filmDAO) throws SQLException {
        System.out.print("ID do filme: ");
        int filmId = Integer.parseInt(scanner.nextLine().trim());

        Film film = filmDAO.findById(conn, filmId);
        if (film == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        List<String> atores = filmDAO.listActorNames(conn, filmId);

        if (atores.isEmpty()) {
            System.out.println("Nenhum ator encontrado para este filme.");
        } else {
            System.out.println("Atores de \"" + film.getTitle() + "\":");
            for (String ator : atores) {
                System.out.println("- " + ator);
            }
        }
    }

    private static void excluirAtor(Connection conn, Scanner scanner, ActorDAO actorDAO) throws SQLException {
        System.out.print("ID do ator a excluir: ");
        int actorId = Integer.parseInt(scanner.nextLine().trim());

        boolean excluiu = actorDAO.deleteById(conn, actorId);

        if (excluiu) {
            System.out.println("Ator excluído com sucesso.");
            AuditLogger.log("DELETE", "ator id=" + actorId);
        } else {
            System.out.println("Ator não encontrado.");
        }
    }
}
