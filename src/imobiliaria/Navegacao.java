/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria;

import imobiliaria.view.Tela;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alan.jbssa
 */
public class Navegacao {
    
    public static final String TELA_NAVEGACAO = "navegacao";
    public static final String TELA_IMOVEIS = "imoveis";
    public static final String TELA_PESSOAS = "pessoas";
    public static final String TELA_ALUGUEIS = "alugueis";
    public static final String TELA_VENDAS = "vendas";
    
    private static Map<String, Tela> telas; 
    
    public static void inicializa(){
        telas = new HashMap<>();
    }
    
    public static void adicionaTela(String chave, Tela tela){
        telas.put(chave, tela);
    }
    
    public static void mostraTela(String nomeTela){
        Tela tela = telas.get(nomeTela);
        if(tela != null){
            tela.mostra();
        }
        
    }
}
