import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {

    private static final Path LOG_FILE = Path.of("audit.log");

    public static void log(String operacao, String detalhes) {
        String linha = LocalDateTime.now() + " | " + operacao + " | " + detalhes + System.lineSeparator();

        try {
            Files.writeString(LOG_FILE, linha, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao gravar log de auditoria: " + e.getMessage());
        }
    }
}
