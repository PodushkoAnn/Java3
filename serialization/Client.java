package lesson3.homework.serialization;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static Socket clientSocket;
    private static DataInputStream in;
    private static DataOutputStream send;

    public static void main(String[] args) {

        try {
            clientSocket = new Socket("localhost", 8189);

            Student student = new Student(100, "Glory");
            student.info();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("1/out.txt"));
            out.writeObject(student);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1/out.txt"));
            OutputStream bos = clientSocket.getOutputStream();
            byte [] arr = new byte[512];
            int x;
            while ((x = bis.read(arr)) != -1){
                bos.write(arr, 0, x);

            }
            bis.close();
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
