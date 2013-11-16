/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorAlugueis;
import imobiliaria.model.Aluguel;
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
    
    public void mostraAluguel(Aluguel aluguel){
        System.out.println("Aluguel: ");
        System.out.println("Locatario: " + aluguel.getLocatario());
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
        String endereco;
        String estado;
        float iptu;
        String cpf;
        Pessoa pessoa = new Pessoa();
        float preco;
    }

}
