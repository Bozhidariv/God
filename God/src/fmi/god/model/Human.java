package fmi.god.model;

import fmi.god.enums.State;

public class Human extends Animal {

    private final double ADDPOWER = 1;

    public Human(Planet planet) {
        super(planet);
    }

    public Human() {
        super();
    }

    public void analyze() {
        this.power += ADDPOWER;
        setState(State.ANALYSING);
    }

    public void doAction() {
        switch (RandomArguments.options(6)) {
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
        }
    }

}
