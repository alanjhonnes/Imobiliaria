/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

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
    
    
    
}
