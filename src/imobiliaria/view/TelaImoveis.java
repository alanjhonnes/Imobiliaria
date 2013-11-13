/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorImoveis;
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
        String input;
        int opcao = 0;
        Scanner scan = new Scanner(System.in);

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

    
    
}
