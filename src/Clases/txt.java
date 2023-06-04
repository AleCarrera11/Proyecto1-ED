/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.Grafo;
import Estructuras.List;
import Estructuras.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            PrintWriter pw = new PrintWriter("test\\usuarios.txt");
            pw.print(userTxt); // escribe
            pw.close();
            JOptionPane.showMessageDialog(null,"Guardado realizado exitosamente");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error");
        }
    } 
    
        
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
    
    public static void removeUser(String filePath, String userName) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (!line.contains(userName)) {
                    sb.append(line).append("\n");
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)))) {
                bw.write(sb.toString());
            }
        } catch (IOException e) {
        }
    }
    
    public static void agregarUser(Grafo grafo, User user) {
    // Obtener la información actual del grafo
    List<User> info = grafo.getVertices();
    int[][] matriz = grafo.getMatriz();

    // Crear un StringBuilder para construir el nuevo contenido del archivo
    StringBuilder sb = new StringBuilder();

    // Agregar los usuarios existentes al StringBuilder
    sb.append("Usuarios\n");
    for (int i = 0; i < info.getLength(); i++) {
        sb.append(info.getElement(i).getId()).append(",").append(info.getElement(i).getUser()).append("\n");
    }

    // Agregar el nuevo usuario al StringBuilder
    sb.append(user.getId()).append(",  ").append(user.getUser()).append("\n");

    // Agregar las relaciones existentes al StringBuilder
    sb.append("Relaciones\n");
    for (int i = 0; i < matriz.length; i++) {
        for (int j = i; j < matriz.length; j++) {
            if (matriz[i][j] != 0) {
                String a = grafo.getNameUser(i);
                String b = grafo.getNameUser(j);
                if (!"".equals(a) && !"".equals(b)) {
                    sb.append(a).append(", ").append(b).append(", ").append(matriz[i][j]).append("\n");
                }
            }
        }
    }

    // Agregar las nuevas relaciones al StringBuilder
    String a = grafo.getNameUser(info.getLength());
    String b = user.getUser();
    int peso = 6;
    sb.append(a).append(", ").append(b).append(", ").append(peso).append("\n");

    // Escribir el contenido del StringBuilder en el archivo
    try (PrintWriter pw = new PrintWriter(new FileWriter("test/usuario.txt"))) {
        pw.print(sb.toString());
    } catch (IOException e) {
    }
}

 
}
    
