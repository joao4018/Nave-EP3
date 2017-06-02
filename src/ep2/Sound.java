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
        som = Sound.class.getResource("Sounds//"+ nome +".wav");
        Som = Applet.newAudioClip(som);
    }
    
    public AudioClip getSom(){
        return Som;
    }
}


