/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class Imobiliaria {
    private List<Terreno> imoveis;
    private List<Pessoa> pessoas;
    private List<Aluguel> alugueis;
    private List<Venda> vendas;

    public Imobiliaria() {
        imoveis = new ArrayList<>();
        pessoas = new ArrayList<>();
        alugueis = new ArrayList<>();
        vendas = new ArrayList<>();
        
        popula();
    }

    public List<Terreno> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Terreno> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    private void popula() {
        Pessoa p = new Pessoa();
        p.setCPF("98237189237");
        p.setDataNascimento(new Data(13, 3, 1990));
        p.setEmail("alanjhonnes@hotmail.com");
        p.setEndereco("Rua joaquim vilela 255");
        p.setNome("Alan");
        p.setTelefone("555555555");
        Terreno t = new Terreno();
        t.setDataCadastro(new Data(13, 10, 2013));
        t.setEndereco("Avenida eng. Steuvax 2522");
        t.setEstado(Imovel.ESTADO_LOCACAO);
        t.setId(1);
        t.setIptu(5323);
        t.setPreco(5456454);
        t.setProprietario(p);
        imoveis.add(t);
        
        populaAluguel();
    }
    
    private void populaAluguel() {
         Aluguel a = new Aluguel();
         Pessoa p = new Pessoa();
         p.setNome("Zueira Zuado");
         a.setLocatario(p);
         //a.setImovel();
         a.setDataInicio(new Data(02, 01, 2013));
         a.setDataFinal(new Data(02, 01, 2014));
         a.setDuracaoContrato(12);

     }
    
    
    
    
}
