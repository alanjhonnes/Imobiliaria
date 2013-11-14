/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gerenciador;

import imobiliaria.model.Pessoa;
import java.util.List;

/**
 *
 * @author senac2012
 */
public class GerenciadorPessoa {
    
    public static List<Pessoa> pessoas;
    
    public static void inicializa(List<Pessoa> modelo){
        pessoas = modelo;
    }
    
    public static Pessoa buscaPessoaPorCPF(String cpf){
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if(pessoa.getCPF().equals(cpf)) return pessoa;
        }
        return null;
    } 
    
}
