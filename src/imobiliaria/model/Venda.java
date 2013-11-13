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
public class Venda {
    private Terreno imovel;
    private List<Pessoa> interessados;

    public Venda() {
        interessados = new ArrayList<>();
    }

    public Venda(Terreno imovel) {
        interessados = new ArrayList<>();
        this.imovel = imovel;
    }
    
    public void inseriInteressado(Pessoa pessoa){
        interessados.add(pessoa);
    }

    public Terreno getImovel() {
        return imovel;
    }

    public void setImovel(Terreno imovel) {
        this.imovel = imovel;
    }
    
}
