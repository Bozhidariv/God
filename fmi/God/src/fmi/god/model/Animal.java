package fmi.god.model;

import fmi.god.enums.State;

public class Animal extends Entity {

    final static int ADDHEALTH = 2;

    public Animal(Planet planet) {
        super(planet);
    }

    public Animal() {
        super();
    }

    public void eat() {
        this.energy += ADDHEALTH;
        setState(State.EATING);
    }

    public void sleep() {
        this.energy += ADDHEALTH / 2;
        setState(State.SLEEPING);
    }

    public void searchingForFood() {
        this.energy += ADDHEALTH / 2;
        setState(State.SEARCHINGFORFOOD);
    }

    public void doAction() {
        switch (RandomArguments.options(5)) {
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
        }
    }

}
