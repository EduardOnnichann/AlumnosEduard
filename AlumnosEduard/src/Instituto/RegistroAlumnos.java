/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;

import java.util.Scanner;

/**
 *
 * @author EduardOnnichannn
 */
public class RegistroAlumnos {

    /**
     * @param args the command line arguments
     * @return 
     */

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int opc;
        System.out.println("Menu Principal");
        System.out.println("");
        System.out.println("1. Agregar un nuevo alumno al registro.");
        System.out.println("2. Mostrar la lista de alumnos registrados.");
        System.out.println("3. Eliminar un alumno del registro.");
        System.out.println("4. Buscar un alumno por su DNI.");
        System.out.println("5. Salir");
        System.out.println("");

        System.out.print("Ingrese una opcion: ");
        System.out.println("");
        opc = scanner.nextInt();
        scanner.nextLine();
        return opc;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        RegistrarAlumno.start();
        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    RegistrarAlumno.addStudent();
                    break;

                case 2:
                    RegistrarAlumno.showStudent();
                    break;

                case 3:
                    RegistrarAlumno.removeStudent();
                    break;

                case 4:
                    RegistrarAlumno.findStudent();
                    break;

                case 5:
                    System.out.println("Exit, programa finalizado.");
                    break;

                default:
                    System.out.println("La opcion selecionada no existe.");
                    break;
            }
        } while (opc != 5);
    }
}
