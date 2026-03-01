package polinomios;

import javax.swing.JOptionPane;

/**
 * @author Juan Jose Restrepo, Santiago Andres Barrera, Samuel Sosa;
 */
public class Polinomios {

    //8x^2-3x^5+2x-10
    public static int Menu() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu principal -------\n"
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

    public static int MenuPrincipal() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Principal -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int NumeroTerminos(String Vs[]) {
        int contador = 0;
        return contador;
    }

    //METODO DE ARRIBA PERO CON LA IA
    public static int numeroTerminos(String Vs[]) {
        int contador = 2;

        for (int i = 1; i < Vs.length; i++) {
            if (Vs[i] != null && !Vs[i].isEmpty()) {
                contador++;
            }
        }
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
        //ordenar vector

        return Vs;
    }

    public static void OrganizarVector(String Vs[]) {
        int n = Integer.parseInt(Vs[0]);

        for (int i = 1; i < 2 * n - 1; i += 2) {
            for (int j = i + 2; j < 2 * n + 1; j += 2) {
                int exp1 = Integer.parseInt(Vs[i + 1]);
                int exp2 = Integer.parseInt(Vs[j + 1]);

                if (exp1 < exp2) {

                    String tempCoef = Vs[i];
                    Vs[i] = Vs[j];
                    Vs[j] = tempCoef;

                    String tempExp = Vs[i + 1];
                    Vs[i + 1] = Vs[j + 1];
                    Vs[j + 1] = tempExp;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(numeroTerminos(args));
        int opc = 0;
        Forma1 F1;

        String Vs[] = CrearPoli();

        F1 = new Forma1(Integer.parseInt(Vs[1]));
        Forma2 F2 = new Forma2(NumeroTerminos(Vs));
        Forma3 F3 = new Forma3();
        /////
        do {
            opc = MenuPrincipal();
            switch (opc) {
                case 1:
                       OrganizarVector(Vs);
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;

                case 0:
                    System.out.println("Salir.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "ERROR");
            }
        } while (opc != 0);

        System.out.println(numeroTerminos(args));
        System.out.println(numeroTerminos(args));

    }

}
