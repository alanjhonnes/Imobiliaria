/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorImoveis;
import imobiliaria.model.Imovel;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alan.jbssa
 */
public class TelaImoveis extends Tela {
    
    private ControladorImoveis controlador;
    private List<Terreno> terrenos;

    public TelaImoveis(ControladorImoveis controlador, List<Terreno> terrenos) {
        super(controlador);
        this.terrenos = terrenos;
    }

    @Override
    public void mostra() {
        mostraImoveis();
        mostraMenu();
    }
    
    private void mostraMenu() {
        int opcao = 0;
        

        while (opcao != 5) {

            System.out.println("== Menu Imóveis ==");
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
                    mostraImoveis();
                    break;

                case 2:
                    adicionaImovel();
                    break;

                case 3:
                    
                    break;

                case 4:
                    System.out.println("Digite o ID do imóvel:");
                    
                    break;
            }
        }
    }
    
    public void mostraImoveis(){
        for (int i = 0; i < terrenos.size(); i++) {
            Terreno terreno = terrenos.get(i);
            mostraImovel(terreno);
            System.out.println("-----------");
        }
    }
    
    public void mostraImovel(Terreno terreno){
        System.out.println("Terreno: ");
        System.out.println("Endereço: " + terreno.getEndereco());
        System.out.println("Preço: " + terreno.getPreco());
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
        Pessoa pessoa = new Pessoa();
        float preco;
        
        
        System.out.println("Adicionar imóvel");
        System.out.println("Digite o ID do imóvel: ");
        input = scan.nextLine();
        id = Integer.parseInt(input);
        System.out.println("Digite o endereço: ");
        endereco = scan.nextLine();
        input = "";
        while(!(input.equals("v") || input.equals("l"))){
            System.out.println("Digite o estado do imóvel (v para Venda, l para Locação: ");
            input = scan.nextLine();
            if(input.equals("v")){
                estado = Imovel.ESTADO_VENDA;
            }
            else if(input.equals("l")){
                estado = Imovel.ESTADO_LOCACAO;
            }
        }
        
        System.out.println("Digite o valor do iptu:");
        iptu = Float.parseFloat(scan.nextLine());
        System.out.println("Digite o valor do imóvel:");
        preco = Float.parseFloat(scan.nextLine());
        System.out.println("Digite o CPF do proprietário:");
        cpf = scan.nextLine();
        input = "";
        while(!(input.equals("t") || input.equals("c")|| input.equals("p"))){
            System.out.println("Selecione o tipo de imóvel (t para Terreno, c para Casa, p para Prédio):");
            input = scan.nextLine();
            if(input.equals("t")){
                estado = Imovel.TIPO_TERRENO;
                controlador.adicionaTerreno(id, endereco, estado, iptu, preco, pessoa);
            }
            else if(input.equals("c")){
                estado = Imovel.TIPO_CASA;
            }
            else if(input.equals("p")){
                estado = Imovel.TIPO_PREDIO;
            }
        }
    }

    
    
}
