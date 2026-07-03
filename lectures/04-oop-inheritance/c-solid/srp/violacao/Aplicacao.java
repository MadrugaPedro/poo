package srp.violacao;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        List<Funcionario> equipe = new ArrayList<>();
        equipe.add(new Funcionario("Ana", 6400.0));
        equipe.add(new Funcionario("Bruno", 5200.0));

        FolhaPagamentoService service = new FolhaPagamentoService(equipe);
        service.processarFolhaMensal();
    }
}
