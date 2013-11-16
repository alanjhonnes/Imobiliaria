/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gerenciador;

import imobiliaria.model.Aluguel;
import imobiliaria.model.Venda;
import java.util.List;

/**
 *
 * @author senac2012
 */
public class GerenciadorAluguel {
    private static List<Aluguel> aluguel;
    
    public static void inicializa(List<Aluguel> modelo){
        aluguel = modelo;
    }
}
