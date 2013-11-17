/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorImoveis;
import imobiliaria.model.Casa;
import imobiliaria.model.Imovel;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Predio;
import imobiliaria.model.Terreno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alan.jbssa
 */
public class TelaImoveis extends Tela {

    private ControladorImoveis controlador;
    private List<Terreno> imoveis;

    public TelaImoveis(ControladorImoveis controlador, List<Terreno> imoveis) {
        super(controlador);
        this.imoveis = imoveis;
    }

    @Override
    public void mostra() {
        mostraImoveis();
        mostraMenu();
    }

    private void mostraMenu() {
        int opcao = 0;


        while (opcao != 7) {

            System.out.println("== Menu Imóveis ==");
            System.out.println("1. Listar.");
            System.out.println("2. Adicionar.");
            System.out.println("3. Editar");
            System.out.println("4. Remover");
            System.out.println("5. Listar imoveis disponíveis para alugar.");
            System.out.println("6. Listar imoveis por preço");
            System.out.println("7. Sair.");

            System.out.println("Digite a opcao desejada:");
            input = scan.nextLine();
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    mostraImoveis();
                    break;

                case 2:
                    adicionaImovel();
                    break;

                case 3:
                    editaImovel();
                    break;

                case 4:
                    removerImovel();
                    break;
                case 5:
                    listarDisponiveis();
                    break;
                case 6:
                    buscarPorPreco();
                    break;
            }
        }
    }

    public void mostraImoveis() {
        for (int i = 0; i < imoveis.size(); i++) {
            Terreno imovel = imoveis.get(i);
            mostraImovel(imovel);
            System.out.println("-----------");
        }
    }

    public void mostraImovel(Terreno imovel) {
        System.out.println("Imovel ID: " + imovel.getId());
        System.out.println("Tipo:" + imovel.getTipo());
        System.out.println("Endereço: " + imovel.getEndereco());
        System.out.println("Preço: " + imovel.getPreco());
        System.out.println("IPTU: " + imovel.getIptu());
        System.out.println("Estado: " + imovel.getEstado());
        System.out.println("Data de cadastro: " + imovel.getDataCadastro().toString());
        System.out.println("Proprietário: " + imovel.getProprietario().getNome());
        if (imovel.getTipo().equals(Imovel.TIPO_CASA)) {
            Casa casa = (Casa) imovel;
            System.out.println("Area: " + casa.getArea());
        } else if (imovel.getTipo().equals(Imovel.TIPO_PREDIO)) {
            Predio predio = (Predio) imovel;
            System.out.println("Area: " + predio.getArea());
            System.out.println("Valor condomínio: " + predio.getValorCondominio());
        }

    }

    @Override
    public ControladorImoveis getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorImoveis) controlador;
    }

    private void adicionaImovel() {
        Terreno t = new Terreno();

        int id;
        String endereco;
        String estado;
        float iptu;
        String cpf;
        Pessoa proprietario;
        float preco;


        System.out.println("Adicionar imóvel");
        System.out.println("Digite o endereço: ");
        endereco = scan.nextLine();
        estado = selecionaEstado();

        System.out.println("Digite o valor do iptu:");
        iptu = Float.parseFloat(scan.nextLine());
        System.out.println("Digite o valor do imóvel:");
        preco = Float.parseFloat(scan.nextLine());
        proprietario = selecionaPessoa();
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

                System.out.println("Digite o valor do condomínio:");
                condominio = Float.parseFloat(scan.nextLine());

                controlador.adicionaPredio(endereco, estado, iptu, preco, proprietario, area, condominio);
            }
        }
    }

    private void editaImovel() {
        int id;
        String endereco;
        String estado;
        float iptu;
        String cpf;
        Pessoa proprietario;
        float preco;
        float condominio;
        String area;

        System.out.println("Editar imóvel");
        System.out.println("Digite o ID do imóvel: ");
        input = scan.nextLine();
        id = Integer.parseInt(input);
        Terreno imovel = controlador.buscaImovel(id);
        if (imovel != null) {
            mostraImovel(imovel);

            System.out.println("Digite o endereço: ");
            endereco = scan.nextLine();
            estado = selecionaEstado();


            System.out.println("Digite o valor do iptu:");
            iptu = Float.parseFloat(scan.nextLine());
            System.out.println("Digite o valor do imóvel:");
            preco = Float.parseFloat(scan.nextLine());
            proprietario = selecionaPessoa();



            if (imovel.getTipo().equals(Imovel.TIPO_TERRENO)) {
                controlador.editaTerreno(imovel, endereco, estado, iptu, preco, proprietario);
            } else if (imovel.getTipo().equals(Imovel.TIPO_CASA)) {
                Casa casa = (Casa) imovel;

                area = selecionaArea();

                controlador.editaCasa(casa, endereco, estado, iptu, preco, proprietario, area);

            } else if (imovel.getTipo().equals(Imovel.TIPO_PREDIO)) {
                Predio predio = (Predio) imovel;

                input = "";
                area = selecionaArea();

                System.out.println("Digite o valor do condomínio:");
                condominio = Float.parseFloat(scan.nextLine());

                controlador.editaPredio(predio, endereco, estado, iptu, preco, proprietario, area, condominio);
            }
        } else {
            System.out.println("Imóvel nao encontrado.");
        }
    }

    private void removerImovel() {
        System.out.println("Remover imóvel");
        System.out.println("Digite o ID do imóvel: ");
        input = scan.nextLine();
        int id = Integer.parseInt(input);
        Terreno imovel = controlador.buscaImovel(id);
        if (imovel != null) {
            if(controlador.removeImovel(imovel)){
                System.out.println("Imovel nao pode ser excluido pois possui um contrato de locacao ativo.");
            }
            else {
                System.out.println("Imovel removido.");
            }
        } else {
            System.out.println("Imóvel nao encontrado.");
        }
    }

    //FUNCOES DE AJUDA
    private String selecionaEstado() {
        String input = "";
        String estado = "";
        while (!(input.equals("v") || input.equals("l"))) {
            System.out.println("Digite o estado do imóvel (v para Venda, l para Locação: ");
            input = scan.nextLine();
            if (input.equals("v")) {
                estado = Imovel.ESTADO_VENDA;
            } else if (input.equals("l")) {
                estado = Imovel.ESTADO_LOCACAO;
            }
        }
        return estado;
    }

    private String selecionaArea() {
        String input = "";
        String area = "";
        while (!(input.equals("c") || input.equals("r"))) {
            System.out.println("Selecione a área (c para Comercial, r para Residencial):");
            input = scan.nextLine();

            if (input.equals("c")) {
                area = Imovel.AREA_COMERCIAL;
            } else if (input.equals("r")) {
                area = Imovel.AREA_RESIDENCIAL;
            }

        }
        return area;
    }
    
    private Pessoa selecionaPessoa(){
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
    
    private void listarDisponiveis() {
        System.out.println("Listando imoveis disponiveis para alugar");
        List<Terreno> disponiveis = controlador.buscarImoveisDisponiveis();
        for (int i = 0; i < disponiveis.size(); i++) {
            Terreno imovel = disponiveis.get(i);
            mostraImovel(imovel);
        }
    }

    private void buscarPorPreco() {
        System.out.println("Buscar por preco");
        System.out.println("Digite o valor mínimo:");
        float min = Float.parseFloat(scan.nextLine());
        System.out.println("Digite o valor máximo:");
        float max = Float.parseFloat(scan.nextLine());
        
        List<Terreno> resultado = controlador.buscaPorPreco(min, max);
        for (int i = 0; i < resultado.size(); i++) {
            Terreno imovel = resultado.get(i);
            mostraImovel(imovel);
        }
    }

    
}
