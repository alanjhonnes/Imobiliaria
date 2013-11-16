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
public class Aluguel {

    private List<Parcela> parcelas;
    private Terreno imovel;
    private Pessoa locatario;
    private Data dataInicio;
    private Data dataFinal;
    private float valor;
    private int duracaoContrato;

    public Aluguel() {
        parcelas = new ArrayList<>();
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public Terreno getImovel() {
        return imovel;
    }

    public void setImovel(Terreno imovel) {
        this.imovel = imovel;
    }

    public Pessoa getLocatario() {
        return locatario;
    }

    public void setLocatario(Pessoa locatario) {
        this.locatario = locatario;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Data dataFinal) {
        this.dataFinal = dataFinal;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getDuracaoContrato() {
        return duracaoContrato;
    }

    public void setDuracaoContrato(int duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
        for (int i = 0; i < duracaoContrato; i++) {
            Parcela p = new Parcela();
            p.setId(i);
            p.setValor(this.getValor());
            p.setDiaVencimento(15);
        }
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Aluguel aluguel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
