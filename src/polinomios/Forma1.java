package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Sosa - Juan Jose Restrepo - Santiago Ayala //8x^2-3x^5+2x-10
 */
public class Forma1 {

    //atributos
    private int Du, VPF1[];
    //metodos

    //constructor
    public Forma1(int Grado) {
        Du = Grado + 1;
        VPF1 = new int[Du + 1];
        VPF1[0] = Grado;
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
    //1. Insertar termino
    //2. Eliminar termino
    //3. Mostrar
    //4. Reconstruir - ajustar
    //5. Evaluar
    //6. Sumar
    //7. Multiplicar
    //Llenar el polinomio
    public void LlenarPoli(String Vs[]) {
        // Contar datos validos
        int contador = 0;
        for (int i = 0; i < Vs.length; i++) {
            if (Vs[i] != null) { 
                contador++;
            }
        }

        int n = contador / 2;

        int coef[] = new int[n];
        int expo[] = new int[n];

        // Separar los coef de los exponentes
        int j = 0;
        for (int i = 0; i < contador; i += 2) {
            coef[j] = Integer.parseInt(Vs[i]);
            expo[j] = Integer.parseInt(Vs[i + 1]);
            j++;
        }

        // Ordenar de mayor a menor
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {

                if (expo[i] < expo[k]) {

                    int auxExp = expo[i];
                    expo[i] = expo[k];
                    expo[k] = auxExp;

                    int auxCoef = coef[i];
                    coef[i] = coef[k];
                    coef[k] = auxCoef;
                }
            }
        }

        // Exponente mayor
        int mayor = expo[0];

        // Ajustar grado del polinomio
        VPF1 = new int[mayor + 2];   // +1 para el grado en posición 0
        VPF1[0] = mayor;

        // Llenar VPF1 con expresiones faltantes
        for (int e = mayor; e >= 0; e--) {

            boolean encontrado = false;

            for (int i = 0; i < n; i++) {
                if (expo[i] == e) {
                    VPF1[mayor - e + 1] = coef[i];
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                VPF1[mayor - e + 1] = 0;
            }
        }
    }

    public String insertar() {
        int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coeficiente"));
        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));

        if (e < 0) {
            JOptionPane.showMessageDialog(null, "Exponente no puede ser negativo ");
        }
        int Grado = VPF1[0];
        if (e > Grado) {
            int nuevoGrado = e;
            int VPF1Nuevo[] = new int[nuevoGrado + 2];
            VPF1Nuevo[0] = nuevoGrado;
            for (int i = 1; i < VPF1.length; i++) {
                int expo = Grado - (i - 1);
                int posi = nuevoGrado - expo + 1;
                VPF1Nuevo[posi] = VPF1[i];
            }
            VPF1 = VPF1Nuevo;
            Grado = nuevoGrado;
            Du = nuevoGrado + 1;
        }
        int posi = Grado - e + 1;
        VPF1[posi] += c;
        return "Registro insertado ";
    }

    public void MostrarPolinomio() {

        String poli = "";
        int grado = VPF1[0];

        for (int i = 1; i < VPF1.length; i++) {
            int coe = VPF1[i];
            int exponente = grado - (i - 1);  // exponente realL

            if (coe != 0) {

                // Signo
                if (coe > 0 && !poli.equals("")) {
                    poli += "+";
                }

                // Casos especiales
                if (exponente == 0) { // término independiente
                    poli += coe;
                } else if (exponente == 1) { // exponente 1
                    if (coe == 1) {
                        poli += "x";
                    } else if (coe == -1) {
                        poli += "-x";
                    } else {
                        poli += coe + "x";
                    }
                } else { // exponentes mayores
                    if (coe == 1) {
                        poli += "x^" + exponente;
                    } else if (coe == -1) {
                        poli += "-x^" + exponente;
                    } else {
                        poli += coe + "x^" + exponente;
                    }
                }
            }
        }

        if (poli.equals("")) {
            poli = "0";
        }
        String mensaje = " ";
        System.out.println("Vector Forma 1:");

        for (int i = 0; i < VPF1.length; i++) {
            mensaje += "|" + VPF1[i] + "|";

        }
        System.out.println(mensaje);
        JOptionPane.showMessageDialog(null, "Polinomio: " + poli);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void eliminar(String Vs[]) {
        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar"));
        for (int i = 1;i<Vs.length ; i+=2) {
            int ExpAct = Integer.parseInt(Vs[i]);
             if(ExpAct == e){
                 Vs[i-1] = "0";
                 
                 
             }
             if(VPF1 != null &&  i - 1  < VPF1.length){
                 VPF1[i - 1] = 0;
             }
             JOptionPane.showMessageDialog(null, "Exponente eliminado");
        }
    }

    public void reconstruir() {
    
    }

    public void Evaluar() {

    }

    public void Sumar() {
        Polinomios.CrearPoli();

    }

    public void multiplicar() {
        Polinomios.CrearPoli();
    }
}
