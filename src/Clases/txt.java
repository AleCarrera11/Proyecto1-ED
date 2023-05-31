/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.Grafo;
import Estructuras.List;
import Estructuras.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


/**
 * Esta clase maneja todas las funcionalidades del txt, como leerlo, revisarlo y escribirlo
 * @author alejandra, isabela
 */
public class txt {
        
    public static Grafo readTxt(){
        String line;
        String infoTxt = "";
        String path = "test\\usuarios.txt";
        File file = new File(path);
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        infoTxt += line + "\n";
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null,"Lectura Exitosa");
                Grafo grafo = txt.checkFile(infoTxt);
                return grafo;
                }              
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
        }
        
        return null;
   }
   
    public static User readUser(String info){
        String[] data = info.split(",");
        User user = new User(data[0], data[1]);
        return user;
    }
  
     /**
    * Este método revisa que el string de la información cumpla con los requisitos de txt.
    * Si lo hace, se hace split de la información y se crea el grafo.
    * @param infoTxt contiene la información rescatada del txt
    * @return grafo contiene la información de almacenes y rutas, que fue leído del txt
    */
    public static Grafo checkFile(String infoTxt){
        List<user> user = new List<user>();
        String[] relation = new String[0];
        Global.setRelation(relation);
        Global.getUser(user);
        Grafo grafo = null;
        try {
            if(!"".equals(infoTxt)){
                System.out.println("Hola");
                String[] infoSplit = infoTxt.split("\n");
                if (infoSplit[0].equals("Usuarios")){
                    for (int i=1; i < (infoSplit.length - 1); i++){
                        if (!infoSplit[i].equals("Relaciones")){
                            User tempUser = readUser(infoSplit[i]);
                            user.insertLast(tempUser);
                        }else{
                            relation = infoSplit[i+1].split(",");
                            break;
                        }
                    }
                Global.setRelation(relation);
                Global.setUser(user); 
                grafo = new Grafo(user.getLength(), user, relation);
                }  
            }
            if (Global.getRelation().length != 0 && !Global.getUser().isEmpty()){
                JOptionPane.showMessageDialog(null,"El archivo cumple con la estructura necesaria!");
                return grafo;
            } else {
                JOptionPane.showMessageDialog(null, "\nEl archivo no cumple con la estructura necesaria, intenta otro archivo o usa el archivo default");
                return grafo;
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex + "\nEl archivo no cumple con la estructura necesaria, intenta otro archivo o usa el archivo default");
        }
        return grafo;
    }
}
    

