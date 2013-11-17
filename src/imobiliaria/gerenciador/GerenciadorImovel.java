/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gerenciador;

import static imobiliaria.gerenciador.GerenciadorPessoa.pessoas;
import imobiliaria.model.Aluguel;
import imobiliaria.model.Casa;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Predio;
import imobiliaria.model.Terreno;   
import java.util.List;

/**
 *
 * @author senac2012
 */
public class GerenciadorImovel {
    public static List<Terreno> imoveis;
    
    public static void inicializa(List<Terreno> modelo){
        imoveis = modelo;
    }
    
    /**
     * 
     * @return O ultimo id de imóvel mais 1, caso a lista de imoveis esteja vazia, retorna 1
     */
    public static int geraIDImovel(){
        if(imoveis.isEmpty()){
            return 1;
        }
        return imoveis.get(imoveis.size() -1).getId() + 1;
    }
    
    /**
     * 
     * @param id O Id do imóvel
     * @return O imovel encontrado, ou null se nao foi encontrado
     */ 
    public static Terreno buscaImovelPorId(int id){
        for (int i = 0; i < imoveis.size(); i++) {
            Terreno terreno = imoveis.get(i);
            if(terreno.getId() == id) return terreno;
        }
        return null;
    } 

    public static void adiciona(Terreno t) {
        imoveis.add(t);
    }

    public static boolean remove(Terreno imovel) {
        List<Aluguel> alugueis = GerenciadorAluguel.getAlugueis();
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            if(aluguel.getImovel() == imovel){
                return false;
            }
        }
        imoveis.remove(imovel);
        return true;
        
    }

    public static void adicionaTerreno(String endereco, String estado, float iptu, float preco, Pessoa pessoa) {
        Terreno terreno = new Terreno();
        terreno.setId(geraIDImovel());
        terreno.setEndereco(endereco);
        terreno.setEstado(estado);
        terreno.setIptu(iptu);
        terreno.setPreco(preco);
        terreno.setProprietario(pessoa);
        imoveis.add(terreno);
    }
    
    public static void adicionaCasa(String endereco, String estado, float iptu, float preco, Pessoa pessoa, String area) {
        Casa casa = new Casa();
        casa.setId(geraIDImovel());
        casa.setEndereco(endereco);
        casa.setEstado(estado);
        casa.setIptu(iptu);
        casa.setPreco(preco);
        casa.setProprietario(pessoa);
        casa.setArea(area);
        imoveis.add(casa);
    }
    
    public static void adicionaPredio(String endereco, String estado, float iptu, float preco, Pessoa pessoa, String area, float condominio) {
        Predio predio = new Predio();
        predio.setId(geraIDImovel());
        predio.setEndereco(endereco);
        predio.setEstado(estado);
        predio.setIptu(iptu);
        predio.setPreco(preco);
        predio.setProprietario(pessoa);
        predio.setArea(area);
        predio.setValorCondominio(condominio);
        imoveis.add(predio);
    }
}
