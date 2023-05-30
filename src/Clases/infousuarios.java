/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.List;
import Estructuras.Nodo;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author soyis
 */
public class infousuarios {
    public void escribir_txt(List usuarios){
        String usuariosActuales="";
        if(!usuarios.isEmpty()){
            Nodo userTemporal = usuarios.getHead();
            for (int i=0; i<usuarios.getLength(); i++){
                usuariosActuales += userTemporal.getData();
                userTemporal = userTemporal.getNext();
            }
        }
        try{
            PrintWriter pw = new PrintWriter("test\\usuarios.txt");
            pw.append(usuariosActuales);
            pw.close();
            JOptionPane.showMessageDialog(null, "Informacion Guardada");
            
        } catch(HeadlessException | FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public List leer_txt() throws IOException{
        List usuarios = new List();
        String linea;
        String usuarios_txt = "";
        String path = "test\\usuarios.txt";
        File file = new File(path);
        try{
            if (!file.exists()){
                file.createNewFile();
                
            } else{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((linea=br.readLine()) != null){
                if (!linea.isEmpty()){
                    usuarios_txt += linea + "\n";
                }
            }
            if (!"".equals(usuarios_txt)){
                String[] usuarios_split = usuarios_txt.split("\n");
                for (int i = 0; i<usuarios_split.length; i++){
                    String[] usuario = usuarios_split[i].split(",");
                    usuarios.insertLast(usuario[0], Integer.parseInt(usuario[i]));
                }
            }
            br.close();
            JOptionPane.showMessageDialog(null, "Error en la lectura");
        }
        } catch(HeadlessException | IOException | NumberFormatException e) {
                
        }
        return usuarios;
    }
                
}

