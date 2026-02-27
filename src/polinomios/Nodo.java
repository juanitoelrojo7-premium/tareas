/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

/**
 *
 * @author user
 */
public class Nodo {
    //Atributos
    private int coe, Exp;
    private Nodo Liga;
    
    
    //Metodos
    
    public Nodo(int coe, int Exp){
        
        this.coe= coe;
        this.Exp= Exp;
        this.Liga=null;
        
    }

    public int getCoe() {
        return coe;
    }

    public void setCoe(int coe) {
        this.coe = coe;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }
    
}
