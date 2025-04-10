/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservas;
import javax.swing.JOptionPane;
/**
 *
 * @author genes
 */
public class Hotel {
     // Matrices 3x3 para el hotel, para que sea más sencillo
    private Habitacion[][] habitaciones = new Habitacion[3][3];

    public Hotel() {
        precargar();
    }

    // Precarga de habitaciones
    private void precargar() {
        int habitacionNum = 301;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                String numero = Integer.toString(habitacionNum); //Guarda número de habitación
                String estado = "Libre"; //Todas van libres, como si el hotel estuviera abriendo, y vayan guardando todo

                // Usamos if-else en vez de ternario, o sea el símbolo ? porque no lo vimos en clase
                //el j%2 es para que si j es par la habitación será simple, si j es impar será doble
                //ya que % es residuo de una división
                //"El precio base es $50, y le sumamos 5 multiplicado por el número de la habitación (j)."
                String tipo;
                if (j % 2 == 0) {
                    tipo = "Simple";
                } else {
                    tipo = "Doble";
                }

                int precio = 50 + (j * 5);
                habitaciones[i][j] = new Habitacion(numero, estado, tipo, precio);
                habitacionNum++;
            }
            habitacionNum -= 10;
        }
    }

    // Modificación de habitaciones usando JOptionPane
    public void modificarHabitacion() {
        int piso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de piso (1-3):")) - 1;
        int hab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación (1-3):")) - 1;

        if (piso >= 0 && piso < 3 && hab >= 0 && hab < 3) {
            Habitacion h = habitaciones[piso][hab];

            // Mostrar datos actuales
            String mensaje = "Habitación " + h.getNumero()
                    + "\nEstado actual: " + h.getEstado()
                    + "\nTipo actual: " + h.getTipo()
                    + "\nPrecio actual: $" + h.getPrecio();
            JOptionPane.showMessageDialog(null, mensaje);

            // Modificar estado (0 = sí). Esto lo usé en el examen pasado, el 0 equivale a sí y la verdad sirve mucho
            int cambiarEstado = JOptionPane.showConfirmDialog(null, "¿Deseas modificar el estado?", "Modificar", JOptionPane.YES_NO_OPTION);
            if (cambiarEstado == 0) {
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese nuevo estado (Libre / Ocupada / Sucia):");
                h.setEstado(nuevoEstado);
            }

            // Modificar tipo, uso el mismo truco de si la variable equivale a sí o no
            int cambiarTipo = JOptionPane.showConfirmDialog(null, "¿Deseas modificar el tipo?", "Modificar", JOptionPane.YES_NO_OPTION);
            if (cambiarTipo == 0) {
                String nuevoTipo = JOptionPane.showInputDialog("Ingrese nuevo tipo (Simple / Doble):");
                h.setTipo(nuevoTipo);
            }

            // Modificar precio, básicamente repetí el truco, esto se usa en el proyecto igual 
            int cambiarPrecio = JOptionPane.showConfirmDialog(null, "¿Deseas modificar el precio?", "Modificar", JOptionPane.YES_NO_OPTION);
            if (cambiarPrecio == 0) {
                int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo precio:"));
                h.setPrecio(nuevoPrecio);
            }

            JOptionPane.showMessageDialog(null, "¡Modificación completada!");
        } else {
            JOptionPane.showMessageDialog(null, "Piso o habitación inválidos.");
        }
    }

   
    //Para hacer los cálculos
    public void mostrarResumenFinal() {
        System.out.println("\n--- Estado final del hotel ---\n");
        int libres = 0;
        int ocupadas = 0;
        int sucias = 0;
        int ganancia = 0;
        int total = 0;

        for (int i = 2; i >= 0; i--) {
            System.out.println("Piso " + (i + 1));
            for (int j = 0; j < 3; j++) {
                Habitacion h = habitaciones[i][j];
                System.out.println("Habitación " + h.getNumero()
                        + " | Estado: " + h.getEstado()
                        + " | Tipo: " + h.getTipo()
                        + " | Precio: $" + h.getPrecio());

                // Contar estado y sumar ganancia si está ocupada
                //Ocupo comparar dos textos Strings
                total++;
                if (h.getEstado().compareToIgnoreCase("Libre") == 0) {
                    libres++;
                } else if (h.getEstado().compareToIgnoreCase("Ocupada") == 0) {
                    ocupadas++;
                    ganancia += h.getPrecio();
                } else if (h.getEstado().compareToIgnoreCase("Sucia") == 0) {
                    sucias++;
                }
            }
            System.out.println();
        }

        // Mini resumen final del hotel
        System.out.println("--- Resumen del hotel ---");
        System.out.println("Habitaciones libres: " + libres + " (" + (libres * 100 / total) + "%)");
        System.out.println("Habitaciones ocupadas: " + ocupadas + " (" + (ocupadas * 100 / total) + "%)");
        System.out.println("Habitaciones sucias: " + sucias + " (" + (sucias * 100 / total) + "%)");
        System.out.println("Ganancia total del hotel: $" + ganancia);
    }
}

