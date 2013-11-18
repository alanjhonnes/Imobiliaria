/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan.jbssa
 */
public class Venda {

    private Terreno imovel;
    private List<Pessoa> interessados;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private int valor;

    public Venda() {
        interessados = new ArrayList<>();
    }

    public Venda(Terreno imovel) {
        interessados = new ArrayList<>();
        this.imovel = imovel;
    }

    public void inseriInteressado(Pessoa pessoa) {
        interessados.add(pessoa);
    }

    public Terreno getImovel() {
        return imovel;
    }

    public void setImovel(Terreno imovel) {
        this.imovel = imovel;
    }

    public List<Pessoa> getInteressados() {
        return interessados;
    }

    public void setInteressados(List<Pessoa> interessados) {
        this.interessados = interessados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
