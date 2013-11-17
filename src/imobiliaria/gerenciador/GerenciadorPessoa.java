
package imobiliaria.gerenciador;

import imobiliaria.model.Data;
import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author patick.smoraes
 */
public class GerenciadorPessoa {
    
    public static List<Pessoa> pessoas;
    
    public static void inicializa(List<Pessoa> modelo){
        pessoas = modelo;
    }
    
    
    public static Pessoa buscaPessoaPorCPF(String cpf){
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if(pessoa.getCPF().equals(cpf)) return pessoa;
        }
        return null;
    }
    
    public static void adiciona(Pessoa p){
        pessoas.add(p);
                
    }
    
    public static void removePessoa(Pessoa pessoa){
        pessoas.remove(pessoa);                
    }
    
    public static void adicionaPessoa(String nome, String CPF, Data dataNacimento, String endereco, String telefone, String email) {
        Pessoa pessoa = new Pessoa();        
        pessoa.setNome(nome);
        pessoa.setCPF(CPF);
        pessoa.setDataNascimento(dataNacimento);
        pessoa.setEndereco(endereco);        
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);                
        pessoas.add(pessoa);
    }
    
}
