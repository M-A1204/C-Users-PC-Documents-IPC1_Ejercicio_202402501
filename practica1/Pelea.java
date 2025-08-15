/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author PC
 */
public class Pelea {
    private String personaje1;
    private String personaje2;
    private String ganador;

    public Pelea(String personaje1, String personaje2, String ganador) {
        this.personaje1 = personaje1;
        this.personaje2 = personaje2;
        this.ganador = ganador;
    }

    public String getPersonaje1() {
        return personaje1;
    }

    public String getPersonaje2() {
        return personaje2;
    }

    public String getGanador() {
        return ganador;
    }

    public void mostrarPelea() {
        System.out.println(personaje1 + " vs " + personaje2 + " --> Ganador: " + ganador);
    }
}
