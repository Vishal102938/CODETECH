import java.io.*;
import java.util.Scanner;

public class Task1_File_Handling {

    static final String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("File Handling Utility =>");
        System.out.println("1. Write to File");
        System.out.println("2. Read from File");
        System.out.println("3. Modify File Content");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                writeFile(sc);
                break;
            case 2:
                readFile();
                break;
            case 3:
                modifyFile(sc);
                break;
            default:
                System.out.println("Invalid option.");
        }

        sc.close();
    }

    public static void writeFile(Scanner sc) {
        try {
            System.out.println("Enter text to write to the file:");
            String data = sc.nextLine();

            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(data);
            writer.close();

            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            File file = new File(FILE_PATH);
            Scanner reader = new Scanner(file);

            System.out.println("\nContent of the file:");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please write to the file first.");
        }
    }

    public static void modifyFile(Scanner sc) {
        try {
            System.out.println("Enter text to append to the file:");
            String newData = sc.nextLine();

            FileWriter writer = new FileWriter(FILE_PATH, true); 
            writer.write("\n" + newData);
            writer.close();

            System.out.println("File updated successfully!");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}