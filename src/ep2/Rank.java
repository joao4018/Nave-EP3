/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author jhony
 */
public class Rank {
   
    
    public void escritor(String nome, int Score){
        try{
            //FileOutputStream arquivo = new FileOutputStream("Rank//rank.txt");
            PrintWriter pr = new PrintWriter(new FileOutputStream(
                new File("Rank//rank.txt"),true /* append = true */));
                pr.println("Ei borracha sua pontuacao :"+Score);
                pr.close();
                
            
        }catch(Exception e){
            System.out.println("Erro ao escrever arquivo");
        }
    }
    
}
