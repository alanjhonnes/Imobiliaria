
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorPessoas;
import imobiliaria.model.Data;
import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author patrick.smoraes
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
                    adicionaPessoas();
                    break;

                case 3:
                    editaPessoa();
                    break;

                case 4:
                    removerPessoa();
                    System.out.println("Digite o CPF da Pessoa:");
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
        System.out.println("Data Nascimento" + pessoa.getDataNascimento());
        System.out.println("Endereço: " + pessoa.getEndereco());
        System.out.println("Telefone: " + pessoa.getTelefone());
        System.out.println("E-mail: " + pessoa.getEmail());
    }        

    @Override
    public ControladorPessoas getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorPessoas) controlador;
    }
    
    private void adicionaPessoas() {
        Pessoa pessoa = new Pessoa();

        String nome;
        String CPF; 
        String endereco;
        String telefone;
        String email;                               

        System.out.println("\n Adicionar Pessoas \n");
        
        System.out.println("Digite o Nome: ");
        nome = scan.nextLine();                      
        
        System.out.println("Digite o CPF: ");
        CPF = scan.nextLine();

        System.out.println("Digite a Data de Nascimento:");
        Data dataNascimento = lerData();
        
        System.out.println("Digite o Endereço:");
        endereco = scan.nextLine();
        
        System.out.println("Digite o Telefone:");
        telefone = scan.nextLine();
        
        System.out.println("Digite o Email:");
        email = scan.nextLine();       
                      
        controlador.adicionaPessoa(nome, CPF, dataNascimento, endereco, telefone, email);
    } 
    
    private void editaPessoa() {        
        String nome;
        String CPF;
         
        String endereco;
        String telefone;
        String email;

        System.out.println("Editar Pessoas");
        
        System.out.println("Digite o CPF da Pessoa: ");
        CPF = scan.nextLine();
        Pessoa pessoa = controlador.buscaPessoa(CPF);
        if (pessoa != null) {
            mostraPessoa(pessoa);
            
            System.out.println("Digite o Nome: ");
            nome = scan.nextLine();                      
        
            System.out.println("Digite o CPF: ");
            CPF = scan.nextLine();

            System.out.println("Digite a Data de Nascimento:");
            Data dataNascimento = lerData();
        
            System.out.println("Digite o Endereço:");
            endereco = scan.nextLine();
        
            System.out.println("Digite o Telefone:");
            telefone = scan.nextLine();
        
            System.out.println("Digite o Email:");
            email = scan.nextLine();    
            
            controlador.editaPessoa(pessoa, nome, CPF, dataNascimento, endereco, telefone, email);
           
        } else {
            System.out.println("Pessoa nao encontrada.");
        }
    }
    
    private void removerPessoa() {
        System.out.println("Remover Pessoas");
        System.out.println("Digite o CPF da Pessoa: ");
        input = scan.nextLine();
        String CPF = String.valueOf(input);
        Pessoa pessoa = controlador.buscaPessoa(CPF);
        if (CPF != null) {
            controlador.removePessoa(pessoa);
        } else {
            System.out.println("Pessoa nao encontrado.");
        }
    }
    
    private Data lerData() {
        System.out.println("Dia(DD):");
        int dia = Integer.parseInt(scan.nextLine());
        System.out.println("Mês(MM):");
        int mes = Integer.parseInt(scan.nextLine());
        System.out.println("Ano(AAAA):");
        int ano = Integer.parseInt(scan.nextLine());
        Data dataNascimento = new Data();
        dataNascimento.setDia(dia);
        dataNascimento.setMes(mes);
        return dataNascimento;       
    }
    
}

