package polinomios;

/**
 *
 * @author Samuel Sosa - Juan Jose Restrepo - Santiago Ayala
 * //8x^2-3x^5+2x-10
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
    
    //1. Insertar termino
    //2. Eliminar termino
    //3. Mostrar
    //4. Reconstruir
    //5. Evaluar
    //6. Sumar
    //7. Multiplicar
    
    //Llenar el polinomio
    public void LlenarPoli(String Vs[]){
         int j=0, coe=0, mayorExp=0, exp=0;
        
         for(int i=1; i<Vs.length; i+=2){
         exp = Integer.parseInt(Vs[i]);
         if(exp > mayorExp){
             mayorExp = exp;
         }
         VPF1 = new int [mayorExp + 1];
        }
        
         for(int i=0;  i<Vs.length ; i+=2){
             coe= Integer.parseInt(Vs[i]);
             exp= Integer.parseInt(Vs[i+1]);
             VPF1[exp] = coe;
         }
    }
    
   
    public void insertar (int c, int e){
        
    }
    
    public void eliminar(){
        
    }

    public void Sumar(){
        
    }
}
