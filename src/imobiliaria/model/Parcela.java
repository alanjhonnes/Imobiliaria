/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.model;

/**
 *
 * @author alan.jbssa
 */
public class Parcela {
    
    private int id;
    private float valor;
    private boolean paga = false;
    private int diaVencimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }
    
    
}
