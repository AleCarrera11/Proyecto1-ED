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
import java.io.PrintWriter;
import javax.swing.JOptionPane;


/**
 * Esta clase maneja todas las funcionalidades del txt, como leerlo, revisarlo y escribirlo
 * @author alejandra, isabela
 */
public class txt {
    
    public static void writeTxt(Grafo grafo){
       List<User> info = grafo.getVertices();
       int[][] matriz = grafo.getMatriz();
       String userTxt = "Usuarios\n";
        if(!info.isEmpty()){
            for (int i = 0; i < info.getLength(); i++){
                userTxt += info.getElement(i).getId() + "," + info.getElement(i).getUser() + "\n";
            }
            String relation = "Relaciones\n";
            for (int i = 0; i < info.getLength(); i++){
                for(int j = 0; j < info.getLength(); j++){
                    if(matriz[i][j] != 0){
                        String a = grafo.getNameUser(i);
                        String b = grafo.getNameUser(j);
                        if(!"".equals(a)&& !"".equals(b) ){
                            relation += a + ", " + b + ", " + matriz[i][j] + "\n";
                        }
                    }
                }
            
            }
            userTxt += relation;
            
        }
        
        try{
            PrintWriter pw = new PrintWriter("test\\usuario.txt");
            pw.print(userTxt); // escribe
            pw.close();
            JOptionPane.showMessageDialog(null,"Guardado realizado exitosamente");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error");
        }
    } 
    
    /**
    Lee un archivo de texto que contiene información sobre usuarios y crea un grafo a partir de ella.
    @return el grafo creado a partir del archivo de texto
    @throws IOException si hay un error al leer el archivo
    */    
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
   
    /**
    Crea un objeto de usuario a partir de una cadena de información.
    @param info la cadena de información que contiene los datos del usuario en formato "nombre,correo"
    @return el objeto de usuario creado a partir de la cadena de información
    */
    public static User readUser(String info){
        String[] data = info.split(",");
        User user = new User(data[0], data[1]);
        return user;
    }
    
  
     /**
    * Este método revisa que el string de la información cumpla con los requisitos de txt.
    * Si lo hace, se hace split de la información y se crea el grafo.
    * @param infoTxt contiene la información rescatada del txt
    * @return grafo contiene la información de usuarios y relaciones de amistad, que fue leído del txt
    */
    public static Grafo checkFile(String infoTxt){
        List<User> user = new List<User>();
        String[] relation = new String[0];
        Global.setRelation(relation);
        Global.setUser(user);
        Grafo grafo = null;
        try {
            if(!"".equals(infoTxt)){
                String[] infoSplit = infoTxt.split("Relaciones\n");
                String[] userInfo = infoSplit[0].split("\n");
                String[] relationInfo = infoSplit[1].split("\n");
                for (int i=1; i < (userInfo.length ); i++){
                    User tempUser = readUser(userInfo[i]);
                    user.insertLast(tempUser);
                
                }                        
                Global.setRelation(relationInfo);
                Global.setUser(user); 
                grafo = new Grafo(user.getLength(), user, relationInfo);
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
    
