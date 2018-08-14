package lesson1.homework.bigTask;
//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//d. Сделать метод getWeight() который высчитывает вес коробки,
// зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f,
// не важно в каких это единицах);
//e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку
// с той, которую подадут в compare в качестве параметра, true - если их веса равны,
// false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(
// помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
// соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
// которые были в этой коробке;
//g. Не забываем про метод добавления фрукта в коробку.

public class BigTask {

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        box1.addFruit(new Orange());
        box1.addFruit(new Orange());
        box1.addFruit(new Apple());
        System.out.println("Коробка 1 весит " + box1.getWeight());

        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        box2.addFruit(new Orange());
        box2.addFruit(new Apple());
        System.out.println("Коробка 2 весит " + box2.getWeight());

        System.out.println(box1.compare(box2));

        box3.addFruit(new Orange());
        box3.addFruit(new Orange());

        box3.moveFruits(box2);
        box3.moveFruits(box1);
        System.out.println("Коробка 1 весит " + box1.getWeight());
        System.out.println("Коробка 3 весит " + box3.getWeight());
    }
}
