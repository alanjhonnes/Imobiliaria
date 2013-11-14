/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import java.util.Scanner;

/**
 *
 * @author alan.jbssa
 */
public abstract class Tela {
    
    protected Scanner scan;
    protected String input;
    
    public abstract void mostra();
    

    public Tela(Controlador controlador) {
        scan = new Scanner(System.in);
        setControlador(controlador);
        controlador.setTela(this);
    }
    
    public void sair(){
        
    }

    public abstract Controlador getControlador();
    
    public abstract void setControlador(Controlador controlador);
    
    
    
}
