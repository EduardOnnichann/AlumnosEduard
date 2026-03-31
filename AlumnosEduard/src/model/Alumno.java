/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author EduardOnnichannn
 */
public class Alumno {

    private String nombre;
    private String apellido;
    private int edad;
    private String curso;
    private String dni;

    public Alumno(String nombre, String apellido, int edad, String curso, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", curso=" + curso + ", dni=" + dni + '}';
    }

}
