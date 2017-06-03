/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author jhony
 */
public class Sound {
    private URL som ;  //= Sound.class.getResource(String name);
    private AudioClip Som; 
    public Sound(String nome){
        try{
            som = Sound.class.getResource("Sounds//"+ nome +".wav");
            Som = Applet.newAudioClip(som);
        }catch(Exception e){
            System.out.println("Arquivo de som '"+ nome +"' nao encontrado!!");
            System.out.println("Se voce alterou alguma pasta do game ou houve falha no download");
            System.out.println("Verifique se "+nome+" existe na pasta Sound");
            System.out.println("Impossivel continuar a execucao");
            System.exit(0);
        }
       
    }
    
    public AudioClip getSom(){
        return Som;
    }
}


