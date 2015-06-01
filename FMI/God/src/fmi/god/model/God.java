package fmi.god.model;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fmi.god.enums.EntityType;

public class God extends Human {
    private Random rd = new Random();
    private Scene scene;

    public God(Scene scene) {
        super();
        this.scene = scene;
    }

    public God(Planet planet) {
        super(planet);
    }

    public void createPlanet() {
        Scene.instance().add(new Planet());
    }

    public void destroyPopulation() {
        List<Entity> entities = planet.getEntities();
        Iterator<Entity> iterateEntities = planet.getEntities().iterator();
        while (iterateEntities.hasNext()) {
           
            while (iterateEntities.hasNext()) {
                Entity entity = iterateEntities.next();
                // System.out.println(planet);
                if(!(entity instanceof God)){
                    entities.remove(entity);
                }
                
                // System.out.println(planet.getEntities());
            }
        }
    }

    public void addEntity(EntityType entity) {
        switch (entity) {
        case HUMAN:
            planet.add(new Human(planet));
            break;
        case ENTITY:
            planet.add(new Entity(planet));
            break;
        case ANIMAL:
            planet.add(new Animal(planet));
            break;
        case GOD:
            planet.add(new God(planet));
            break;

        }
    }

    public void doAction() {
        switch (RandomArguments.options(9)) {
        case 1:
            attack();
            break;
        case 2:
            eat();
            break;
        case 3:
            sleep();
            break;
        case 4:
            searchingForFood();
            break;
        case 5:
            analyze();
            break;
        case 6:
            createPlanet();
            break;
        case 7:
            destroyPopulation();
            break;

        case 8:
            addEntity(EntityType.randomEntity());
            break;
        }
    }
}
