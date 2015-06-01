package fmi.god.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Scene {

    private static final Scene  INSTANCE = new Scene();
    
    private List<Planet> planets = new CopyOnWriteArrayList<>();

    private Scene(){
        
    }
    
    public static Scene instance(){
        return INSTANCE;
    }
    
    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }


    public void destroy(Planet planet) {
        this.planets.remove(planet);
    }

    public void add(Planet planet) {
        this.planets.add(planet);
    }

    public boolean isContained(String name) {
        for (int i = 0; i < this.planets.size(); i++) {
            if (name.equals(this.planets.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public Planet getPlanet(int i) {
        return this.planets.get(i);
    }

    public int returnIndex(String name) {
        for (int i = 0; i < this.planets.size(); i++) {
            if (name.equals(this.planets.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public void show() {
        if (planets.isEmpty()) {
            System.out.println("[ Planet count: " + 0 + "]");
        } else {
            System.out.println("[ Planet count: " + this.planets.size() + "]");
            for (int i = 0; i < this.planets.size(); i++) {
                System.out.println(planets.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "[ Planet count: " + this.planets.size() + "]";
    }

}
