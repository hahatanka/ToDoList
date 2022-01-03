package file;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    String filePath;
    String useInput;

    public static void readRecord(String userInput, String filePath){
        boolean found = false;
        String name = "";
        try {
                Scanner sc = new Scanner(new File(filePath));
                sc.useDelimiter("[,\n]");

                while (sc.hasNext() && !found) {
                    name = sc.next();

                    if(name.equalsIgnoreCase(userInput)){
                        found = true;
                    }
                }
                if(found){
                    JOptionPane.showMessageDialog(null, "Name: " + name + "  ");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
