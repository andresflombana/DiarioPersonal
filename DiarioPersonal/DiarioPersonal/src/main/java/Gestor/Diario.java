package Gestor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import mundo.Entrada;
/**
 *
 * @author Andrés Lombana - Carlos Quenan
 */
public class Diario {
    private ArrayList<Entrada>misEntradas; // Lista para almacenar las entradas del diario
    private Scanner lector; // Scanner para entrada de usuario
    
    /**
     * Constructor de la clase Diario.
     * Inicializa la lista de entradas y el Scanner.
    */
    public Diario() {
    misEntradas = new ArrayList<>();
    lector = new Scanner(System.in);
}
    /**
     * Método para mostrar el menú de opciones.
    */
        public void mostrarMenu(){
        boolean activo=true;
        do{
            System.out.println("_____ MENU DE OPCIONES _____\n"
            +"1.Agregar una historia\n"
            +"2.Consultar historia\n"
            +"3.Modificar una historia\n"
            +"4.Eliminar una historia\n"
            +"5.Terminar programa\n");
            
            // Leer la opción seleccionada por el usuario
            int opcion=lector.nextInt();
            switch(opcion){
              case 1:
                agregarEntrada();
              break;

              case 2: 
                consultarEntrada();
              break;

              case 3:
                modificarEntrada();
              break;

              case 4:
                eliminarEntrada();
              break;
              
              case 5:
                activo=false;
                System.out.println("Programa terminado");
              break;

              default:
                System.out.println("Opcion no valida, intentalo nuevamente");        
            }
        }while(activo);
    }
     /**
     * Método para agregar una nueva entrada al diario.
     */
            private void agregarEntrada() {
                lector.nextLine();
        //Obtener la descripción
        System.out.println("Ingrese la historia que quiere contar: ");
        String descripcion =lector.nextLine();
        System.out.println("===========================================");
        //Obtener el ultimo idEntrada ingresado
        int nuevoIdEntrada = 1;
        if (!misEntradas.isEmpty()) {
        Entrada ultimaEntrada = misEntradas.get(misEntradas.size() - 1);
        nuevoIdEntrada = ultimaEntrada.getIdEntrada() + 1;
        }
        //Obtener la fecha del sistema
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoFecha.format(fechaActual);
        // Crear una nueva entrada y agregarla a la lista
        Entrada nuevaEntrada = new Entrada(nuevoIdEntrada, fecha, descripcion);
        misEntradas.add(nuevaEntrada);

        System.out.println("La historia ha sido agregada con éxito!");
}
     /**
      * Método para consultar todas las entradas del diario.
     */
             private void consultarEntrada() {
                 
        if (misEntradas.isEmpty()) {
        System.out.println("No hay historia registradas en el diario.");
        return;
        }
        // Mostrar todas las entradas del diario
        for (Entrada entrada : misEntradas) {
        System.out.println("ID: " + entrada.getIdEntrada());
        System.out.println("Fecha: " + entrada.getFecha());
        System.out.println("Descripción: " + entrada.getDescripcion());
        System.out.println("-------------------");
         }
}
     /**
      * Método para modificar una entrada existente en el diario.
     */
             private void modificarEntrada() {
        if (misEntradas.isEmpty()) {
        System.out.println("No hay historia registrada en el diario.");
        return;
        }

        // Mostrar las entradas disponibles para modificar
        System.out.println("Historias registradas:");
        for (Entrada entrada : misEntradas) {
        System.out.println("ID: " + entrada.getIdEntrada());
        System.out.println("Fecha: " + entrada.getFecha());
        System.out.println("Descripción: " + entrada.getDescripcion());
        System.out.println("-------------------");
        }

        // Solicitar al usuario que seleccione la entrada a modificar
        System.out.println("Ingrese el ID de la historia que desea modificar:");
        int idEntradaModificar = lector.nextInt();

        // Buscar la entrada con el ID proporcionado por el usuario
        Entrada entradaModificar = null;
        for (Entrada entrada : misEntradas) {
        if (entrada.getIdEntrada() == idEntradaModificar) {
            entradaModificar = entrada;
            break;
         }
        }

        // Verificar si se encontró la entrada
        if (entradaModificar == null) {
        System.out.println("No se encontró ninguna historia con el ID proporcionado.");
        return;
        }

        // Solicitar al usuario la nueva descripción
        lector.nextLine();
        System.out.println("Ingrese la nueva historia:");
        String nuevaDescripcion = lector.nextLine();

        // Actualizar la descripción de la entrada seleccionada
        entradaModificar.setDescripcion(nuevaDescripcion);
        System.out.println("La historia ha sido modificada con éxito.");
}
     /**
      * Método para eliminar una entrada del diario.
        */
             private void eliminarEntrada() {
        if (misEntradas.isEmpty()) {
        System.out.println("No hay historia registrada en el diario.");
        return;
        }
        // Mostrar las entradas disponibles para eliminar
        System.out.println("Historias registradas:");
        for (Entrada entrada : misEntradas) {
        System.out.println("ID: " + entrada.getIdEntrada());
        System.out.println("Fecha: " + entrada.getFecha());
        System.out.println("Descripción: " + entrada.getDescripcion());
        System.out.println("-------------------");
        }
        // Solicitar al usuario que seleccione la entrada a eliminar
        System.out.println("Ingrese el ID de la entrada que desea eliminar:");
        int idEntradaEliminar = lector.nextInt();
        // Buscar la entrada con el ID proporcionado por el usuario
        Entrada entradaEliminar = null;
        for (Entrada entrada : misEntradas) {
        if (entrada.getIdEntrada() == idEntradaEliminar) {
            entradaEliminar = entrada;
            break;
         }
        }
        // Confirmar la eliminación de la entrada
        System.out.println("¿Está seguro de eliminar esta historia? (S/N)");
        String confirmacion = lector.next().toUpperCase();
        if (confirmacion.equals("S")) {
        misEntradas.remove(entradaEliminar);
        System.out.println("La historia ha sido eliminada correctamente.");
        } else if (confirmacion.equals("N")) {
        System.out.println("Operación cancelada. La historia no fue eliminada.");
        } else {
        System.out.println("Opción no válida. Operación cancelada.");
         }
}
     /**
      * Método principal para ejecutar el programa.
     */               
    public static void main(String[] args) {
        Diario diario = new Diario();
     // Mostrar el menú principal
        diario.mostrarMenu();
    }

}