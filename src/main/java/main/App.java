package main;

import java.util.Scanner;
import java.util.ArrayList;

class Zoo {
    private String name;
    private ArrayList<Animal> animals;

    public Zoo(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimals() {
        System.out.println(name+" pitää sisällään seuraavat eläimet:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
    public void runAnimals(int rounds) {
            for (Animal animal : animals) {
                for (int i = 0; i < rounds; i++) {
                    animal.run(1);
            }
        }
    }
}

class Animal {
    private String species;
    private String name;
    private int age;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void run(int rounds) {
        System.out.println(name + " juoksee kovaa vauhtia!");
    }

    public String toString() {
        return species +": "+name + ", " + age + " vuotta";
    }
}

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean exit =false;

        System.out.print("Anna eläintarhalle nimi: \n");
            String zooName = sc.nextLine();
            Zoo zoo = new Zoo (zooName);
            
            
    
    while (!exit) {
        System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
        

        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("Mikä laji? ");
                String species = sc.nextLine();

                System.out.print("Anna eläimen nimi:");
                String name = sc.nextLine();

                System.out.print("Anna eläimen ikä:");
                int age = sc.nextInt();
                sc.nextLine(); 

                Animal animal = new Animal(species, name, age);
                zoo.addAnimal(animal);
                break;

            case 2:
                zoo.listAnimals();
                break;

            case 3:
                System.out.print("Kuinka monta kierrosta?");
                int rounds = sc.nextInt();
                zoo.runAnimals(rounds);
                
                
                break;

            case 0:
                exit = true;
                break;

            default:
                System.out.println("Syöte oli väärä");
            }
        }

        
        System.out.println("Kiitos Ohjelman käytöstä.");
        sc.close();
    }
}