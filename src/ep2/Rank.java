/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jhony
 */
public class Rank {
   
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
    
    public void escritor(String nome, int Score){
        try{
            //FileOutputStream arquivo = new FileOutputStream("Rank//rank.txt");
            PrintWriter pr = new PrintWriter(new FileOutputStream(
                new File("Rank//rank.txt"),true /* append = true */));
                pr.println("Sua pontuacao "+nome+" :"+Score);
                pr.close();
                
            
        }catch(Exception e){
            System.out.println("Erro ao escrever arquivo");
        }
    }
    
  
}



    
 
    
    
    
    
    
    


