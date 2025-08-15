/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class Main {

    static Personaje[] personajes = new Personaje[100];
    static int contadorPersonajes = 0;
    static Pelea[] historialPeleas = new Pelea[100];
    static int contadorPeleas = 0;
    static Estudiante estudiante = new Estudiante("Manuel Angel Tíu Sanic", "202402501", "Ingeniería en Sistemas");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú de Gestión de Personajes ---");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Modificar personaje");
            System.out.println("3. Eliminar personaje");
            System.out.println("4. Ver datos de un personaje");
            System.out.println("5. Ver listado de personajes");
            System.out.println("6. Realizar peleas entre personajes");
            System.out.println("7. Ver historial de peleas");
            System.out.println("8. Ver datos de estudiante");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Verificar que haya espacio en el arreglo
                    if (contadorPersonajes < personajes.length) {
                    System.out.print("Ingrese el nombre del personaje: ");
                    String nombre = sc.nextLine().trim();

          // Validar que el nombre no esté vacío
                    if (nombre.isEmpty()) {
                       System.out.println("El nombre no puede estar vacío.");
                       break;
                    }

                    System.out.print("Ingrese el arma del personaje: ");
                    String arma = sc.nextLine().trim();

        // Pedir hasta 5 habilidades (pueden dejar vacío)
                    String[] habilidades = new String[5];
                    for (int i = 0; i < habilidades.length; i++) {
                        System.out.print("Ingrese habilidad " + (i + 1) + " (dejar vacío para terminar): ");
                        habilidades[i] = sc.nextLine().trim();
                    }

                    System.out.print("Ingrese el nivel de poder (1 a 100): ");
                    int nivelPoder = 0;
                    try {
                       nivelPoder = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Nivel de poder inválido. Debe ser un número entre 1 y 100.");
                        break;
                    }

        // Validar rango de nivel de poder
                    if (nivelPoder < 1 || nivelPoder > 100) {
                       System.out.println("Nivel de poder fuera de rango.");
                       break;
                    }

        // Crear el personaje y guardarlo en el arreglo
                    Personaje p = new Personaje(contadorPersonajes + 1, nombre, arma, habilidades, nivelPoder);
                    personajes[contadorPersonajes] = p;
                    contadorPersonajes++;

                    System.out.println("Personaje agregado con éxito.");
                } else {
                    System.out.println("No hay espacio para mas personajes");
                }
                break;
                case 2:
    // Aquí va el código para modificar personaje
                if (contadorPersonajes == 0) {
                System.out.println("No hay personajes para modificar.");
                break;
                }

                System.out.print("Ingrese el ID del personaje a modificar: ");
                int idModificar = Integer.parseInt(sc.nextLine());

                boolean encontrado = false;
                for (int i = 0; i < contadorPersonajes; i++) {
                if (personajes[i].getId() == idModificar) {
                encontrado = true;

               System.out.println("Modificando personaje: " + personajes[i].getNombre());

               System.out.print("Nuevo nombre (dejar vacío para no cambiar): ");
               String nuevoNombre = sc.nextLine().trim();
              if (!nuevoNombre.isEmpty()) {
                personajes[i].setNombre(nuevoNombre);
               }

            System.out.print("Nueva arma (dejar vacío para no cambiar): ");
            String nuevaArma = sc.nextLine().trim();
            if (!nuevaArma.isEmpty()) {
                personajes[i].setArma(nuevaArma);
            }

            System.out.println("Modificando habilidades (5 máximo):");
            String[] nuevasHabilidades = new String[5];
            for (int j = 0; j < nuevasHabilidades.length; j++) {
                System.out.print("Habilidad " + (j + 1) + " (dejar vacío para terminar): ");
                String hab = sc.nextLine().trim();
                if (hab.isEmpty()) {
                    break;
                }
                nuevasHabilidades[j] = hab;
            }
            personajes[i].setHabilidades(nuevasHabilidades);

            System.out.print("Nuevo nivel de poder (1 a 100, 0 para no cambiar): ");
            int nuevoNivelPoder = Integer.parseInt(sc.nextLine().trim());
            if (nuevoNivelPoder >= 1 && nuevoNivelPoder <= 100) {
                personajes[i].setNivelPoder(nuevoNivelPoder);
            }

            System.out.println("Personaje modificado con éxito.");
            break;
               }
            }
             if (!encontrado) {
             System.out.println("Personaje con ID " + idModificar + " no encontrado.");
            }
             break;
             case 3:
           if (contadorPersonajes == 0) {
           System.out.println("No hay personajes para eliminar.");
           break;
           }

          System.out.print("Ingrese el ID del personaje a eliminar: ");
           int idEliminar = Integer.parseInt(sc.nextLine());

            boolean eliminado = false;
            for (int i = 0; i < contadorPersonajes; i++) {
            if (personajes[i].getId() == idEliminar) {
            eliminado = true;
            // Desplazar personajes hacia la izquierda para eliminar el personaje
            for (int j = i; j < contadorPersonajes - 1; j++) {
                personajes[j] = personajes[j + 1];
                // Actualizar IDs para mantener el orden (opcional)
                personajes[j].setId(j + 1);
            }
            personajes[contadorPersonajes - 1] = null; // Eliminar último duplicado
            contadorPersonajes--;
            System.out.println("Personaje eliminado con éxito.");
            break;
            }
            }
               if (!eliminado) {
               System.out.println("Personaje con ID " + idEliminar + " no encontrado.");
            }
                break;
             case 4:
           if (contadorPersonajes == 0) {
               System.out.println("No hay personajes registrados.");
               break;
               }

             System.out.print("Ingrese el ID del personaje a ver: ");
            int idBuscar = Integer.parseInt(sc.nextLine());

            boolean encontrado4 = false;
            for (int i = 0; i < contadorPersonajes; i++) {
           if (personajes[i].getId() == idBuscar) {
            encontrado4 = true;
            System.out.println("--- Datos del personaje ---");
            System.out.println("ID: " + personajes[i].getId());
            System.out.println("Nombre: " + personajes[i].getNombre());
            System.out.println("Arma: " + personajes[i].getArma());
            System.out.println("Nivel de poder: " + personajes[i].getNivelPoder());

            System.out.println("Habilidades:");
            String[] habilidades = personajes[i].getHabilidades();
            for (int j = 0; j < habilidades.length; j++) {
                if (habilidades[j] != null && !habilidades[j].isEmpty()) {
                    System.out.println("- " + habilidades[j]);
                }
                }
                 break;
                }
                }
              if (!encontrado4) {
                System.out.println("Personaje con ID " + idBuscar + " no encontrado.");
               }
                 break;
             case 5:
               if (contadorPersonajes == 0) {
                System.out.println("No hay personajes registrados.");
                } else {
                System.out.println("--- Lista de personajes ---");
                for (int i = 0; i < contadorPersonajes; i++) {
                System.out.println("ID: " + personajes[i].getId() + " | Nombre: " + personajes[i].getNombre());
                }
                }
                 break;
                 case 6:
                 if (contadorPersonajes < 2) {
                System.out.println("Se necesitan al menos dos personajes para pelear.");
                 break;
                 }
                 System.out.print("pelea entre personajes ");
                 System.out.print("Ingrese el ID del primer personaje: ");
                 int id1 = Integer.parseInt(sc.nextLine());

                 System.out.print("Ingrese el ID del segundo personaje: ");
                int id2 = Integer.parseInt(sc.nextLine());

                if (id1 == id2) {
                 System.out.println("No puedes hacer pelear al mismo personaje consigo mismo.");
                 break;
                 }

                Personaje p1 = null;
                Personaje p2 = null;

               for (int i = 0; i < contadorPersonajes; i++) {
               if (personajes[i].getId() == id1) {
               p1 = personajes[i];
               
               } else if (personajes[i].getId() == id2) {
               p2 = personajes[i];
                }

               if (p1 == null || p2 == null) {
                System.out.println("Uno o ambos personajes no encontrados.");
                break;
               }
               }
               System.out.println("Pelea entre " + p1.getNombre() + " y " + p2.getNombre());

                if (p1.getNivelPoder() > p2.getNivelPoder()) {
                System.out.println("¡Gana " + p1.getNombre() + "!");
        // Aquí podrías guardar el resultado en historial (más adelante)
               } else if (p2.getNivelPoder() > p1.getNivelPoder()) {
                System.out.println("¡Gana " + p2.getNombre() + "!");
        // Guardar resultado en historial
               } else {
               System.out.println("¡Empate!");
        // Guardar resultado en historial
               }
                break;
                case 7:
                if (contadorPeleas == 0) {
                System.out.println("No hay peleas registradas aún.");
                } else {
                System.out.println("--- Historial de peleas ---");
                for (int i = 0; i < contadorPeleas; i++) {
                 historialPeleas[i].mostrarPelea();
                  }
                }
                 break;
                 case 8:
                 System.out.println("--- Datos del estudiante ---");
                 System.out.println("Nombre: " + estudiante.getNombre());
                 System.out.println("Matrícula: " + estudiante.getMatricula());
                 System.out.println("Carrera: " + estudiante.getCarrera());
                 break;
            case 9:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
                
            default:
                System.out.println("Opción no implementada aún");
            }
        }
        
    }
     public static boolean existePersonaje(String nombre) {
        for (int i = 0; i < contadorPersonajes; i++) {
            if (personajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
