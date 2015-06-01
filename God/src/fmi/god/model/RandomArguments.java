package fmi.god.model;

import java.util.Random;

public class RandomArguments {

    private static final String LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    private static final double rangeMin = 0;

    private static final double rangeMax = 10;

    private static final double rangeMaxEnergy = 100;

    private static final double rangeMaxWeight = 50;

    private static final double rangeMaxSize = 20;

    private static Random rd = new Random();

    public static int options(int n) {
        return rd.nextInt(n);
    }

    public static Point2D randomPosition() {
        Point2D position = new Point2D();
        int[] array = new int[] { -1, 1 };
        int rnd = rd.nextInt(array.length);

        double randomDirection = array[rnd];
        double randomValueX = (rangeMin + (rangeMax - rangeMin) * rd.nextDouble()) * randomDirection;
        double randomValueY = (rangeMin + (rangeMax - rangeMin) * rd.nextDouble()) * randomDirection;

        if (randomValueY > Point2D.MAX_Y) {
            randomValueY -= Point2D.MAX_Y;
        }

        if (randomValueX > Point2D.MAX_X) {
            randomValueX -= Point2D.MAX_X;
        }

        position.setX(randomValueX);
        position.setY(randomValueY);

        return position;
    }

    public static String randomName() {
        StringBuilder builder = new StringBuilder();
        int length = rd.nextInt(5) + 5;
        for (int i = 0; i < length; i++) {
            builder.append(LEXICON.charAt(rd.nextInt(LEXICON.length())));
        }
        return builder.toString();
    }

    public static double randomPower() {
        return (rangeMin + (rangeMax - rangeMin) * rd.nextDouble());
    }

    public static double randomEnergy() {
        return (rangeMin + (rangeMaxEnergy - rangeMin) * rd.nextDouble());
    }

    public static double randomWeight() {
        return (rangeMin + (rangeMaxWeight - rangeMin) * rd.nextDouble());
    }

    public static double randomSize() {
        return (rangeMin + (rangeMaxSize - rangeMin) * rd.nextDouble());
    }
}
