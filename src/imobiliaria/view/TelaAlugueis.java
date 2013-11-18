/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorAlugueis;
import imobiliaria.model.Aluguel;
import imobiliaria.model.Data;
import imobiliaria.model.Imovel;
import imobiliaria.model.Parcela;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alan.jbssa
 */
public class TelaAlugueis extends Tela {

    private ControladorAlugueis controlador;
    private List<Aluguel> alugueis;

    public TelaAlugueis(ControladorAlugueis controlador, List<Aluguel> alugueis) {
        super(controlador);
        this.alugueis = alugueis;
    }

    @Override
    public void mostra() {
        mostraMenu();
    }

    private void mostraMenu() {
        String input;
        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        while (opcao != 9) {

            System.out.println("== Menu Aluguel ==");
            System.out.println("1. Listar.");
            System.out.println("2. Adicionar.");
            System.out.println("3. Editar.");
            System.out.println("4. Remover.");
            System.out.println("5. Registrar Pagamento.");
            System.out.println("6. Relátorio Completo.");
            System.out.println("7. Parcelas pagas.");
            System.out.println("8. Parcelas nao pagas.");
            System.out.println("9. Sair.");

            System.out.println("Digite a opcao desejada:");
            input = scan.nextLine();
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    listarAluguel();
                    break;

                case 2:
                    adicionarAluguel();
                    break;

                case 3:
                    editarAluguel();
                    break;

                case 4:
                    removerAluguel();
                    break;

                case 5:
                    registrarPgtoAluguel();
                    break;

                case 6:
                    relatorio();
                    break;
                case 7:
                    relatorioPagas();
                    break;
                case 8:
                    relatorioNaoPagas();
                    break;
            }
        }
    }

    public void listarAluguel() {
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            mostraAluguel(aluguel);
            System.out.println("-----------");
        }
    }

    public void mostraAluguel(Aluguel aluguel) {
        System.out.println("Aluguel: ");
        System.out.println("Locatario: " + aluguel.getLocatario().getNome());
        System.out.println("Imovel: " + aluguel.getImovel().getId());
        System.out.println("Data Inicio: " + aluguel.getDataInicio());
        System.out.println("Data Final: " + aluguel.getDataFinal());
        System.out.println("Duracao do Contrato: " + aluguel.getDuracaoContrato());
        List<Parcela> parcelas = aluguel.getParcelas();
        System.out.println("Parcelas: " + aluguel.getParcelas().size());
        System.out.println("Preço: " + aluguel.getValor());
    }

    @Override
    public ControladorAlugueis getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorAlugueis) controlador;
    }

    private void adicionarAluguel() {

        Pessoa locatario;
        Terreno imovel;
        Data dataInicio;
        Data dataFinal;
        int duracaoContrato;
        float valor;

        System.out.println("Adicionar Aluguel");

        System.out.println("Selecionar Locatario");
        locatario = selecionaPessoa();
        
        System.out.println("Selecionar Imovel");
        imovel = selecionaImovel();

        System.out.println("Adicionar Data Inicio");
        dataInicio = lerData();

        System.out.println("Adicionar Data Final");
        dataFinal = lerData();

        System.out.println("Adicionar Duração Contrato");
        duracaoContrato = Integer.parseInt(scan.nextLine());

        System.out.println("Digite o valor do Aluguel:");
        valor = Float.parseFloat(scan.nextLine());

        controlador.adicionaAluguel(locatario, imovel, dataInicio, dataFinal, duracaoContrato, valor);
    }

    private Pessoa selecionaPessoa() {
        Pessoa proprietario = null;
        while (proprietario == null) {
            System.out.println("Digite o CPF do proprietário:");
            String cpf = scan.nextLine();
            proprietario = controlador.buscaPessoa(cpf);
            if (proprietario == null) {
                System.out.println("CPF nao encontrado.");
            }
        }
        return proprietario;
    }
    
    private Terreno selecionaImovel() {
        Terreno imovel = null;
        while (imovel == null) {
            System.out.println("Digite o id do imóvel:");
            int id = Integer.parseInt(scan.nextLine());
            imovel = controlador.buscaImovel(id);
            if (imovel == null) {
                System.out.println("Imovel nao encontrado.");
            }
            else if(imovel.getEstado().equals(Imovel.ESTADO_VENDA)){
                System.out.println("Imovel nao está para locação.");
                imovel = null;
            }
        }
        return imovel;
    }

    private Data lerData() {
        System.out.println("Dia(DD):");
        int dia = Integer.parseInt(scan.nextLine());
        System.out.println("Mês(MM):");
        int mes = Integer.parseInt(scan.nextLine());
        System.out.println("Ano(AAAA):");
        int ano = Integer.parseInt(scan.nextLine());
        return new Data(dia, mes, ano);
    }

    private void editarAluguel() {

        int id;
        Pessoa locatario;
        Data dataInicio;
        Data dataFinal;
        int duracaoContrato;
        float valor;
        Terreno imovel;

        System.out.println("Editar Aluguel");
        System.out.println("Digite o ID do Aluguel: ");
        input = scan.nextLine();
        id = Integer.parseInt(input);
        Aluguel aluguel = controlador.buscaAluguel(id);
        if (aluguel != null) {
            mostraAluguel(aluguel);

            System.out.println("Editar Locatario");
            locatario = selecionaPessoa();
            
            System.out.println("Editar Imovel");
            imovel = selecionaImovel();

            System.out.println("Editar Data Inicio");
            dataInicio = lerData();

            System.out.println("Editar Data Final");
            dataFinal = lerData();

            System.out.println("Editar Duração Contrato (meses)");
            duracaoContrato = Integer.parseInt(scan.nextLine());

            System.out.println("Editar o valor do Aluguel:");
            valor = Float.parseFloat(scan.nextLine());
            

            controlador.editaAluguel(aluguel, locatario, imovel, dataInicio, dataFinal, duracaoContrato, valor);
        }
    }

    private void removerAluguel() {
        System.out.println("Remover Locatorio");
        System.out.println("Digite o ID do Locatario: ");
        input = scan.nextLine();
        int id = Integer.parseInt(input);
        Aluguel aluguel = controlador.buscaAluguel(id);
        if (aluguel != null) {
            controlador.removeAluguel(aluguel);
        } else {
            System.out.println("Locatario nao encontrado.");
        }
    }

    private void registrarPgtoAluguel() {
        System.out.println("Registra Pagamento Aluguel");
        System.out.println("Digite o ID do aluguel: ");
        input = scan.nextLine();
        int id = Integer.parseInt(input);
        Aluguel aluguel = controlador.buscaAluguel(id);
        if (aluguel != null) {
            List<Parcela> parcelas = aluguel.getParcelas();

            listarParcelas(parcelas);

            int numero;
            boolean encontrada = false;
            Parcela parcela = null;
            do {
                System.out.println("Digite o número da parcela a ser paga:");
                numero = Integer.parseInt(scan.nextLine());
                if (numero < parcelas.size()) {
                    parcela = parcelas.get(numero);
                    parcela.setPaga(true);
                    encontrada = true;
                } else {
                    System.out.println("Parcela nao encontrada.");
                }
            } while (encontrada == false);

        } else {
            System.out.println("Aluguel nao encontrado.");
        }

    }

    private void relatorio() {
        System.out.println("Parcela Pagas e Devidas: ");
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            List<Parcela> parcelas = aluguel.getParcelas();
            System.out.println("Locatario: " + aluguel.getLocatario());
            System.out.println("Imovel: " + aluguel.getImovel());
            System.out.println("Parcelas: " + aluguel.getParcelas().size());
            System.out.println("Preço: " + aluguel.getValor());

            listarParcelas(parcelas);
        }
    }
    
    private void relatorioPagas() {
        System.out.println("Parcela Pagas: ");
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            List<Parcela> parcelas = aluguel.getParcelas();
            System.out.println("Locatario: " + aluguel.getLocatario());
            System.out.println("Imovel: " + aluguel.getImovel());
            System.out.println("Parcelas: " + aluguel.getParcelas().size());
            System.out.println("Preço: " + aluguel.getValor());

            listarParcelasPagas(parcelas);
        }
    }
    
    private void relatorioNaoPagas() {
        System.out.println("Parcela Devidas: ");
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            List<Parcela> parcelas = aluguel.getParcelas();
            System.out.println("Locatario: " + aluguel.getLocatario());
            System.out.println("Imovel: " + aluguel.getImovel());
            System.out.println("Parcelas: " + aluguel.getParcelas().size());
            System.out.println("Preço: " + aluguel.getValor());

            listarParcelasNaoPagas(parcelas);
        }
    }

    private void listarParcelas(List<Parcela> parcelas) {
        for (int i = 0; i < parcelas.size(); i++) {
            Parcela parcela = parcelas.get(i);
            System.out.println("Parcela " + i);
            System.out.println("Paga:" + parcela.isPaga());
            System.out.println("Valor: " + parcela.getValor());
            System.out.println("Dia Vencimento: " + parcela.getDiaVencimento());
            System.out.println("-------");
        }
    }

    private void listarParcelasPagas(List<Parcela> parcelas) {
        for (int i = 0; i < parcelas.size(); i++) {
            Parcela parcela = parcelas.get(i);
            if (parcela.isPaga()) {
                System.out.println("Parcela " + i);
                System.out.println("Valor: " + parcela.getValor());
                System.out.println("Dia Vencimento: " + parcela.getDiaVencimento());
                System.out.println("-------");
            }
        }
    }

    private void listarParcelasNaoPagas(List<Parcela> parcelas) {
        for (int i = 0; i < parcelas.size(); i++) {
            Parcela parcela = parcelas.get(i);
            if (!parcela.isPaga()) {
                System.out.println("Parcela " + i);
                System.out.println("Valor: " + parcela.getValor());
                System.out.println("Dia Vencimento: " + parcela.getDiaVencimento());
                System.out.println("-------");
            }
        }
    }
}
