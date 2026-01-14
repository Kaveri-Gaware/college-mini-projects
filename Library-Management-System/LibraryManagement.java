import java.io.*;
import java.util.Scanner;

public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);
    static File file = new File("books.txt");

    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) addBook();
            else if (choice == 2) issueBook();
            else if (choice == 3) returnBook();
            else break;
        }
    }

    static void addBook() throws Exception {
        System.out.print("Enter book name: ");
        String book = sc.nextLine();

        FileWriter fw = new FileWriter(file, true);
        fw.write(book + ",available\n");
        fw.close();

        System.out.println("Book added");
    }

    static void issueBook() throws Exception {
        updateStatus("available", "issued");
    }

    static void returnBook() throws Exception {
        updateStatus("issued", "available");
    }

    static void updateStatus(String oldStatus, String newStatus) throws Exception {
        File temp = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        System.out.print("Enter book name: ");
        String name = sc.nextLine();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.startsWith(name + "," + oldStatus))
                bw.write(name + "," + newStatus + "\n");
            else
                bw.write(line + "\n");
        }

        br.close();
        bw.close();

        file.delete();
        temp.renameTo(file);
    }
}
