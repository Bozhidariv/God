package fmi.god.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import fmi.god.enums.EntityType;

public class Planet {

    private List<Entity> entities = new CopyOnWriteArrayList<>();

    private String name;

    public Planet() {
        setName(RandomArguments.randomName());
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void extinct() {
        this.entities.clear();
    }
 
    public void remove(Entity entity) {
        entities.remove(entity);
    }

    public void add(Entity entity) {
        entities.add(entity);
    }

    public void addEntity(EntityType entity) {
        switch (entity) {
        case HUMAN:
            entities.add(new Human(this));
            break;
        case ENTITY:
            entities.add(new Entity(this));
            break;
        case ANIMAL:
            entities.add(new Animal(this));
            break;
        case GOD:
            entities.add(new God(this));
            break;
        default:
            System.out.println("Wrong input for entity type: " + entity);
        }
    }

    @Override
    public String toString() {
        return "[ Name: " + this.name + ", population: " + this.entities.size() + "]";
    }

}
