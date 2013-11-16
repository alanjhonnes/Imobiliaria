/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gerenciador;

import static imobiliaria.gerenciador.GerenciadorPessoa.pessoas;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Venda;
import java.util.List;

/**
 *
 * @author senac2012
 */
public class GerenciadorVenda {
    
    private static List<Venda> vendas;
    
    public static void inicializa(List<Venda> modelo){
        vendas = modelo;
    }
    
}
