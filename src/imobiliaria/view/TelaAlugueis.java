/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorAlugueis;
import imobiliaria.model.Aluguel;
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
                    Aluguel.listarAluguel();
                    break;

                case 2:
                    Aluguel.adicionarAluguel();
                    break;

                case 3:
                    Aluguel.editarAluguel();
                    break;

                case 4:
                    Aluguel.removerAluguel();
                    break;

                case 5:
                    Aluguel.registrarPgtoAluguel();
                    break;
            }
        }
    }

    @Override
    public ControladorAlugueis getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorAlugueis) controlador;
    }

}
