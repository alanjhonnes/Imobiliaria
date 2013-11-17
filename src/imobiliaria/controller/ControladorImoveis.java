/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.gerenciador.GerenciadorAluguel;
import imobiliaria.gerenciador.GerenciadorImovel;
import imobiliaria.gerenciador.GerenciadorPessoa;
import imobiliaria.model.Casa;
import imobiliaria.model.Imovel;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Predio;
import imobiliaria.model.Terreno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class ControladorImoveis extends Controlador {
    
    private List<Terreno> terrenos;

    public ControladorImoveis(List<Terreno> terrenos) {
        this.terrenos = terrenos;
    }

    public List<Terreno> getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(List<Terreno> terrenos) {
        this.terrenos = terrenos;
    }
    
    public void adicionaTerreno(String endereco, String estado, 
            float iptu, float preco, Pessoa pessoa) {
        GerenciadorImovel.adicionaTerreno(endereco, estado, iptu, preco, pessoa);
    }
    
    public void adicionaCasa(String endereco, String estado, float iptu, float preco, Pessoa pessoa, String area){
        GerenciadorImovel.adicionaCasa(endereco, estado, iptu, preco, pessoa, area);
    }
    
    public void adicionaPredio(String endereco, String estado, float iptu, float preco, Pessoa pessoa, String area, float condominio){
        GerenciadorImovel.adicionaPredio(endereco, estado, iptu, preco, pessoa, area, condominio);
    }
    

    public Terreno buscaImovel(int id) {
        return GerenciadorImovel.buscaImovelPorId(id);
    }

    public boolean removeImovel(Terreno imovel) {
        return GerenciadorImovel.remove(imovel);
    }
    
    public Pessoa buscaProprietario(String CPF){
        return GerenciadorPessoa.buscaPessoaPorCPF(CPF);
    }

    public void editaTerreno(Terreno imovel, String endereco, String estado, float iptu, float preco, Pessoa proprietario) {
        imovel.setEndereco(endereco);
        imovel.setEstado(estado);
        imovel.setIptu(iptu);
        imovel.setPreco(preco);
        imovel.setProprietario(proprietario);
    }

    public void editaCasa(Casa casa, String endereco, String estado, float iptu, float preco, Pessoa proprietario, String area) {
        editaTerreno(casa, endereco, estado, iptu, preco, proprietario);
        casa.setArea(area);
    }
    
    public void editaPredio(Predio predio, String endereco, String estado, float iptu, float preco, Pessoa proprietario, String area, float condominio) {
        editaCasa(predio, endereco, estado, iptu, preco, proprietario, area);
        predio.setValorCondominio(condominio);
    }

    public List<Terreno> buscarImoveisDisponiveis() {
        List<Terreno> disponiveis = new ArrayList<>();
        for (int i = 0; i < terrenos.size(); i++) {
            Terreno imovel = terrenos.get(i);
            if(imovel.getEstado().equals(Imovel.ESTADO_LOCACAO)){
                if(GerenciadorAluguel.buscaAluguelPorImovel(imovel) == null){
                    disponiveis.add(imovel);
                }
            }
        }
        return disponiveis;
              
    }

    public List<Terreno> buscaPorPreco(float min, float max) {
        List<Terreno> resultado = new ArrayList<>();
        for (int i = 0; i < terrenos.size(); i++) {
            Terreno imovel = terrenos.get(i);
            if(imovel.getPreco() >= min && imovel.getPreco() <= max){
                resultado.add(imovel);
            }
        }
        return resultado;
    }
    
    
    
}
