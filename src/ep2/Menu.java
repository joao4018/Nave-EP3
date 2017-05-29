/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author joao
 */
public class Menu {
    
 
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
    
    
    
    public void render(){
        
        preparaGUI();
        mostrarExemplo();
    }
    private void preparaGUI(){
      mainFrame = new JFrame("Exemplo Java SWING");
      mainFrame.setSize(Game.getWidth(), Game.getHeight());
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.setLocationRelativeTo(null);

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        

      statusLabel.setSize(350,100);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void mostrarExemplo(){
      headerLabel.setText("Clique em um dos botões"); 

      JButton okButton = new JButton("OK");
      JButton submitButton = new JButton("Enviar");
      JButton cancelButton = new JButton("Cancelar");

      okButton.setActionCommand("OK");
      submitButton.setActionCommand("Enviar");
      cancelButton.setActionCommand("Cancelar");

      okButton.addActionListener(new ButtonClickListener()); 
      submitButton.addActionListener(new ButtonClickListener()); 
      cancelButton.addActionListener(new ButtonClickListener()); 

      controlPanel.add(okButton);
      controlPanel.add(submitButton);
      controlPanel.add(cancelButton);       

      mainFrame.setVisible(true); 
   }

   private class ButtonClickListener implements java.awt.event.ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         if( command.equals( "OK" ))  {
            Map.State = Map.State.GAME;
            mainFrame.setVisible(false);
         }
         else if( command.equals( "Enviar" ) )  {
            statusLabel.setText("Botão Enviar apertado."); 
         }
         else  {
            statusLabel.setText("Botão Cancelar apertado.");
         }  	
      }		
   }
    

}
