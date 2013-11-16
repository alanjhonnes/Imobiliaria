/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorPessoas;
import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class TelaPessoas extends Tela {
    
    private ControladorPessoas controlador;
    private List<Pessoa> pessoas;

    public TelaPessoas(ControladorPessoas controlador, List<Pessoa> pessoas) {
        super(controlador);
        this.pessoas = pessoas;
    }
    
    

    @Override
    public void mostra() {
        mostraPessoas();
        mostraMenuPessoas();                
    }
    
    private void mostraMenuPessoas() {
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
                    mostraPessoas();
                    break;

                case 2:
                    //adicionaImovel();
                    break;

                case 3:
                    //editaImovel();
                    break;

                case 4:
                    //removerImovel();
                    System.out.println("Digite o ID do imóvel:");
                    break;
            }
        }
    }
    
    public void mostraPessoas() {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            mostraPessoa(pessoa);
            System.out.println("-----------");
        }
    }
    
    public void mostraPessoa(Pessoa pessoa) {
        System.out.println("Nome Pessoa: " + pessoa.getNome());
        System.out.println("CPF:" + pessoa.getCPF());
        System.out.println("Endereço: " + pessoa.getEndereco());
        System.out.println("Telefone: " + pessoa.getTelefone());
        System.out.println("E-mail: " + pessoa.getEmail());
//        if (imovel.getTipo().equals(Imovel.TIPO_CASA)) {
//            Casa casa = (Casa) imovel;
//            System.out.println("Area: " + casa.getArea());
//        } else if (imovel.getTipo().equals(Imovel.TIPO_PREDIO)) {
//            Predio predio = (Predio) imovel;
//            System.out.println("Area: " + predio.getArea());
//            System.out.println("Valor condomínio: " + predio.getValorCondominio());
//        }

    }
    
    

    @Override
    public ControladorPessoas getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorPessoas) controlador;
    }

   
    
}
