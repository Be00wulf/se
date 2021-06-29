package serpientesesc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Presentacion{

    //variables
    private String nivelDificultad;
    private Object numeroJugadores;
    private Object numeroCasillas;
    
    //constructor
    public Presentacion(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("presentacion.png"));
        JLabel presentacion = new JLabel(imagen);
        presentacion.setSize(500, 500);
        presentacion.setVisible(true);
        Object seleccion = JOptionPane.showInputDialog(null,"MUNDO","MUNDO",
        JOptionPane.QUESTION_MESSAGE,imagen, 
        new Object[] { "UNICO", "Nivel avanzado" },"UNICO");
        while(seleccion == null){
            JOptionPane.showMessageDialog(null,"Por favor escoja una dificultad");
             seleccion = JOptionPane.showInputDialog(null,"Elija un dificultad","Selector de dificultad",
        JOptionPane.QUESTION_MESSAGE,imagen, 
        new Object[] { "Nivel facil", "Nivel avanzado" },"Nivel avanzado");
            
        }
        this.nivelDificultad= seleccion.toString();
    }
    
    //get set 
    public String getNivelDificultad() {
        return nivelDificultad;
    }
    public Object getNumeroCasillas() {
        return numeroCasillas;
    }
    public Object getNumeroJugadores() {
        return numeroJugadores;
    }    
    
    //meto2
    public void pedirDatosUsuario(){
        if (nivelDificultad.equals("UNICO"))
        {
             (this.numeroCasillas) = JOptionPane.showInputDialog(null, "CANTIDAD DE CASILLAS (DISPONIBILIDAD UNICA)",   ""
             + "Casillas",   JOptionPane.QUESTION_MESSAGE,null, 
            new Object[] {25,36, 49, 64 },25);

            while(numeroCasillas == null){
                JOptionPane.showMessageDialog(null,"Por favor escoja un numero de casillas");
                numeroCasillas = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de Casillas",  
                        "Casillas",   JOptionPane.QUESTION_MESSAGE,null, 
                new Object[] {25,36, 49, 64 },64);
            }
        } 
        
        if (nivelDificultad.equals("Nivel avanzado"))
        {
             numeroCasillas = JOptionPane.showInputDialog(null, "CANTIDAD DE CASILLAS",   
                     "Casillas",   JOptionPane.QUESTION_MESSAGE,null,
            new Object[] {81,100, 121},81);

            while(numeroCasillas == null){
                JOptionPane.showMessageDialog(null,"Por favor escoja un numero de casillas");
                numeroCasillas = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de Casillas",  
                        "Casillas",   JOptionPane.QUESTION_MESSAGE,null, 
                new Object[] {81,100, 121},81);
            }
        }
               
        numeroJugadores = JOptionPane.showInputDialog(null, "SELECCIONE LA CANTIDAD DE JUGADORES",   
                "Jugadores",   JOptionPane.QUESTION_MESSAGE,null,  
        new Object[] { "1", 2, 3,4,5,6 },   "");
        while(numeroJugadores == null){
            JOptionPane.showMessageDialog(null,"Por favor escoja un numero de jugadores");
            numeroJugadores = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de jugadores",   
                    "Jugadores",   JOptionPane.QUESTION_MESSAGE,null,  
            new Object[] { "contra computadora", 2, 3,4 },   "");
        }

        if (numeroJugadores.equals("1")){
            numeroJugadores = 1;
        }
    }
    
    
    
    
    
    
    
}