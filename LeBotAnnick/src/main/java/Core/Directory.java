/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beelzed
 */
public class Directory {
    private File repertoire;
    private String dossier;
    private String[] list;

    public Directory(String dossier){
        this.dossier = dossier;
        this.repertoire = new File(dossier);
    }

    public List<String> listRepertoire(){
        list = this.repertoire.list();
        ArrayList<String> retour = new ArrayList<>();

        for (int i = 0; i < list.length-1; i++){

            if (list[i].endsWith(".mp3")){
                retour.add(list[i]);
            }
        }
        return retour;
    }


    public String getAdress(){
        return this.dossier;
    }
}
