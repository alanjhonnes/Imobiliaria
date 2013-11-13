/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorPessoas;
import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class TelaPessoas extends Tela {
    
    private ControladorPessoas controlador;
    private List<Pessoa> pessoas;

    public TelaPessoas(ControladorPessoas controlador, List<Pessoa> pessoas) {
        super(controlador);
        this.pessoas = pessoas;
    }
    
    

    @Override
    public void mostra() {
        
        
        
    }

    @Override
    public ControladorPessoas getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorPessoas) controlador;
    }

   
    
}
