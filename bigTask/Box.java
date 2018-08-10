package lesson1.homework.bigTask;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private ArrayList<T> content;
    float weight;
    Class type;

    public Box(){
        this.content = new ArrayList<T>();
        this.weight = 0;
    }

    public float getWeight(){
        if(content == null) return 0.0f;
        for(T fruit: content){
            weight = weight + fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box two){
        return this.getWeight() == two.getWeight();
    }

    public void addFruit(T fruit){
        if(content.size() == 0) {
            content.add(fruit);
            type = fruit.getClass();
            System.out.println("Добавили " + fruit.getName());
        } else if(fruit.getClass() == type) {
            content.add(fruit);
            System.out.println("Добавили " + fruit.getName());
        }
        else System.out.println("В этом ящике лежит другой тип фруктов");
    }

    public void moveFruits(Box to){
        if(this.type == to.type){
            to.content.addAll(this.content);
            content = null;
        } else System.out.println("Нельзя смешивать яблоки с апельсинами");
    }

}
