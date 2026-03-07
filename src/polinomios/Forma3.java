package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Jose Rojo - Santiago Barrera
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

    public void LlenarPoli(String Vs[]) {

        int i = 0;

        while (i < Vs.length && Vs[i] != null) {

            int coe = Integer.parseInt(Vs[i]);
            int exp = Integer.parseInt(Vs[i + 1]);

            insertar(coe, exp);

            i += 2;
        }
    }

    public void insertar(int coe, int exp) {

        Nodo x = new Nodo(coe, exp);

        if (Punta == null || exp > Punta.getExp()) {
            x.setLiga(Punta);
            Punta = x;
            return;
        }

        Nodo p = Punta;
        Nodo ant = null;

        while (p != null && p.getExp() > exp) {
            ant = p;
            p = p.getLiga();
        }

        // si ya existe ese exponente
        if (p != null && p.getExp() == exp) {
            p.setCoe(p.getCoe() + coe);
            return;
        }

        x.setLiga(p);
        ant.setLiga(x);
    }

    public String Mostrar() {
        Nodo p = Punta;
        String salida = "";

        if (p == null) {
            JOptionPane.showMessageDialog(null, "El polinomio estÃ¡ vacio");
        }
        while (p != null) {
            salida = salida + "||" + p.getCoe() + "|" + p.getExp() + "||  " + " --> ";
            p = p.getLiga();
        }
       // JOptionPane.showMessageDialog(null, salida + "nulo :> " );
       return salida;
    }

    public void Eliminar() {

        int exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar"));

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "El polinomio esta vacio");
            return;
        }

        Nodo p = Punta;
        Nodo ant = null;

        while (p != null && p.getExp() != exp) {
            ant = p;
            p = p.getLiga();
        }

        if (p == null) {
            JOptionPane.showMessageDialog(null, "No existe ese exponente");
            return;
        }

        // si es el primer nodo
        if (ant == null) {
            Punta = Punta.getLiga();
        } else {
            ant.setLiga(p.getLiga());
        }

        JOptionPane.showMessageDialog(null, "Termino eliminado");
    }

    public void Evaluar() {

        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor de x"));

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "El polinomio esta vacio");
            return;
        }

        Nodo p = Punta;
        int resultado = 0;

        while (p != null) {

            int coe = p.getCoe();
            int exp = p.getExp();

            resultado += coe * Math.pow(x, exp);

            p = p.getLiga();
        }
         
        JOptionPane.showMessageDialog(null, "Resultado: "  + Mostrar()+"Resultado= "+ resultado);
        
    }

    public void Reconstruir() {

        Nodo p = Punta;
        String poli = "";

        while (p != null) {

            poli += p.getCoe() + "x^" + p.getExp();

            if (p.getLiga() != null) {
                poli += " + ";
            }

            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, poli);
        System.out.println(poli);
    }

    public void sumar(Forma3 otro) {
        Nodo p = otro.getPunta();

        while (p != null) {
            insertar(p.getCoe(), p.getExp());
            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, "Suma realizada correctamente");

    }

    public void multiplicar(Forma3 mult, Forma3 resultado) {
        Nodo p = this.getPunta();

        while (p != null) {
            Nodo q = mult.getPunta();
            while (q != null) {
                int mul = p.getCoe() * q.getCoe();
                int sum = p.getExp() + q.getExp();

                resultado.insertar(mul, sum);
                q = q.getLiga();
            }
            p = p.getLiga();

        }

        JOptionPane.showMessageDialog(null, "multiplicacion realizada correctamente");

    }

}
     
/*        Metodos que faltan- Juanjo hagalos :D
                + "6. Sumar\n"
                + "7. Multiplicar\n"
*/