/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesesc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
        

public class Titulo extends JPanel {
    //componentes necesarios para mostar el titulo 
    private JLabel J_titulo;
    private Border B_titulo, B_outside; 
    
    //constructor para hacer el título
    public Titulo(){
        super();
        setLayout(new GridBagLayout());
        addWidgets();
    }
    //metodo interno para definir las propiedades del Jlabel del titulo
    private void addWidgets(){
        B_titulo = BorderFactory.createRaisedBevelBorder();
        J_titulo = new JLabel("PRESIONA LA BARAJA PARA TIRAR LOS DADOS");
        B_outside = BorderFactory.createLineBorder(Color.DARK_GRAY, 5, false);
        B_titulo = BorderFactory.createCompoundBorder(B_outside, B_titulo);
        J_titulo.setHorizontalAlignment( SwingConstants.CENTER ); //center
        J_titulo.setOpaque(true);
        J_titulo.setBackground(new Color(238,102,67));  //NARANJA
        J_titulo.setForeground(new Color(0,0,0));
        J_titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        J_titulo.setBorder(B_titulo);
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 300;   
        c.gridwidth = 600;      
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 20;  
        c.ipady = 15;
        
        add(J_titulo,c);
    }
}