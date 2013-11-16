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

    private static List<Aluguel> alugueis;

    public static void inicializa(List<Aluguel> modelo) {
        alugueis = modelo;
    }

    public static int geraIDAluguel() {
        if (alugueis.isEmpty()) {
            return 1;
        }
        return alugueis.get(alugueis.size() - 1).getId() + 1;
    }

    public static void remove(Aluguel aluguel) {
        alugueis.remove(aluguel);
    }

    public static Aluguel buscaAluguelPorId(int id) {
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            if(aluguel.getId() == id){
                return aluguel;
            }
        }
        return null;
    }

}
