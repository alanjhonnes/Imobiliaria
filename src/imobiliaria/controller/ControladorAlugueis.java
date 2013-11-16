/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.gerenciador.GerenciadorPessoa;
import imobiliaria.model.Aluguel;
import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class ControladorAlugueis extends Controlador{
    
    private List<Aluguel> alugueis;

    public ControladorAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }    

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public Pessoa buscaPessoa(String cpf) {
        return GerenciadorPessoa.buscaPessoaPorCPF(cpf);
    }
    
     public Aluguel buscaAluguel(int id) {
        return GerenciadorAluguel.buscaAluguelPorId(id);
    }

    public void removeAluguel(Aluguel aluguel) {
        GerenciadorAluguel.remove(aluguel);
    }
    
    
    
}
