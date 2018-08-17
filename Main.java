package lesson3.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws IOException {

        //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        File file = new File("1/1.txt");
        long t = System.currentTimeMillis();
        try {
            FileInputStream in = new FileInputStream("1/1.txt");
            byte[] arr = new byte[512];
            int x;
            while ((x = in.read(arr)) != -1){
                System.out.println(new String(arr,0, x));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - t);

        //2.Последовательно сшить 5 файлов в один

        File[] files;
        files = new File[5];

        for (int i = 0; i < 5; i++) {
            files[i] = new File("1/" + (i + 1) + ".txt");
            try {
                files[i].createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<InputStream> al = new ArrayList();

        for (int i = 0; i < 5; i++) {
            try {
                al.add(new FileInputStream("1/" + (i + 1) + ".txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));

        int x;
        while((x = in.read()) != -1) System.out.print((char) x);
        in.close();
    }
}

