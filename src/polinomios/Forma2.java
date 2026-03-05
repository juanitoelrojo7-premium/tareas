package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Forma2 {

    //Atributos
    private int Du, VPF2[];

    //metodos
    public Forma2(int Terminos) {
        this.Du = Terminos * 2;
        this.VPF2 = new int[Du + 1];
        VPF2[0] = Terminos;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }

    public int getVPF2(int i) {
        return VPF2[i];
    }

    public void setVPF2(int d, int i) {
        this.VPF2[i] = d;
    }

    //1. Insertar termino YA
    //2. Eliminar termino YA
    //3. Mostrar
    //4. Reconstruir - ajustar
    //5. Evaluar
    //6. Sumar
    //7. Multiplicar
    //Llenar el polinomio YA
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void LlenarPoli(String Vs[]) {

        // Contar datos validos
        int contador = 0;
        for (int i = 0; i < Vs.length; i++) {
            if (Vs[i] != null) {
                contador++;
            }
        }

        int n = contador / 2; // numero de terminos reales

        int coef[] = new int[n];
        int expo[] = new int[n];

        // Separar coeficientes y exponentes
        int j = 0;
        for (int i = 0; i < contador; i += 2) {
            coef[j] = Integer.parseInt(Vs[i]);
            expo[j] = Integer.parseInt(Vs[i + 1]);
            j++;
        }

        // Ordenar de mayor a menor por exponente
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

        // Crear VPF2 SOLO con terminos reales
        VPF2 = new int[n * 2 + 1];

        VPF2[0] = n; // numero de terminos reales

        int pos = 1;

        for (int i = 0; i < n; i++) {
            VPF2[pos] = coef[i];
            VPF2[pos + 1] = expo[i];
            pos += 2;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public String insertar() {

        if (VPF2 == null) {
            return "Polinomio no creado";
        }

        int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coeficiente"));
        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));

        if (e < 0) {
            JOptionPane.showMessageDialog(null, "Exponente no puede ser negativo");
            return "No insertado";
        }

        int n = VPF2[0];

        // Si el exponente ya existe solo suma el coeficiente
        for (int i = 1; i < VPF2.length; i += 2) {
            if (VPF2[i + 1] == e) {
                VPF2[i] += c;
                return "Ha sido insertado de manera exitosa";
            }
        }

        // Si no existe crear nuevo vector
        int nuevo[] = new int[VPF2.length + 2];
        nuevo[0] = n + 1;

        int j = 1;
        boolean insertado = false;

        for (int i = 1; i < VPF2.length; i += 2) {

            if (!insertado && e > VPF2[i + 1]) {
                nuevo[j] = c;
                nuevo[j + 1] = e;
                j += 2;
                insertado = true;
            }

            nuevo[j] = VPF2[i];
            nuevo[j + 1] = VPF2[i + 1];
            j += 2;
        }

        if (!insertado) {
            nuevo[j] = c;
            nuevo[j + 1] = e;
        }

        VPF2 = nuevo;

        return "Ha sido insertado de manera exitosa";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void F2Eliminar() {

        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar"));

        int cantidad = VPF2[0];
        boolean encontrado = false;

        // Nuevo arreglo con un termino menos 
        int nuevo[] = new int[VPF2.length - 2];

        int j = 1;
        nuevo[0] = cantidad - 1;

        for (int i = 1; i < VPF2.length; i += 2) {

            if (VPF2[i + 1] == e) {
                encontrado = true; // saltamos este termino (no lo copiamos)
            } else {
                nuevo[j] = VPF2[i];       // coeficiente
                nuevo[j + 1] = VPF2[i + 1]; // exponente
                j += 2;
            }
        }

        if (encontrado) {
            VPF2 = nuevo;
            JOptionPane.showMessageDialog(null, "Exponente eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Exponente no existe");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void MostrarVPF2() { // este lo hice para probar si llenar poli funcionaba Adelanto: si funciona :3

        if (VPF2 == null) {
            System.out.println("El polinomio no ha sido creado.");
            return;
        }

        System.out.println(" vector VPF2: ");

        String mensaje = " ";
        for (int i = 0; i < VPF2.length; i++) {
            System.out.print(VPF2[i] + " "); // para consola
            mensaje += "|" + VPF2[i] + "|"; // para pantalla

        }
        JOptionPane.showMessageDialog(null, mensaje);

        System.out.println(); // salto de linea
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void reconstruir() {
        String poli = "";
        int n=VPF2[0];
        int posi=1;
        for (int i = 0; i < n; i++) {
            int coe = VPF2[posi];
            int exponente = VPF2[posi+1];

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
            posi+=2;

        }

        JOptionPane.showMessageDialog(null, "Polinomio: " + poli);
    }

    public void Evaluar() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero a remplazar x"));
        int resultado = 0;

        for (int i = 1; i < VPF2.length; i += 2) {
            int coe = VPF2[i];
            int exp = VPF2[i + 1];
            resultado += coe * Math.pow(x, exp);

        }

        JOptionPane.showMessageDialog(null, "El resultado del polinomio con " + x + " como valor, es: " + resultado);

    }

    public void F2Sumar(int VPF2B[]) {

        if (VPF2 == null || VPF2B == null) {
            JOptionPane.showMessageDialog(null, "Uno de los polinomios no existe");
            return;
        }

        int max = VPF2.length + VPF2B.length;
        int aux[] = new int[max];

        int k = 1; // posicion para llenar resultado

        for (int i = 1; i < VPF2.length; i += 2) {

            int coe1 = VPF2[i];
            int exp1 = VPF2[i + 1];
            int suma = coe1;

            for (int j = 1; j < VPF2B.length; j += 2) {

                int coe2 = VPF2B[j];
                int exp2 = VPF2B[j + 1];

                if (exp1 == exp2) {
                    suma += coe2;
                    VPF2B[j] = 0; // marcar como usado
                    break;
                }
            }

            if (suma != 0) {
                aux[k] = suma;
                aux[k + 1] = exp1;
                k += 2;
            }
        }

        // agregar los que no se usaron del segundo polinomio
        for (int j = 1; j < VPF2B.length; j += 2) {

            if (VPF2B[j] != 0) {
                aux[k] = VPF2B[j];
                aux[k + 1] = VPF2B[j + 1];
                k += 2;
            }
        }

        int resultado[] = new int[k];
        resultado[0] = (k - 1) / 2;

        for (int i = 1; i < k; i++) {
            resultado[i] = aux[i];
        }

        VPF2 = resultado;

        JOptionPane.showMessageDialog(null, "Suma realizada correctamente");
    }

    public void F2Multiplicar() {

    }

    //metodos para la entrega del proyecto, construir, mostrar, eliminar........
}
