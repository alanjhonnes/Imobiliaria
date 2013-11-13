/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.view;

import imobiliaria.controller.Controlador;
import imobiliaria.controller.ControladorVendas;
import imobiliaria.model.Venda;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class TelaVendas extends Tela{
    
    private ControladorVendas controlador;
    private List<Venda> vendas;

    public TelaVendas(ControladorVendas controlador, List<Venda> vendas) {
        super(controlador);
        this.vendas = vendas;
    }
    
    @Override
    public void mostra() {
        
    }

    @Override
    public ControladorVendas getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = (ControladorVendas) controlador; 
    }
    
}
