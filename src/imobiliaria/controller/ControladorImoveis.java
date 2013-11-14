/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
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

    public void adicionaTerreno(int id, String endereco, String estado, 
            float iptu, float preco, Pessoa pessoa) {
        Terreno t = new Terreno();
        t.setId(id);
        t.setEndereco(endereco);
        t.setEstado(estado);
        t.setIptu(iptu);
        t.setPreco(preco);
        t.setProprietario(pessoa);
        
        terrenos.add(t);
    }
    
    /**
     * 
     * @param id
     * @return Verdadeiro se ID existe, false se não existe
     */
    public boolean verificaId(int id){
        for (int i = 0; i < terrenos.size(); i++) {
            Terreno terreno = terrenos.get(i);
            if(terreno.getId() == id) return true;
        }
        return false;
    }
    
    
    
}
