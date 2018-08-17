package lesson3.homework;

//Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
// Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
// Контролируем время выполнения: программа не должна загружаться дольше 10 секунд,
// а чтение – занимать свыше 5 секунд.

import java.io.*;
import java.util.Scanner;

public class ReadingText {

    public static void main(String[] args) {

        File file = new File("1/text.txt");
        Scanner scanner = new Scanner(System.in);
        int pageLength = 1800;
        char [] arr = new char[pageLength];

        int page = scanner.nextInt();
        long t = System.currentTimeMillis();
        try {
            FileInputStream in = new FileInputStream("1/text.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            for (int i = 0; i < page; i++) {
                br.read(arr);
            }
            br.read(arr);

            for(char c : arr){
                System.out.print(c);
            }
            System.out.println();

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - t);
    }
}
