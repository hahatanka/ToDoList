package file;

import userTask.Task;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteToFile {




    public static void SaveTask (String name, String note, String deadline, String status, String filePath){
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(name + ", " +  "\n"+ note + ", " +  "\n" + deadline + ", " +  "\n"  + status);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null,"Record saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Record NOT saved");

        }
    }

    public static ArrayList viewRecords(File file) {
        try {
            Scanner sc = new Scanner(file);
            ArrayList<String> list = new ArrayList<>();
            while (sc.hasNextLine()){
             String text = sc.nextLine();
             list.add(text);}
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }return null;
    }


        public static void searchRecord(String userInput, File file, String name, String deadline, String note, String status){
        boolean found = false;
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter("[,\n]");

            while (sc.hasNext() && !found) {
                name = sc.next();

                if(name.equalsIgnoreCase(userInput)){
                    found = true;
                }
            }
            if(found){
                JOptionPane.showMessageDialog(null, "Name: " + name + "\nDeadline " + deadline + "\nNote:" + note + "\nStatus: " + status);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR");

        }
    }

    public static void editRecord(){

    }
}
