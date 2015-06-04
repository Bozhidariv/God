package fmi.god.model;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fmi.god.enums.EntityType;

public class Simulator {

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    private Scene scene = Scene.instance();

    private God god = new God(scene);

    public void run() {
        EXECUTOR.execute(menuThread());
        EXECUTOR.execute(updaterThread());
    }

    public synchronized void update() {
        List<Planet> planets = scene.getPlanets();
        if (planets != null && !planets.isEmpty()) {

            Iterator<Planet> iteratePlanets = scene.getPlanets().iterator();
            while (iteratePlanets.hasNext()) {
                Planet planet = iteratePlanets.next();
                Iterator<Entity> entityIterator = planet.getEntities().iterator();

                while (entityIterator.hasNext()) {
                    Entity entity = entityIterator.next();
                    // System.out.println(planet);
                    entity.move();
                    entity.doAction();
                    // System.out.println(planet.getEntities());
                }
            }
        }

    }

    public void addEntities(Planet planet, EntityType entity, int number) {
        for (int i = 0; i < number; i++) {
            planet.addEntity(entity);
        }
    }

    public void add(String input) {
        String[] args = input.split("\\s+");
        String entity = args[2];
        Integer number = null;
        if (isNumeric(args[3])) {
            number = Integer.parseInt(args[3]);
        }
        if (EntityType.isEntity(entity) == false || number == null) {
            System.out.println("Wrong input");

        } else {

            if (scene.isContained(args[1])) {
                addEntities(scene.getPlanet(scene.returnIndex(args[1])), EntityType.valueOf(entity.toUpperCase()),
                        number);
               // System.out.println(scene.getPlanet(scene.returnIndex(args[1])));

            } else {
                Planet planet = new Planet();
                planet.setName(args[1]);

                if (planet != null && entity != null) {
                    addEntities(planet, EntityType.valueOf(entity.toUpperCase()), number);
                    System.out.println(planet);
                } else {
                    System.out.println("Wrong input!");
                }
                scene.add(planet);
            }
        }
    }

    public void create() {
        Planet createPlanet = new Planet();
        scene.add(createPlanet);
     //   System.out.println(createPlanet);
    }

    public void extinct(String input) {
        String[] args = input.split("\\s+");
        if (scene.isContained(args[1])) {
            scene.getPlanet(scene.returnIndex(args[1])).extinct();

            System.out.println(scene.getPlanet(scene.returnIndex(args[1])));
        } else {
            System.out.println("There is no such planet");
        }
    }

    public void destroy(String input) {
        String[] args = input.split("\\s+");
        if (scene.isContained(args[1])) {
            scene.destroy(scene.getPlanet(scene.returnIndex(args[1])));

            System.out.println("Planet " + args[1] + " has been destoyed");
        } else {
            System.out.println("There is no such planet");
        }
    }

    public void menu() {
        System.out.println("MENU COMMANDS");
        System.out.println("create - Creating random planet");
        System.out.println("extinct <planet name> - Extinction of planet's population");
        System.out.println("destroy <planet_name> - Destoy whole planet");
        System.out.println("stats - Statistics for planets");
        System.out.println("add <planet name> <entitytype> <number> - Add specific entity on specific planet");
        System.out.println("exit - Quit the program");

        String input = "";

        Scanner sc = new Scanner(System.in);
        while ((input = sc.nextLine()) != null) {
            if ("exit".equals(input)) {
                break;
            }

            String[] args = input.split("\\s+");
            String command = args[0];

            switch (command) {
            case "add":
                add(input);
                break;

            case "create":
                create();
                break;

            case "extinct":
                extinct(input);
                break;

            case "destroy":
                destroy(input);
                break;

            case "stats":
                scene.show();
                break;

            default:
                System.out.println("Wrong input");
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private Runnable updaterThread() {

        final Simulator simulator = this;

        Runnable updater = new Runnable() {
            public void run() {
                while (true) {
                    simulator.update();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        return updater;
    }

    private Runnable menuThread() {

        final Simulator simulator = this;

        Runnable menuThread = new Runnable() {
            public void run() {
                simulator.menu();
            }
        };

        return menuThread;
    }

}
