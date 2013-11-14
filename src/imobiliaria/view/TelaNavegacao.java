/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.Navegacao;
import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorNavegacao;
import java.util.Scanner;
import imobiliaria.model.Imobiliaria;

/**
 *
 * @author alan.jbssa
 */
public class TelaNavegacao extends Tela {
    
    private ControladorNavegacao controlador;

    public TelaNavegacao(ControladorNavegacao controlador) {
        super(controlador);
    }

    @Override
    public void mostra() {
        String input;
        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        while (opcao != 5) {

            System.out.println("== PROGRAMA PARA IMOBILIÁRIA ==");
            System.out.println("1. Tela pessoas.");
            System.out.println("2. Tela imoveis.");
            System.out.println("3. Tela alugueis.");
            System.out.println("4. Tela vendas.");
            System.out.println("5. Sair.");

            System.out.println("Digite a opcão desejada :");
            input = scan.nextLine();
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    Navegacao.mostraTela(Navegacao.TELA_PESSOAS);
                    break;

                case 2:
                    Navegacao.mostraTela(Navegacao.TELA_IMOVEIS);
                    break;

                case 3:
                    Navegacao.mostraTela(Navegacao.TELA_ALUGUEIS);
                    break;

                case 4:
                    Navegacao.mostraTela(Navegacao.TELA_VENDAS);
                    break;
            }
        }
    }

    @Override
    public ControladorNavegacao getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorNavegacao) controlador;
    }
}