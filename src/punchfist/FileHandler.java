/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

import city.cs.engine.*;
import java.io.*;

/**
 *
 * @author gideon
 */
public class FileHandler {
    
    private String levelNum;
    private static String filename;
    
    public FileHandler(String f) {
        filename = f;
    }
    
    // gets ascii number from a file and sets level accordingly else just prints to console
    
    public void loadFile() throws IOException {
        FileInputStream in = new FileInputStream(filename);
        try {
            int c = in.read();
            System.out.println(c);
            // reads ascii for 1 - 3 
            if (c == 49) {
                Main.publicGame.setLevel(1);
                Main.publicGame.goToLevel();
            }
            if (c == 50) {
                Main.publicGame.setLevel(2);
                Main.publicGame.goToLevel();
            }
            if (c == 51) {
                Main.publicGame.setLevel(3);
                Main.publicGame.goToLevel();
            }
            else {
                System.out.println("No valid level in file");
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } finally {
            in.close();
        }
    }
    
    // writes to a given file with a level number that can then be accessed by loadFile
    
    public void saveFile(String level) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            writer.write(level);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    
    // here if creating files is needed (should not be used normally)
    
    public void createFile(String name) throws IOException {
        name = name + ".txt";
        if (name != null) {
            File file = new File(name);
            // if the file already exists it won't bother creating it anyways
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}