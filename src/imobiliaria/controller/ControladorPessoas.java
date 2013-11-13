/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controller;

import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class ControladorPessoas extends Controlador{
    
    private List<Pessoa> pessoas;

    public ControladorPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    
    
}
