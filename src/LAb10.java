import java.util.Scanner;
import java.io.*;
public class LAb10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String otvet;
        System.out.println("Enter your ip address");
        String str = in.nextLine();// вводим строчку
        boolean answer = str.matches("([0-9]\\.|[0-9][0-9]\\.|1[0-9][0-9]\\.|2[0-4][0-9]\\.|25[0-5]\\.){3}([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");
        if (answer) {
            otvet = "The address is correct";
            System.out.println("The address is correct");
        } else {
            otvet = "Invalid address";
            System.out.println("Invalid address");
        }
        System.out.println("_______________________");
        System.out.println("Введите ESC");
        try (BufferedWriter zap = new BufferedWriter(new FileWriter("Answer.txt"))) {
            zap.write(str + "\n");
            zap.write(otvet);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String consel = in.nextLine();
        if (consel.equals("ESC")) {
            try (BufferedReader br = new BufferedReader(new FileReader("Answer.txt"))) {
                String a;
                while ((a = br.readLine()) != null) {
                    System.out.println(a);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
