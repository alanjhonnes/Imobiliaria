/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;

/**
 *
 * @author alan.jbssa
 */
public abstract class Tela {
    
    public abstract void mostra();

    public Tela(Controlador controlador) {
        setControlador(controlador);
        controlador.setTela(this);
    }
    
    public void sair(){
        
    }

    public abstract Controlador getControlador();
    
    public abstract void setControlador(Controlador controlador);
    
    
    
}
