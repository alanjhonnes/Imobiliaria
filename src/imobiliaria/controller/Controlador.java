/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.view.Tela;

/**
 *
 * @author alan.jbssa
 */
public abstract class Controlador {
    
    public Tela tela;

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }
    
    
    
}
