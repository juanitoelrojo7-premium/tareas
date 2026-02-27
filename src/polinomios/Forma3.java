
package polinomios;

/**
 *
 * @author Juan Jose Rojo - Samuel Sosa - Santiago Barrera
 */
public class Forma3 {
    
//atributos
    
private Nodo Punta;

//metodos 
    public Forma3() {
        this.Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    
public void insertarFinal(int coe, int Exp){
    Nodo p = Punta, x =new Nodo(coe, Exp);

    if(Punta== null){
        Punta= x;

    }else{

        while(p.getLiga()!= null){
        p = p.getLiga();
        }

        p.setLiga(x);
}

    

    }
    public void LlenarPoli(String Vs[]){
        int j = 0;
    }
}

