package lesson2.homework;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        MyDatabase db = new MyDatabase();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Введите команду");
            String s = sc.nextLine();
            String[] tokens = s.split(" ");
            int i = command(tokens);
            if (s.contains("'")) System.out.println("Не надо ломать базу данных");
            else if(i == 1 || i == 4) db.makeQuery(makeStatement(tokens), i);
            else if(i == 0) db.makeUpdate(makeStatement(tokens));
        }
    }

    public static String makeStatement(String... s){
        String result = null;

        if(s[0].equals("цена")){
            result = "SELECT * from main.'products' where title = " + "'" + s[1] + "'";

        } else if(s[0].equals("сменитьцену")){
            result = "update main.'products' SET cost = " + s[2] + " where title= '" + s[1] + "';";

        } else if(s[0].equals("товарыпоцене")){
            result = "select title from main.'products' where (" + s[1] + " < cost) AND (cost < " + s[2] + ")";
        }

        return result;
    }

    private static int command(String...s){
        int column = 10;
        if(s[0].equals("цена") && s.length == 2) column = 4;
        else if(s[0].equals("сменитьцену") && s.length == 3) column = 0;
        else if (s[0].equals("товарыпоцене") && s.length == 3) column = 1;
        else System.out.println("неверная команда");
        return column;
    }

}

//вывести сообщение «Такого товара нет», если товар не обнаружен в базе. Консольная
//команда: «цена товар545».
//Консольная команда: «сменитьцену товар10 10000»
//Консольная команда: «товарыпоцене 100 600»