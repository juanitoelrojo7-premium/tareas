package polinomios;

import javax.swing.JOptionPane;

/**
 * @author Juan Jose Restrepo, Santiago Andres Barrera
 */
public class Polinomios {

    //8x^2-3x^5+2x-10
    public static int MenuPrincipal() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Principal-------\n"
                + "1. Insertar termino\n"
                + "2. Eliminar termino\n"
                + "3. Mostrar\n"
                + "4. Reconstruir\n"
                + "5. Evaluar\n"
                + "6. Sumar\n"
                + "7. Multiplicar\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuInsertar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Insertar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuEliminar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Eliminar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuMostrar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Mostrar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuReconstruir() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Reconstruir -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuEvaluar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Evaluar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

   public static int MenuSumar() {
    int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Sumar -------\n"
            + "1. Forma 1\n"
            + "2. Forma 2\n"
            + "3. Forma 3\n"
            + "4. F2 + F3 = F1\n"
            + "0. Salir\n"
            + " "));
    return opc;
}

    public static int MenuMultiplicar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Multiplicar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    // Contar Terminos
    public static int NumeroTerminos(String Vs[]) {
        int contador = 0;

        for (int i = 1; i < Vs.length; i += 2) {
            if (Vs[i] != null && !Vs[i].isEmpty()) {
                contador++;
            }

        }
        System.out.println(contador);
        return contador;
    }

    public static String[] CrearPoli() {

        String Cadena = JOptionPane.showInputDialog("Ingrese polinomio");
        char Vc[] = Cadena.toCharArray();
        String Vs[] = new String[Vc.length], s = "";
        int j = 0;

        for (int i = 0; i < Vc.length; i++) {
            System.out.print("|" + Vc[i] + "");

        }

        for (int i = 0; i < Vc.length; i++) {
            // si hay signos cuando s ya tiene algo:
            if ((Vc[i] == '-' || Vc[i] == '+') && s.isEmpty() == false) {
                Vs[j] = s;
                j++;
                Vs[j] = "0";
                j++;
                s = "";
            }

            if (Vc[i] == '-' || Character.isDigit(Vc[i])) {

                s = s + Vc[i];
            } else {
                if (Vc[i] == 'x') {
                    Vs[j] = s;
                    j++;
                    s = "";
                } else {
                    if (Vc[i] == '^') {
                        Vs[j] = Character.toString(Vc[i + 1]);
                        j++;
                        i++;
                    }
                }
            }
            if (i < Vc.length - 1) {
                if (Vc[i] == 'x' && (Vc[i + 1] == '-' || Vc[i + 1] == '+')) {
                    Vs[j] = "1";
                    j++;
                }
            }
            Vs[j] = s;
            Vs[j + 1] = "0";
        }
        System.out.println("\n");
        for (int i = 0; i < Vs.length; i++) {

            System.out.print("|" + Vs[i] + "|");
        }

        String coeficiente = " ";
        String exponente = " ";
        System.out.print("\n");
        // aqui codigo para ordenar vector //8x^2-3x^5+2x-10

        for (int i = 1; Vs[i] != null; i += 2) {          // i apunta a exponentes
            for (int k = i + 2; Vs[k] != null; k += 2) { // k compara exponentes

                if (Integer.parseInt(Vs[i]) < Integer.parseInt(Vs[k])) {  // ordenar de mayor a menor

                    coeficiente = Vs[i - 1];
                    exponente = Vs[i];
                    // Mover  directamente coeficiente y exponente
                    Vs[i - 1] = Vs[k - 1];
                    Vs[i] = Vs[k];

                    //mover el resto a la posicion anterior
                    Vs[k] = exponente;
                    Vs[k - 1] = coeficiente;

                }
            }
        }

        for (int i = 0; i < Vs.length; i++) {
            if ((Vc[i] == '-' || Vc[i] == '+') && s.isEmpty() == false) {
                Vs[j] = s;
                j++;
                Vs[j] = "0";
                j++;
                s = "";
            }
        }

        for (int n = 0; n < Vs.length; n++) {

            System.out.print("|" + Vs[n] + "|");
        }

        NumeroTerminos(Vs);

        return Vs;
    }

    public static void main(String[] args) {

        int opc = 0;
        Forma1 F1;
        Forma1 F1a;

        String Vs[] = CrearPoli();

        F1 = new Forma1(Integer.parseInt(Vs[1]));
        F1.LlenarPoli(Vs);

        Forma2 F2 = new Forma2(NumeroTerminos(Vs));
        F2.LlenarPoli(Vs);

        Forma3 F3 = new Forma3();
        F3.LlenarPoli(Vs);

        /////
        do {
            opc = MenuPrincipal();
            switch (opc) {
                case 1 -> {
                    int opcInsertar;
                    do {
                        opcInsertar = MenuInsertar();
                        switch (opcInsertar) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Insertar en Forma 1");
                                JOptionPane.showMessageDialog(null, F1.insertar());
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Insertar en Forma 2");
                                JOptionPane.showMessageDialog(null, F2.insertar());
                            }
                            
                            case 3 -> {
                                int c = Integer.parseInt(JOptionPane.showInputDialog("Coeficiente"));
                                int e = Integer.parseInt(JOptionPane.showInputDialog("Exponente"));

                                F3.insertar(c, e);
                            }
                            
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menu principal...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcInsertar != 0);
                }

                case 2 -> {
                    int opcEliminar;
                    do {
                        opcEliminar = MenuEliminar();
                        switch (opcEliminar) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Eliminar en Forma 1");
                                F1.eliminar(Vs);
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Eliminar en Forma 2");
                                F2.F2Eliminar();
                                F2.MostrarVPF2();
                            }
                            
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Eliminar en Forma 3");
                                F3.Eliminar();
                            }
                            
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcEliminar != 0);
                }

                case 3 -> {
                    int opcMostrar;
                    do {
                        opcMostrar = MenuMostrar();
                        switch (opcMostrar) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Mostrar en Forma 1");
                                F1.MostrarPolinomio();
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Mostrar en Forma 2");
                                F2.MostrarVPF2();
                            }
                            
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Mostrar en Forma 3");
                                F3.Mostrar();
                            }
                            
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcMostrar != 0);
                }

                case 4 -> {
                    int opcReconstruir;
                    do {
                        opcReconstruir = MenuReconstruir();
                        switch (opcReconstruir) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Reconstruir en Forma 1");
                                F1.reconstruir();
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Reconstruir en Forma 2");
                                F2.reconstruir();
                            }
                            
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Reconstruir en Forma 3");
                                F3.Reconstruir();
                            }
                            
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcReconstruir != 0);
                }

                case 5 -> {
                    int opcEvaluar;
                    do {
                        opcEvaluar = MenuEvaluar();
                        switch (opcEvaluar) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Evaluar en Forma 1");
                                F1.Evaluar();
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Evaluar en Forma 2");
                                F2.Evaluar();
                            }
                            
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Evaluar en Forma 3");
                                F3.Evaluar();
                            }
                            
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcEvaluar != 0);
                }

                case 6 -> {
                    int opcSumar;
                    do {
                        opcSumar = MenuSumar();
                        switch (opcSumar) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Sumar en Forma 1");
                                String Vs2[] = CrearPoli();
                                Forma1 F1c = new Forma1(Integer.parseInt(Vs2[1]));
                                F1c.LlenarPoli(Vs2);
                                Forma1 multi = F1.Sumar(F1c);
                                F1 = multi;
                                multi.MostrarPolinomio();
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Sumar en Forma 2");
                                String Vs3[] = CrearPoli();
                                Forma2 F2b = new Forma2(NumeroTerminos(Vs3));
                                F2b.LlenarPoli(Vs3);
                                F2.Sumar(F2b.getVPF2());
                                F2.MostrarVPF2();
                            }
                            
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Sumar en Forma 3");
                                String Vs4[] = CrearPoli();
                                Forma3 F3b = new Forma3();
                                F3b.LlenarPoli(Vs4);
                                F3.sumar(F3b);
                                F3.Mostrar();
                            }
                            case 4 -> {
                                JOptionPane.showMessageDialog(null, "Sumar F2 + F3 = F1");
                                Forma1 resultado = F1.sumarF2F3(F2, F3);
                                F1 = resultado; // para que apunte a la memoria y se actualice en forma 1
                                resultado.MostrarPolinomio();
                            }
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcSumar != 0);
                }

                case 7 -> {
                    int opcMultiplicar;
                    do {
                        opcMultiplicar = MenuMultiplicar();
                        switch (opcMultiplicar) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Multiplicar en Forma 1");
                                String Vs3[] = CrearPoli();
                                Forma1 F1c = new Forma1(Integer.parseInt(Vs3[1]));
                                F1c.LlenarPoli(Vs3);
                                Forma1 multi = F1.multiplicar(F1c);
                                F1 = multi;
                                multi.MostrarPolinomio();
                            }
                            
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Multiplicar en Forma 2");
                                String Vs4[] = CrearPoli();
                                Forma2 F2b = new Forma2(NumeroTerminos(Vs4));
                                F2b.LlenarPoli(Vs4);
                                F2.Multiplicar(F2b.getVPF2());
                                F2.MostrarVPF2();
                            }
                            
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Multiplicar en Forma 3");
                                String Vs5[] = CrearPoli();

                                Forma3 mult = new Forma3();
                                mult.LlenarPoli(Vs5);

                                Forma3 resultado = new Forma3();

                                F3.multiplicar(mult, resultado);
                                F3 = resultado;
                                F3.Mostrar();
                            }
                            
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo...");

                            default -> JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } while (opcMultiplicar != 0);
                }

                case 0 -> System.out.println("Salir.");

                default -> JOptionPane.showMessageDialog(null, "ERROR");
            }
        } while (opc != 0);

    }

}
/*    
                        => Codigo de juanjo
                        int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coeficiente"));
                        int e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
                     
                                 F1.insertar(c, e) ;

 */
