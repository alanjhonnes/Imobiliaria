/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.model;

/**
 *
 * @author alan.jbssa
 */
public class Terreno {
    
    protected int id;
    protected float preco;
    protected String endereco;
    protected Data dataCadastro;
    protected float iptu;
    protected Pessoa proprietario;
    protected String estado;
    
    public static final String ESTADO_VENDA = "Venda";
    public static final String ESTADO_LOCACAO = "Locaçao";
    
    

    public Terreno() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Data getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Data dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public float getIptu() {
        return iptu;
    }

    public void setIptu(float iptu) {
        this.iptu = iptu;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return "Terreno";
    }
    
    
    
    
    
}
