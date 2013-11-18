/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorVendas;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Venda;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class TelaVendas extends Tela {

    private ControladorVendas controlador;
    private List<Venda> vendas;
    private int valor;

    public TelaVendas(ControladorVendas controlador, List<Venda> vendas) {
        super(controlador);
        this.vendas = vendas;
    }

    @Override
    public void mostra() {
        mostraVendas();
        mostraMenuVendas();
    }

    @Override
    public ControladorVendas getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorVendas) controlador;
    }

    private void mostraVendas() {
        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            mostraVenda(venda);
            System.out.println("-----------");
        }
    }

    public void mostraVenda(Venda venda) {
        System.out.println("Imóvel a Venda: " + venda.getNome());
        System.out.println("Interessados no Imóvel:" + venda.getInteressados());
        System.out.println("Preço do Imóvel:" + venda.getValor());
        System.out.println("Endereço do Imóvel:" + venda.getEndereco());

    }

    private void adicionaInteressado() {
        Pessoa pessoa = new Pessoa();

        String nome;
        String CPF;
        String telefone;
        String email;

        System.out.println("\nAdicionar Pessoas\n");

        System.out.println("Digite o Nome: ");
        nome = scan.nextLine();

        System.out.println("Digite o CPF: ");
        CPF = scan.nextLine();

        System.out.println("Digite o Telefone:");
        telefone = scan.nextLine();

        System.out.println("Digite o Email:");
        email = scan.nextLine();

        controlador.adicionaInteressado (nome, CPF, telefone, email);
    }

    private void editaVenda() {
        
        String nome;
        String CPF;

        String endereco;
        String telefone;
        String email;

        System.out.println("Editar Status da Venda");

        System.out.println("Digite o CPF da Pessoa: ");
        endereco = scan.nextLine();
        Venda venda = controlador.buscaVenda(endereco);
        if (venda != null) {
            mostraVenda (venda);

            System.out.println("Digite o Nome: ");
            nome = scan.nextLine();

            System.out.println("Digite o CPF: ");
            CPF = scan.nextLine();

            System.out.println("Digite o Endereço:");
            endereco = scan.nextLine();

            System.out.println("Digite o Telefone:");
            telefone = scan.nextLine();

            System.out.println("Digite o Email:");
            email = scan.nextLine();

            controlador.editaVenda(venda, nome, CPF, endereco, telefone, valor, email);

        } else {
            System.out.println("Pessoa nao encontrada.");
        }
    }

    private void removerImóvel() {
        System.out.println("Remover Imóvel");
        System.out.println("Digite o Imóvel a ser removido: ");
        input = scan.nextLine();
        String Endereco = String.valueOf(input);
        Venda venda = controlador.buscaVenda(Endereco);
        if (Endereco != null) {
            controlador.removeVenda(venda);
        } else {
            System.out.println("Imóvel não Localizado");
        }
    }

    private void mostraMenuVendas() {
        int opcao = 0;


        while (opcao != 5) {

            System.out.println("== Menu Pessoas ==");
            System.out.println("1. Listar.");
            System.out.println("2. Adicionar.");
            System.out.println("3. Editar");
            System.out.println("4. Remover");
            System.out.println("5. Sair.");

            System.out.println("Digite a opcao desejada:");
            input = scan.nextLine();
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    mostraVendas();
                    break;

                case 2:
                    adicionaInteressado();
                    break;

                case 3:
                 editaVenda();
                 break;

                case 4:
                    removerImóvel();
                    System.out.println("Digite o Endereço do Imóvel:");
                    break;

            }
        }
    }
}
