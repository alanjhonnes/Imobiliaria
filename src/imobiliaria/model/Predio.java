/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.model;

/**
 *
 * @author alan.jbssa
 */
public class Predio extends Casa {
    
    private float valorCondominio;

    @Override
    public String getTipo() {
        return "Prédio";
    }

    public float getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }
    
}
