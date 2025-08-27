/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:21:55 UTC+08:00
 ****************************************************/
package org.example.generics.demo;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        
        cats.add(new PersianCat("波斯猫一号", 1));
        cats.add(new PersianCat("波斯猫二号", 2));
        cats.add(new LihuaCat("狸花猫一号", 2));
        cats.add(new LihuaCat("狸花猫二号", 3));
        
        dogs.add(new TeddyDog("泰迪一号", 1));
        dogs.add(new TeddyDog("泰迪二号", 2));
        dogs.add(new HuskyDog("哈士奇一号", 3));
        dogs.add(new HuskyDog("哈士奇二号", 4));
        
        animals.addAll(cats);
        animals.addAll(dogs);
        
        System.out.println("=== 猫 ===");
        keepPetCat(cats);
        System.out.println("=== 狗 ===");
        keepPetDog(dogs);
        System.out.println("=== 动物 ===");
        keepPetAnimal(animals);
        
        System.out.println("cats = " + cats);
        System.out.println("dogs = " + dogs);
        System.out.println("animals = " + animals);
    }
    
    public static void keepPetCat(ArrayList<? extends Cat> cats) {
        for (Cat cat : cats) {
            cat.eat();
        }
    }
    
    public static void keepPetDog(ArrayList<? extends Dog> dogs) {
        for (Dog dog : dogs) {
            dog.eat();
        }
    }
    
    public static void keepPetAnimal(ArrayList<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }
    
}
