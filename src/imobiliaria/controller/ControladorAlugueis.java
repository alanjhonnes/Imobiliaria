/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.model.Aluguel;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class ControladorAlugueis extends Controlador{
    
    private List<Aluguel> alugueis;

    public ControladorAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
    
    

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
    
    
    
    
}
