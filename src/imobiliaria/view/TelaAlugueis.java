/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorAlugueis;
import imobiliaria.model.Aluguel;
import imobiliaria.model.Data;
import imobiliaria.model.Pessoa;
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

        while (opcao != 6) {

            System.out.println("== Menu Aluguel ==");
            System.out.println("1. Listar.");
            System.out.println("2. Adicionar.");
            System.out.println("3. Editar.");
            System.out.println("4. Remover.");
            System.out.println("5. Registrar Pagamento.");
            System.out.println("6. Sair.");

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
        System.out.println("Locatario: " + aluguel.getLocatario());
        System.out.println("Imovel: " + aluguel.getImovel());
        System.out.println("Data Inicio: " + aluguel.getDataInicio());
        System.out.println("Data Final: " + aluguel.getDataFinal());
        System.out.println("Duracao do Contrato: " + aluguel.getDuracaoContrato());
        System.out.println("Parcelas: " + aluguel.getParcelas());
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
        
        Aluguel a = new Aluguel();
        int id;
        Pessoa locatario;
        Data dataInicio;
        Data dataFinal;
        int duracaoContrato;
        int parcelas;
        float valor;

        System.out.println("Adicionar Aluguel");
        
        System.out.println("Adicionar Locatario");
        locatario = selecionaPessoa();
               
        System.out.println("Adicionar Data Inicio");
        dataInicio = lerData();
               
        System.out.println("Adicionar Data Final");
        dataFinal = lerData();
         
        System.out.println("Adicionar Duração Contrato");
        duracaoContrato = Integer.parseInt(scan.nextLine());
        
        System.out.println("Adicionar numero de Parcelas");
        parcelas = Integer.parseInt(scan.nextLine());
        
        System.out.println("Digite o valor do Aluguel:");
        valor = Float.parseFloat(scan.nextLine());
        
        
        //MR COROLA
        controlador.adicionaAluguel(locatario, dataInicio, dataFinal, duracaoContrato, parcelas, valor);
        
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
        
    }
}
