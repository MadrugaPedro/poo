package dip.violacao;

public class Aplicacao {
    public static void main(String[] args) {
        ServicoRelatorioVendas servico = new ServicoRelatorioVendas();
        System.out.println(servico.gerarResumoMensal(2024, 3));
    }
}
