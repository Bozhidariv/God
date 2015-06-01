package fmi.god.enums;

public enum State {

    MOVING("Moving"),

    ATTACKING("Attacking"),

    EATING("Eating"),

    SEARCHINGFORFOOD("SearchingForFood"),

    SLEEPING("Sleeping"),

    ANALYSING("Analyzing"),

    UNKNOWN("Unknown");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    public State value(String name) {
        for (State state : State.values()) {
            if (state.value().equalsIgnoreCase(name)) {
                return state;
            }
        }

        return null;
    }
}
