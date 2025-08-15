/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;
/**
 *
 * @author PC
 */
public class Personaje {
        
    // Atributos del personaje
    private int id;
    private String nombre;
    private String arma;
    private String[] habilidades;
    private int nivelPoder;
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Constructor
    public Personaje(int id, String nombre, String arma, String[] habilidades, int nivelPoder) {
        this.id = id;
        this.nombre = nombre;
        this.arma = arma;
        this.habilidades = habilidades;
        this.nivelPoder = nivelPoder;
    }
    public void setId(int id) {
    this.id = id;
    }
    public String getArma() {
    return arma;
}

public String[] getHabilidades() {
    return habilidades;
}
    // Método para mostrar todos los datos del personaje
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Arma: " + arma);
        System.out.println("Habilidades:");
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] != null && !habilidades[i].isEmpty()) {
                System.out.println("  - " + habilidades[i]);
            }
        }
        System.out.println("Nivel de Poder: " + nivelPoder);
    }

    // Métodos getters (para acceder a los atributos si se necesita)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }
}



