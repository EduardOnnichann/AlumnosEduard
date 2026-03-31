/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Alumno;
import java.util.Scanner;

/**
 *
 * @author EduardOnnichannn
 */
public class RegistrarAlumno {

    static Scanner sc = new Scanner(System.in);
    static String read;
    static String registro = "";

    final static String ruta = System.getProperty("user.dir");
    final static String rutaCarpeta = ruta + File.separator + "src" + File.separator + "registro";
    final static File registroCarpeta = new File(rutaCarpeta);
    final static File registroArchivo = new File(rutaCarpeta + File.separator + "registro.txt");

    static FileReader fr;
    static BufferedReader br;
    static FileWriter fw;
    static BufferedWriter bw;

    public static void start() {
        try {
            if (!registroCarpeta.exists()) {
                registroCarpeta.mkdir();
            }

            if (!registroArchivo.exists()) {
                registroArchivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el programa.");
        }
    }

    public static void addStudent() {
        System.out.println("Agregando un estudiante");
        System.out.println("");
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Apellido:");
        String apellido = sc.nextLine();
        System.out.println("Edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Curso:");
        String curso = sc.nextLine();
        System.out.println("DNI:");
        String dni = sc.nextLine();

        if (!checkDNI(dni)) {
            try {
                fw = new FileWriter(registroArchivo, true);
                bw = new BufferedWriter(fw);
                Alumno alumno = new Alumno(nombre, apellido, edad, curso, dni);
                bw.write(alumno.toString() + System.getProperty("line.separator"));
                bw.flush();
                bw.close();
            } catch (IOException E) {
                System.out.println("");
                System.err.println("Error al agregar un alumno en la base de datos.");
            }
        } else {
            System.out.println("");
            System.out.println("El alumno ya existe en la base de datos.");
        }
    }

    public static void showStudent() {
        try {
            fr = new FileReader(registroArchivo);
            br = new BufferedReader(fr);
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("");
            System.err.println("Error al intentar mostrar la lista de alumnos.");
        }
    }

    public static void removeStudent() {
        System.out.println("Lista de alumnos");
        showStudent();
        System.out.println("Introduzca el DNI del alumno:");
        String dni = sc.nextLine();
        if (checkDNI(dni)) {
            try {
                fr = new FileReader(registroArchivo);
                br = new BufferedReader(fr);
                while ((read = br.readLine()) != null) {
                    if (read.contains(dni)) {
                        System.out.println("");
                        System.out.println("Se ha eliminado el alumno de la base de datos.");
                    } else {
                        registro += read + System.getProperty("line.separator");
                    }
                }
                br.close();
            } catch (IOException e) {
                System.out.println("");
                System.err.println("Error al eliminar un alumno en la lista.");
            }

            try {
                fw = new FileWriter(registroArchivo);
                bw = new BufferedWriter(fw);
                if (registro != null) {
                    bw.write(registro);
                }
                registro = null;
                bw.flush();
                bw.close();
            } catch (IOException e) {
                System.err.println("Error al cargar la lista actualizada.");
            }
        } else {
            System.out.println("");
            System.out.println("El alumno no existe en la base de datos.");
        }
    }

    public static void findStudent() {
        System.out.println("Ingresar DNI del alumno:");
        System.out.println("");
        String dni = sc.nextLine();
        if (checkDNI(dni)) {
            try {
                fr = new FileReader(registroArchivo);
                br = new BufferedReader(fr);
                while ((read = br.readLine()) != null) {
                    if (read.contains(dni)) {
                        System.out.println(read);
                        br.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al buscar el alumno.");
            }

        } else {
            System.out.println("El alumno no existe en la base de datos.");
        }
    }

    public static boolean checkDNI(String dni) {
        try {
            fr = new FileReader(registroArchivo);
            br = new BufferedReader(fr);
            while ((read = br.readLine()) != null) {
                if (read.contains(dni)) {
                    //Si existe que devuelve true
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al realizar la verficacion del alumno");
            return false;
        }

        //Si no existe que devuelve false
        return false;
    }
}
