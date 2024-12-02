import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    private static ArrayList<String> arrList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String menu = "";

        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        do{
            view();
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("I - Insert an item into the list");
            System.out.println("V - View the list");
            System.out.println("M - Move an item");
            System.out.println("Q - Quit the program");
            menu = SafeInput.getRegExString(in,"enter menu choice", "[AaDdIiVvMmOoSsCcQq]");
            if (menu.equalsIgnoreCase("A")){
                add(in);
            }
            else if (menu.equalsIgnoreCase("D")){
                delete(in);
            }
            else if (menu.equalsIgnoreCase("I")){
                insert(in);
            }
            else if (menu.equalsIgnoreCase("V")){
                view();
            }
            else if (menu.equalsIgnoreCase("M")){
                move(in);
            }
            else if (menu.equalsIgnoreCase("O")){
                openFile(chooser);
            }
            else if (menu.equalsIgnoreCase("Q")){
                done = quit(in);
            }

        }while(!done);
    }
    private static void add(Scanner in){
        String list = SafeInput.getNonZeroLenString(in, "Enter new list item");
        arrList.add(list);
    }
    private static void delete(Scanner in){
        int list = SafeInput.getRangedInt(in, "Enter list entry to delete", 1, arrList.size());
        arrList.remove(list - 1);
    }
    private static void insert(Scanner in){
        int list = SafeInput.getRangedInt(in, "Enter list number to insert", 1, arrList.size());
        String item = SafeInput.getNonZeroLenString(in, "Enter String to insert");
        arrList.add(list - 1, item);
    }
    private static void view(){
        String item = "";
        for (int i = 0; i < arrList.size(); i++ ) {

            item = arrList.get(i);
            System.out.println((i + 1) + ": " + item);
        }

    }
    private static void move(Scanner in){
        int list = SafeInput.getRangedInt(in, "Enter list number to move",1,arrList.size()) - 1;
        int moveTo = SafeInput.getRangedInt(in, "enter list number of destination", 1, arrList.size()) - 1;
        String item = arrList.get(list);
        arrList.add(moveTo, item);
        arrList.remove(list);
    }
    private static boolean quit(Scanner in){
        boolean retVal = false;
        retVal = SafeInput.getYNConfirm(in,"Are you sure you want to exit");
        return retVal;
    }
    private static void clear(){
        for (int i = 0; i < arrList.size(); i++){
            arrList.remove(i);
        }
    }
    private static void saveFile(){

    }
    private static void openFile(JFileChooser chooser){
        String rec = "";
        File selectedFile;
        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                clear();
                while (reader.ready()) {
                    rec = reader.readLine();
                    arrList.add(rec);



                }


                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }
            else  // user closed the file dialog wihtout choosing
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }  // end of TRY
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}