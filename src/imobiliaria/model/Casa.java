/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.model;

/**
 *
 * @author alan.jbssa
 */
public class Casa extends Terreno {
    
    protected String area;

    @Override
    public String getTipo() {
        return "Casa";
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
