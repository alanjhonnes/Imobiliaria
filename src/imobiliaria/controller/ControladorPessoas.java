
package imobiliaria.controller;

import imobiliaria.gerenciador.GerenciadorPessoa;
import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author patrick.smoraes
 */
public class ControladorPessoas extends Controlador{
    
    private List<Pessoa> pessoas;

    public ControladorPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
   
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    
    public void adicionaPessoa(String nome, String CPF, 
         Data dataNascimento, String endereco, String telefone, String email) {
         GerenciadorPessoa.adicionaPessoa (nome, CPF, dataNascimento, endereco,
                telefone, email);                     
    }
    
    public Pessoa buscaPessoa (String CPF){
        return GerenciadorPessoa.buscaPessoaPorCPF(CPF);
    }
    
    public void removePessoa (Pessoa pessoa){
        GerenciadorPessoa.removePessoa(pessoa);
    }
    
    public void editaPessoa(String nome, String CPF, Data dataNascimento, String endereco, String telefone, String Email) {
        Pessoa.setNome(nome);
        Pessoa.setCPF(CPF);
        Pessoa.setData(dataNascimento);
        Pessoa.setPessoa(endereco);
        Pessoa.setTelefone(telefone);
        Pessoa.setEmail(Email);
}
