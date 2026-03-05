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
            return "error";
        } // se crea un nuevo vector mas grande para pasar los elementos
        int Grado = VPF1[0];
        if (e > Grado) {
            int nuevoGrado = e;
            int VPF1Nuevo[] = new int[nuevoGrado + 2];
            VPF1Nuevo[0] = nuevoGrado;
            for (int i = 1; i < VPF1.length; i++) {
                int expo = Grado - i;
                int posi = nuevoGrado - expo;
                VPF1Nuevo[posi] = VPF1[i];
            }
            VPF1 = VPF1Nuevo;
            Grado = nuevoGrado;
            Du = nuevoGrado + 1;
        }//si es menor al grado se inserta o suma normalmente
        int posi = (Grado - e) + 1;
        VPF1[posi] += c;
        return "Registro insertado ";
    }

    public void MostrarPolinomio() {

        String mensaje = " ";
        System.out.println("Vector Forma 1:");

        for (int i = 0; i < VPF1.length; i++) {
            mensaje += "|" + VPF1[i] + "|";

        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void eliminar(String Vs[]) {
        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar"));
        int grado = VPF1[0];
        //si el exponente entra en el rango
        if (e >= 0 && e < grado + 1) {
            int posi = grado - e + 1;
            if (VPF1[posi] != 0) {
                Vs[posi] = "0";
                VPF1[posi] = 0;
            }
            JOptionPane.showMessageDialog(null, "Exponente eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Exponente no existe");
        } //si el exponente a eliminar es igual al mayor grado
        if (e == grado) {
            int nuevoGrado = 0;
            int inicio = 0;

            for (int i = 1; i < VPF1.length; i++) {
                if (VPF1[i] != 0) {
                    nuevoGrado = grado - (i - 1);
                    inicio = i;
                    break;
                }

            }//cra un nuevo vector y pasa los elementos
            int VPF1Nuevo[] = new int[nuevoGrado + 2];
            VPF1Nuevo[0] = nuevoGrado;
            Du = nuevoGrado + 1;
            int j = 1;
            for (int i = inicio; i < VPF1.length; i++) {
                VPF1Nuevo[j] = VPF1[i];
                j++;
            }
            VPF1 = VPF1Nuevo;

        }
    }

    public void reconstruir() {
        String poli = "";
        int grado = VPF1[0];

        for (int i = 1; i < VPF1.length; i++) {
            int coe = VPF1[i];
            int exponente = grado - (i - 1);

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
        JOptionPane.showMessageDialog(null, "Polinomio: " + poli);
    }

    public void Evaluar() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero a remplazar x"));
        int resultado = 0;

        int grado = VPF1[0];
        for (int i = 1; i < VPF1.length; i++) {
            int coe = VPF1[i];
            int exp = grado - (i - 1);
            resultado += coe * Math.pow(x, exp);

        }

        JOptionPane.showMessageDialog(null, "El resultado del polinomio con " + x + "como valor, es: " + resultado);

    }

    public Forma1 Sumar(Forma1 F2) {
        int Grado1 = VPF1[0];
        int Grado2 = F2.VPF1[0];
        int Gradomax;

        if (Grado1 < Grado2) {
            Gradomax = Grado2;

        } else {
            Gradomax = Grado1;

        }
        Forma1 resultado = new Forma1(Gradomax);

        for (int i = 1; i < VPF1.length; i++) {
            int exp = Grado1 - (i - 1);
            int posi = Gradomax - exp + 1;
            resultado.getVPF1()[posi] += VPF1[i];

        }
        for (int j = 1; j < F2.getVPF1().length; j++) {
            int exp = Grado2 - (j - 1);
            int posi = Gradomax - exp + 1;
            resultado.getVPF1()[posi] += F2.getVPF1(j);

        }

        return resultado;

    }

    /* public void Sumar(String Vs[], String Vs2[]) {
        JOptionPane.showMessageDialog(null, "Suma de polinomios ");
        int num1, num2, suma = 0;

        for (int i = 1; i < Vs.length && Vs[i] != null; i += 2) {
            for (int k = 1; k < Vs2.length && Vs2[k] != null; k += 2) {
                num1 = Integer.parseInt(Vs[i]);
                num2 = Integer.parseInt(Vs2[k]);

                if (num1 == num2) {
                    suma = Integer.parseInt(Vs[i - 1]) + Integer.parseInt(Vs2[k - 1]);
                    Vs2[k - 1] = Integer.toString(suma);

                }

            }

        }

        JOptionPane.showMessageDialog(null, Vs2);
        
        for (int i = 0; i < Vs2.length && Vs2[i] != null; i+=2) {
        for(int k=1; k<Vs2.length+1 && Vs2[k] != null; k+=1 )
            VPF1[k] = Integer.parseInt(Vs2[i]);
            
        }
        MostrarPolinomio();
    }*/
    public Forma1 multiplicar(Forma1 F2) {
        int grado1 = VPF1[0];
        int grado2 = F2.getVPF1(0);
        int gradoMax = grado1 + grado2;

        Forma1 resultado = new Forma1(gradoMax);

        for (int i = 1; i < VPF1.length; i++) {
            for (int j = 1; j < F2.getVPF1().length; j++) {
                int coef = VPF1[i] * F2.getVPF1(j);
                int exp = grado1 - (i - 1) + grado2 - (j - 1);
                int posi = gradoMax - exp + 1;
                resultado.getVPF1()[posi] += coef;
            }
        }

        return resultado;
    }

}