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

        System.out.println("Vector Forma 1:");
        for (int i = 0; i < VPF1.length; i++) {
            System.out.print("|" + VPF1[i] + "|");
        }
        System.out.println();
    }

    public void insertar(int c, int e) {

        for (int i = 2; i <= Du; i += 2) {

            if (VPF1[i] == e) {
                VPF1[i - 1] += c;

            }
            if (VPF1[i] > e) {
                int[] Va = new int[Du + 3];
                for (int j = 2; j < i; j += 2) {
                    Va[j - 1] = c;
                    Va[j] = e;
                    Va[Du + 1] = VPF1[i - 1];
                    Va[Du + 2] = VPF1[i];

                }
            }
            //  if(VPF1[i]<e){
            //   int []Va=new int [Du+3];
            //  for (int j=2;j<=i;j+=2);

            //  }
        }

    }

    public void MostrarPolinomio() {

        String poli = "";

        for (int i = VPF1.length - 1; i >= 0; i--) {

            int coe = VPF1[i];

            if (coe != 0) {

                // Signo
                if (coe > 0 && !poli.equals("")) {
                    poli += "+";
                }

                // Casos especiales
                if (i == 0) { // término independiente
                    poli += coe;
                } else if (i == 1) { // exponente 1
                    if (coe == 1) {
                        poli += "x";
                    } else if (coe == -1) {
                        poli += "-x";
                    } else {
                        poli += coe + "x";
                    }
                } else { // exponentes mayores
                    if (coe == 1) {
                        poli += "x^" + i;
                    } else if (coe == -1) {
                        poli += "-x^" + i;
                    } else {
                        poli += coe + "x^" + i;
                    }
                }
            }
        }

        if (poli.equals("")) {
            poli = "0";
        }

        JOptionPane.showMessageDialog(null, "Polinomio: " + poli);
    }

    public void eliminar() {

    }

    public void Sumar() {

    }

}
