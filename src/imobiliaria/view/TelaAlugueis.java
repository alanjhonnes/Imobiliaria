/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorAlugueis;
import imobiliaria.model.Aluguel;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class TelaAlugueis extends Tela {
    
    private ControladorAlugueis controlador;
    private List<Aluguel> alugueis;

    public TelaAlugueis(ControladorAlugueis controlador, List<Aluguel> alugueis) {
        super(controlador);
        this.alugueis = alugueis;
    }

    @Override
    public void mostra() {
        
    }

    @Override
    public ControladorAlugueis getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorAlugueis) controlador;
    }
    
}
