/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.gerenciador.GerenciadorVenda;
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
    
    public void adicionaInteressado (String nome, String CPF, String telefone, String email) {
        Venda venda = new Venda();
        venda.setNome(nome);
        venda.setEndereco(CPF);
        venda.setTelefone(telefone);
        venda.setEmail(email);
        GerenciadorVenda.adicionaInteressado(null);
    }
    
    public Venda buscaVenda(String endereco) {
        return GerenciadorVenda.buscaImovelPorEndereco(endereco);
    }
    
    public void removeVenda(Venda venda) {
        GerenciadorVenda.removeVenda(venda);
    }
    
    public void editaVenda(Venda venda, String nome, String CPF, String endereco, String telefone, int valor, String email) {
        venda.setNome(nome);
        venda.setEndereco(endereco);
        venda.setValor(valor);
        venda.setImovel(null);
        venda.setInteressados(null);
    }
}
