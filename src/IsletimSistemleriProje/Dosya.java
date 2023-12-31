package IsletimSistemleriProje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Dosya {
    Process p;
    Node node;

    DoublyLinkedList list = new DoublyLinkedList();

    Random rand = new Random();

    public DoublyLinkedList Oku(String txt) {
        int number = 0;
        try {
            File myObj = new File(txt);
            Scanner myReader = new Scanner(myObj);
            int id = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] saniye = data.split(", ", 0);
                renkCode(number);
                p = new Process(id, Integer.parseInt(saniye[0]), Integer.parseInt(saniye[1]),
                        Integer.parseInt(saniye[2]), Integer.parseInt(saniye[3]), Integer.parseInt(saniye[4]),
                        Integer.parseInt(saniye[5]), Integer.parseInt(saniye[6]), Integer.parseInt(saniye[7]),
                        newColor(id), newBColor(id));

                // Check the condition and add to the list only if deleteProcess is false
                if (!p.deleteProcess) {
                    node = new Node(p);
                    list.addLast(node);
                }

                id++;
            }
            myReader.close();
            // System.out.println("File was read successfully...");
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            System.out.println("File not found:" + txt);
            e.printStackTrace();
        }
        return null;
    }

    public int renkCode(int number) {
        int newNum = number % 8;
        return newNum;
    }

    public String newColor(int number) {
        return "\u001B[1:3" + renkCode(number) + "m";
    }

    public String newBColor(int number) {
        int rd = rand.nextInt(8);
        int num = renkCode(number);
        if (rd == num) {
            while (rd == num) {
                rd = rand.nextInt(8);
            }
        }
        return "\u001B[10" + rd + "m";
    }
}
