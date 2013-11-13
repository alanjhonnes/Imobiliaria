/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria;

import imobiliaria.controller.ControladorAlugueis;
import imobiliaria.controller.ControladorImoveis;
import imobiliaria.controller.ControladorNavegacao;
import imobiliaria.controller.ControladorPessoas;
import imobiliaria.controller.ControladorVendas;
import imobiliaria.view.TelaNavegacao;
import imobiliaria.model.Imobiliaria;
import imobiliaria.view.TelaAlugueis;
import imobiliaria.view.TelaImoveis;
import imobiliaria.view.TelaPessoas;
import imobiliaria.view.TelaVendas;

/**
 *
 * @author alan.jbssa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static Imobiliaria modelo;
    
    public static void main(String[] args) {
        modelo = new Imobiliaria();
        iniciaTelas();
        Navegacao.mostraTela(Navegacao.TELA_NAVEGACAO);
    }

    private static void iniciaTelas() {
        Navegacao.inicializa();
        Navegacao.adicionaTela(Navegacao.TELA_NAVEGACAO, 
                new TelaNavegacao(new ControladorNavegacao()));
        Navegacao.adicionaTela(Navegacao.TELA_IMOVEIS, 
                new TelaImoveis(new ControladorImoveis(modelo.getImoveis()), modelo.getImoveis()));
        Navegacao.adicionaTela(Navegacao.TELA_ALUGUEIS, 
                new TelaAlugueis(new ControladorAlugueis(modelo.getAlugueis()), modelo.getAlugueis()));
        Navegacao.adicionaTela(Navegacao.TELA_PESSOAS, 
                new TelaPessoas(new ControladorPessoas(modelo.getPessoas()), modelo.getPessoas()));
        Navegacao.adicionaTela(Navegacao.TELA_VENDAS, 
                new TelaVendas(new ControladorVendas(modelo.getVendas()), modelo.getVendas()));
    
    }
}
