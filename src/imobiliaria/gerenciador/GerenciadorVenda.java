/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gerenciador;

import static imobiliaria.gerenciador.GerenciadorPessoa.pessoas;
import imobiliaria.model.Pessoa;
import imobiliaria.model.Terreno;
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

    public static void adicionaInteressado(Venda venda) {
        vendas.add(venda);

    }

    public static void removeVenda(Venda venda) {
        vendas.remove(venda);
    }

    public static Venda buscaVendaPorIdImovel(int id) {
        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            if(venda.getImovel().getId() == id){
                return venda;
            }
        }
        return null;
    }

    public static boolean adicionaInteressado(Venda venda, Pessoa interessado) {
        List<Pessoa> interessados = venda.getInteressados();
        if(!interessados.contains(interessado)){
            interessados.add(interessado);
            return true;
        }
        return false;
    }

    public static void adicionaVenda(Terreno imovel) {
        Venda venda = new Venda(imovel);
        vendas.add(venda);
    }
}
