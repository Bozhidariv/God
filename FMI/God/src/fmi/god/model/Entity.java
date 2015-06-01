package fmi.god.model;

import fmi.god.enums.State;

public class Entity {

    public static final double DISTANCE = 0.1;

    protected String name;

    protected double energy;

    protected double size;

    protected double weight;

    protected Point2D position = new Point2D();

    protected double power;

    protected State state;

    protected Planet planet;
    
    public Entity() {
        super();
        this.name = RandomArguments.randomName();
        this.energy = RandomArguments.randomEnergy();
        this.size = RandomArguments.randomSize();
        this.weight = RandomArguments.randomWeight();
        this.position = RandomArguments.randomPosition();
        this.power = RandomArguments.randomPower();
        this.state = State.UNKNOWN;
    }
    
    public Entity(Planet planet){
        this();
        this.planet = planet;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
    
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
    
    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        // System.out.println(randomPower);
        this.power = power;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public Planet getPlanet() {
        return planet;
    }
    
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public void attack() {
        int size = planet.getEntities().size();
        if (size > 1) {
            for (int i = 0; i < planet.getEntities().size(); i++) {
                if (this.position.distance(planet.getEntities().get(i).position) < DISTANCE) {
                    attackEnemy(planet.getEntities().get(i));
                }
            }
        } else {
          //  System.out.println("You are the only one left");
        }

        setState(State.ATTACKING);
    }

    public void attackEnemy(Entity entity) {
        entity.energy -= this.power;
        if (entity.energy <= 0) {
            this.planet.remove(entity);
        }
    }

    public void move() {
        setPosition(RandomArguments.randomPosition());
        setState(State.MOVING);
    }

    public void doAction() {
        attack();
    }

    @Override
    public String toString() {
        return "[ Name: " + this.name + ", position: " + this.position + ", health:" + this.energy + ", state: "
                + this.state + "]";

    }
}
