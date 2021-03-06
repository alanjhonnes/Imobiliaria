
package imobiliaria.gerenciador;

import imobiliaria.model.Aluguel;
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
    
    public static void adiciona(Pessoa pessoa){
        pessoas.add(pessoa);
                
    }
    
    public static boolean removePessoa(Pessoa pessoa){
        List<Aluguel> alugueis = GerenciadorAluguel.getAlugueis();
        //Retorna falso se a pessoa for encontrada como um proprietario ou locatario
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            if(aluguel.getImovel().getProprietario() == pessoa || aluguel.getLocatario() == pessoa){
                return false;
            }
        }
        pessoas.remove(pessoa);
        return true;
    }
    
//    public static void adicionaPessoa(String nome, String CPF, Data dataNacimento, String endereco, String telefone, String email) {
//        Pessoa pessoa = new Pessoa();        
//        pessoa.setNome(nome);
//        pessoa.setCPF(CPF);
//        pessoa.setDataNascimento(dataNacimento);
//        pessoa.setEndereco(endereco);        
//        pessoa.setTelefone(telefone);
//        pessoa.setEmail(email);                
//        pessoas.add(pessoa);
//    }
    
}
