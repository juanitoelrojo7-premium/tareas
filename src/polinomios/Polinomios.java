/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Jose Restrepo, Santiago Andres Barrera, Samuel Sosa;
 */
public class Polinomios {

    //8x^2-3x^5+2x-10
    public static void main(String[] args) {
        int opc = 0;
        Forma1 F1;

        String Vs[] = CrearPoli();
        F1 = new Forma1(Integer.parseInt(Vs[1]));
        do {
            opc = Menu();
            switch (opc) {
                case 1:
                  
                    break;
                case 2:
                      //insertar coe y exp
                    
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR");
            }
        }while(opc!=0);
    }
    public static int Menu() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("**** Menu principal\n" +
        "1.Insertar termino\n"+
        "2.Eliminar termino\n"+
        "3.reconstruir\n"+
        "4.Evaluar\n"+
        "5.Sumar\n"+
        "6.Multiplicar\n"+
        "0.salir\n"+
        " "));
        return opc;
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

}
