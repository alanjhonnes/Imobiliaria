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

    public static void inicializa(List<Venda> modelo) {
        vendas = modelo;
    }

  public static Venda buscaImovelPorEndereco(String endereco) {
        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            if (venda.getEndereco().equals(endereco)) {
                return venda;
            }
        }
        return null;
    }

    public static void adicionaInteressado(Venda venda) {
        vendas.add(venda);

    }

    public static void removeVenda(Venda venda) {
        vendas.remove(venda);
    }
}
