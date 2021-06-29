/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesesc;

public class Jugador {
    
    //atributos jugador
    private String nombre;//atributo para guardar el nombre de cada jugador
    private Object colorFicha;//atributo para guardar el color de ficha de cada jugador
    private int casillaActual;//la casilla donde esta cada jugador actualmente
    private int turnoPerdido;//atributo para guardar los turnos perdidos de un jugador
   
    
    //constructor que no recibe nada
    public Jugador(){
        this.casillaActual = 1;//los jugadores empiezan en la casilla 1
        this.turnoPerdido =0; //empiezan sin turno perdido
    }
    
    //métodos set (void) para obtener un valor de cada tipo
   //metodo get para obtener un valor
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getColorFicha() {
        return colorFicha;
    }

    public void setColorFicha(Object colorFicha) {
        this.colorFicha = colorFicha;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public int getTurnoPerdido() {
        return turnoPerdido;
    }

    public void setTurnoPerdido(int turnoPerdido) {
        this.turnoPerdido = turnoPerdido;
    }
    
}//cierra clase