/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

/**
 *
 * @author Samuel Sosa - Juan Jose Restrepo - Santiago Ayala
 */
public class Forma1 {
    //atributos
    private int Du,VPF1[];
    //metodos
    
    //constructor

    public Forma1(int Grado) {
        Du = Grado+1;
        VPF1 = new int[Du+1];
        VPF1[0]= Grado;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int du) {
        this.Du = du;
    }
    public int[] getVPF1() {
        return VPF1;
    }
 public void setVPF1(int[] VPF1) {
        this.VPF1 = VPF1;
    }
    public int getVPF1(int i) {
        return VPF1[i];
    }

    public void setVPF1(int d, int i) {
        this.VPF1[i] = d;
    }
    
    //Insertar el polinomio
    public void insertar (int c, int e){
        
    }
    //Llenar el polinomio
    public void LlenarPoli(String Vsc[]){
        int j=0, pos=0;
        
    }
    
    public void Sumar(){
        
    }
}
