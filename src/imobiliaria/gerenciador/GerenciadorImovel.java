/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gerenciador;

import static imobiliaria.gerenciador.GerenciadorPessoa.pessoas;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
import java.util.List;

/**
 *
 * @author senac2012
 */
public class GerenciadorImovel {
    public static List<Terreno> imoveis;
    
    public static void inicializa(List<Terreno> modelo){
        imoveis = modelo;
    }
    
    public static Terreno buscaImovelPorId(int id){
        for (int i = 0; i < imoveis.size(); i++) {
            Terreno terreno = imoveis.get(i);
            if(terreno.getId() == id) return terreno;
        }
        return null;
    } 
}
