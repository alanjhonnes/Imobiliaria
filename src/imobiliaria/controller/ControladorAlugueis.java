/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.gerenciador.GerenciadorAluguel;
import imobiliaria.gerenciador.GerenciadorImovel;
import imobiliaria.gerenciador.GerenciadorPessoa;
import imobiliaria.model.Aluguel;
import imobiliaria.model.Data;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
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
    
    public void adicionaAluguel(Aluguel aluguel){
        GerenciadorAluguel.adicionaAluguel(aluguel);
    }

    public void adicionaAluguel(Pessoa locatario, Terreno imovel, Data dataInicio, Data dataFinal, int duracaoContrato, float valor) {
        Aluguel aluguel = new Aluguel();
        aluguel.setImovel(imovel);
        aluguel.setLocatario(locatario);
        aluguel.setDataInicio(dataInicio);
        aluguel.setDataFinal(dataFinal);
        aluguel.setValor(valor);
        aluguel.setDuracaoContrato(duracaoContrato);
        aluguel.setId(GerenciadorAluguel.geraIDAluguel());
        GerenciadorAluguel.adicionaAluguel(aluguel);
    }
    
    public void editaAluguel(Aluguel aluguel, Pessoa locatario, Terreno imovel, Data dataInicio, Data dataFinal, int duracaoContrato, float valor) {
        aluguel.setImovel(imovel);
        aluguel.setLocatario(locatario);
        aluguel.setDataInicio(dataInicio);
        aluguel.setDataFinal(dataFinal);
        aluguel.setValor(valor);
        aluguel.setDuracaoContrato(duracaoContrato);
    }

    public Terreno buscaImovel(int id) {
        return GerenciadorImovel.buscaImovelPorId(id);
    }
}
