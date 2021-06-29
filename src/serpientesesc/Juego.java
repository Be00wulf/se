package serpientesesc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class Juego {
    
    public static void main(String[] args){
        Presentacion presentacion = new Presentacion();                 //no game no life
        System.out.println(presentacion.getNivelDificultad());
        presentacion.pedirDatosUsuario();
        Object numeroCasillas = presentacion.getNumeroCasillas();
        Object numeroJugadores = presentacion.getNumeroJugadores();
        Jugador []jugador;
 
        if ((int)numeroJugadores ==1)
           jugador = new Jugador[3];
        else
          jugador = new Jugador[(int)numeroJugadores+1];

        for(int cont = 1;cont<=(int)numeroJugadores;cont++){
            String nombre = JOptionPane.showInputDialog(null, "NOMBRE");
            String apellido = JOptionPane.showInputDialog(null, "APELLIDO");
            String id = JOptionPane.showInputDialog(null, "ID");
            while(nombre == null)
                nombre =JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador porfavor");
            
            Color colorFicha = JColorChooser.showDialog(null,"Select a Color", Color.RED);
            while (colorFicha == null)
                colorFicha = JColorChooser.showDialog(null,"Select a Color", Color.RED);
            
            jugador[cont] = new Jugador();
            jugador[cont].setNombre(nombre);
            jugador[cont].setColorFicha(colorFicha);  
        }

         if ((int)numeroJugadores ==1){
             numeroJugadores=2;
             jugador[2] = new Jugador();
             jugador[2].setNombre("Computadora");
             jugador[2].setColorFicha(Color.BLACK);          
        }   
        
        Casilla [] casilla1;                                //casillas
        casilla1 = new Casilla[(int)numeroCasillas+1];
      
        for (int cont = 1; cont<=(int)numeroCasillas;cont++){
            casilla1[cont] = new Casilla();
            casilla1[cont].setTipoCasilla("Simple"); 
        }

        Random aleatorio = new Random();
        for (int h = 1; h<=5;h++){
            int variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
            while(true){
                if (variable_aleatoria == 1|| variable_aleatoria ==(int)numeroCasillas){
                    variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                }
                break;
            }
            casilla1[variable_aleatoria].setTipoCasilla("Pierde Turno");
        }
        
        //solo cantidad de casillas
        if (presentacion.getNivelDificultad().equals("Nivel avanzado")){
        for (int a=1;a<=5;a++){
            int variable_aleatoria = aleatorio.nextInt((int)numeroCasillas)+1;
            while(true)
            {   
                if(variable_aleatoria==1||variable_aleatoria==(int)numeroCasillas)
                {
                    variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                }
                break;
            }
            casilla1[variable_aleatoria].setTipoCasilla("Tira de Nuevo");
        }
        
            for (int i =1;i<=5;i++){
                int variable_aleatoria=aleatorio.nextInt((int)numeroCasillas)+1;
                while(true)
                {   
                    if(variable_aleatoria==1||variable_aleatoria==(int)numeroCasillas)
                    {
                        variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
                        continue;
                    }
                    break;
                }
                casilla1[variable_aleatoria].setTipoCasilla("Cambia Tablero");     
            }
        }

        //escalera
        int variable_avanza;
        for (int k = 1;k<=5;k++){
            int variable_aleatoria2 = aleatorio.nextInt((int)(numeroCasillas))+1;
            do {
                    variable_avanza = aleatorio.nextInt(20)+1;
                    if (( variable_aleatoria2 + variable_avanza ) >= (int) numeroCasillas){
                        variable_aleatoria2 = aleatorio.nextInt((int)(numeroCasillas))+1;
                        continue;
                    }
                    if (variable_aleatoria2 == 1){
                        variable_aleatoria2 = aleatorio.nextInt((int)(numeroCasillas))+1;
                        continue;
                    }
                    if((variable_aleatoria2)== (int)numeroCasillas){
                        variable_aleatoria2 = aleatorio.nextInt((int)numeroCasillas)+1;
                        continue;
                    }
                    if (variable_avanza <= Math.sqrt((int)numeroCasillas)){
                        continue;
                    }
                    break;
            } while ( true ) ;
            casilla1[variable_aleatoria2].setTipoCasilla("Escalera");
            casilla1[variable_aleatoria2].setMovimientoN(variable_avanza);
           
             
        }
        
        //serpiente
        for (int l = 1;l<=5;l++){
            int variable_aleatoria3 = aleatorio.nextInt((int)(numeroCasillas))+1;
            do{ 
                variable_avanza = aleatorio.nextInt(20)+1;
                variable_avanza= -variable_avanza;
                if ((variable_avanza+variable_aleatoria3)<=1){
                    variable_aleatoria3 = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                }    
                if (casilla1[variable_avanza+variable_aleatoria3].getTipoCasilla().equals("Escalera")){
                    variable_aleatoria3 = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                }

                if (-variable_avanza <= Math.sqrt((int)numeroCasillas))
                    continue;
               
                if (variable_aleatoria3 == (int)numeroCasillas){
                    variable_aleatoria3 = aleatorio.nextInt((int)numeroCasillas)+1;
                    continue;
                }

                break;
            }
            while(true);

            casilla1[variable_aleatoria3].setTipoCasilla("Serpiente");
            casilla1[variable_aleatoria3].setMovimientoN(variable_avanza);
           
        }
       
        //escalera tipo2
        for (int m = 1;m<=5;m++){
            int variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;            
            do{
                variable_avanza = aleatorio.nextInt(5)+1;
                if ((variable_avanza+variable_aleatoria4) >(int)(numeroCasillas)){
                    variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                }
                
                 if (casilla1[variable_avanza+variable_aleatoria4].getTipoCasilla().equals("Serpiente")){
                     variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                }

                if (variable_aleatoria4==1){
                    variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;
                    continue;
                } 
                break; 
                
            }while(true);
                casilla1[variable_aleatoria4].setTipoCasilla("Avanza");
                casilla1[variable_aleatoria4].setMovimientoN(variable_avanza);
            
        }
        
        
        //tablero
        {   
        JFrame frame = new JFrame();
        if (presentacion.getNivelDificultad().equals("Nivel avanzado")){
            TableroAvanzado tablero1 = new TableroAvanzado((int)(numeroCasillas), jugador, casilla1, (int) numeroJugadores);
            frame.getContentPane().add(tablero1, BorderLayout.CENTER);
        }else {
            Tablero tablero1 = new Tablero((int)(numeroCasillas), jugador, casilla1, (int) numeroJugadores);
            frame.getContentPane().add(tablero1, BorderLayout.CENTER);
        }
        Titulo titulo1 = new Titulo();    
        frame.setTitle("Tablero");
        frame.getContentPane().add(titulo1, BorderLayout.EAST); 
        frame.setSize( Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height); 
	frame.setResizable(false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
        
        }      
        
        
        
        
        
        
        
        
    }
}


