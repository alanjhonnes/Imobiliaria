/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorVendas;
import imobiliaria.model.Imovel;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
import imobiliaria.model.Venda;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class TelaVendas extends Tela {

    private ControladorVendas controlador;
    private List<Venda> vendas;

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
        System.out.println("Imóvel a Venda: " + venda.getImovel().getId());
        List<Pessoa> interessados = venda.getInteressados();
        System.out.println("Interessados no Imóvel: " + interessados.size());
        for (int i = 0; i < interessados.size(); i++) {
            Pessoa pessoa = interessados.get(i);
            System.out.println(pessoa.getNome());
            System.out.println("---------");
        }
    }

    private void adicionaInteressado() {
        Venda venda = selecionaVenda();
        Pessoa interessado = selecionaPessoa();
        controlador.adicionaInteressado(venda, interessado);
        System.out.println("Interessado adicionado com sucesso.");
    }

    private Pessoa selecionaPessoa() {
        Pessoa interessado = null;
        while (interessado == null) {
            System.out.println("Digite o CPF da pessoa interessada:");
            String cpf = scan.nextLine();
            interessado = controlador.buscaPessoa(cpf);
            if (interessado == null) {
                System.out.println("CPF nao encontrado.");
            }
        }
        return interessado;
    }

    private Venda selecionaVenda() {
        Venda venda = null;
        while (venda == null) {
            System.out.println("Digite o ID do imóvel:");
            int id = Integer.parseInt(scan.nextLine());
            venda = controlador.buscaVendaPorIdImovel(id);
            if (venda == null) {
                System.out.println("Venda nao encontrada.");
            }
        }
        return venda;
    }

    private void removerVenda() {
        System.out.println("Remover Venda");
        System.out.println("Digite o id do imovel da venda a ser removida: ");
        input = scan.nextLine();
        int id = Integer.parseInt(input);
        Venda venda = controlador.buscaVendaPorIdImovel(id);
        if (venda != null) {
            controlador.removeVenda(venda);
            System.out.println("Venda removida");
        } else {
            System.out.println("Venda não Localizada");
        }
    }

    private void mostraMenuVendas() {
        int opcao = 0;


        while (opcao != 5) {

            System.out.println("== Menu Vendas ==");
            System.out.println("1. Listar.");
            System.out.println("2. Adicionar venda.");
            System.out.println("3. Adicionar interessado a venda.");
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
                    adicionaVenda();
                    break; 
                case 3:
                    adicionaInteressado();
                    break;
                case 4:
                    removerVenda();
                    break;
            }
        }
    }

    private void adicionaVenda() {
        System.out.println("Adicionar venda");
        Terreno imovel = selecionaImovel();
        controlador.adicionaVenda(imovel);
    }

    private Terreno selecionaImovel() {
        Terreno imovel = null;
        while(imovel == null){
            System.out.println("Digite o id do imovel a venda:");
            int id = Integer.parseInt(scan.nextLine());
            imovel = controlador.buscaImovelPorId(id);
            if(imovel == null){
                System.out.println("Imovel não encontrado.");
            }
            else if(imovel.getEstado().equals(Imovel.ESTADO_LOCACAO)){
                System.out.println("Imovel não está a venda.");
                imovel = null;
            }
        }
        return imovel;
    }
}
