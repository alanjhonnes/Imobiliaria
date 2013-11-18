/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.gerenciador.GerenciadorImovel;
import imobiliaria.gerenciador.GerenciadorPessoa;
import imobiliaria.gerenciador.GerenciadorVenda;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
import imobiliaria.model.Venda;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class ControladorVendas extends Controlador {
    
    private List<Venda> vendas;
    
    public ControladorVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public List<Venda> getVendas() {
        return vendas;
    }
    
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public void adicionaInteressado (Venda venda, Pessoa interessado) {
        GerenciadorVenda.adicionaInteressado(venda, interessado);
    }
    
    public void removeVenda(Venda venda) {
        GerenciadorVenda.removeVenda(venda);
    }

    public Pessoa buscaPessoa(String cpf) {
        return GerenciadorPessoa.buscaPessoaPorCPF(cpf);
    }

    public Venda buscaVendaPorIdImovel(int id) {
        return GerenciadorVenda.buscaVendaPorIdImovel(id);
        
    }

    public Terreno buscaImovelPorId(int id) {
        return GerenciadorImovel.buscaImovelPorId(id);
    }

    public void adicionaVenda(Terreno imovel) {
        GerenciadorVenda.adicionaVenda(imovel);
    }

}
