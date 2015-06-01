package fmi.god.unit.testing;

import fmi.god.model.Entity;
import fmi.god.model.God;
import fmi.god.model.Planet;
import fmi.god.model.Scene;
import fmi.god.model.Simulator;

public class Test {
    public static void main(String[] args) {
        /*
         * Entity a = new Entity(); Planet entities = new Planet(); // Random rd
         * = new Random(); a.setPosition(); a.setEnergy(100); ; b.attack(a);
         * b.setPower(); a.move();
         */
        /*
         * a.setName("baba"); Entity b = new Entity(); // b.setName("dqdo");
         * entities.add(a); entities.add(b);
         * 
         * System.out.println(entities); // entities.extinct();
         * System.out.println(entities); //entities.setName(); Planet second =
         * new Planet(); second.add(a); second.add(b);
         * 
         * 
         * 
         * System.out.println(second); Scene scene = new Scene();
         * scene.add(entities); scene.add(second); System.out.println(a);
         * System.out.println(scene);
         */
        /*
         * Entity human = new Human(); System.out.println(human); Entity animal
         * = new Animal(); System.out.println(animal); Planet earth = new
         * Planet("Earth"); earth.add(animal); earth.add(human); human.attack();
         * System.out.println(earth);
         * 
         * Entity animal = new Animal(); animal.doAction();
         * System.out.println(animal.getState()); System.out.println(animal);
         * 
         * animal.doAction(); System.out.println(animal.getState());
         * System.out.println(animal);
         */
      /*  Scene scene = Scene.instance();
       // Simulator sim = new Simulator();
       // God god = new God();
        Planet a = new Planet();
        Planet b = new Planet();
        Entity c = new Entity();
        scene.add(a);
        scene.add(b);
        for(int i = 0 ; i < 100; i++){
           a.add(c);
           b.add(c);
        }
        God god = new God(scene);
        god.destroyPopulation();
        System.out.println(a);
        System.out.println(b);
*/
    }
}
