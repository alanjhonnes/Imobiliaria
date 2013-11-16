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

    public static void listarAluguel() {
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
        Pessoa pessoa = new Pessoa();
        int dataInicio;
        int dataFinal;
        int duracaoContrato;
        int parcelas;
        float valor;

        System.out.println("Adicionar Aluguél");
        
        System.out.println("Adicionar Locatario");
        locatario = selecionaPessoa();
        
        System.out.println("Digite o valor do Aluguel:");
        valor = Float.parseFloat(scan.nextLine());
        
        System.out.println("Adicionar Data Inicio");
        System.out.println("Dia(DD)");
        Data data = new Data();
        int dia = Integer.parseInt(scan.nextLine());
        data.setDia(dia);
        System.out.println("Mês(MM)");
        int mes = Integer.parseInt(scan.nextLine());
        data.setMes(mes);   
        System.out.println("Ano(AAAA)");
        int ano = Integer.parseInt(scan.nextLine());
        data.setAno(ano);
        
        System.out.println("Adicionar Data Final");
        System.out.println("Dia(DD)");
        int dia = Integer.parseInt(scan.nextLine());
        data.setDia(dia);
        System.out.println("Mês(MM)");
        int mes = Integer.parseInt(scan.nextLine());
        data.setMes(mes);   
        System.out.println("Ano(AAAA)");
        int ano = Integer.parseInt(scan.nextLine());
        data.setAno(ano);
                
        
        System.out.println("Adicionar Duração Contrato");
        duracaoContrato = Int.parseInt(scan.nextLine());
        
                
        input = "";
        while (!(input.equals("t") || input.equals("c") || input.equals("p"))) {
            System.out.println("Selecione o tipo de imóvel (t para Terreno, c para Casa, p para Prédio):");
            input = scan.nextLine();
            if (input.equals("t")) {
                controlador.adicionaTerreno(endereco, estado, iptu, preco, proprietario);
            } else if (input.equals("c")) {
                String area = selecionaArea();
                controlador.adicionaCasa(endereco, estado, iptu, preco, proprietario, area);
            } else if (input.equals("p")) {
                String area = selecionaArea();
                float condominio;
            }
        }
        
    private Pessoa selecionaPessoa() {
        Pessoa proprietario = null;
        while (proprietario == null) {
            System.out.println("Digite o CPF do proprietário:");
            String cpf = scan.nextLine();
            proprietario = controlador.buscaProprietario(cpf);
            if (proprietario == null) {
                System.out.println("CPF nao encontrado.");
            }
        }
        return proprietario;
    }
}
