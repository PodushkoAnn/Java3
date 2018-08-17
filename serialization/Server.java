package lesson3.homework.serialization;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1/ser.txt"));
            byte [] arr = new byte[512];
            int x;
            while ((x = bis.read(arr)) != -1){
                bos.write(arr, 0, x);
            }
            bis.close();
            bos.close();

            Student student;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("1/ser.txt"));
            student = (Student)ois.readObject();
            student.info();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
