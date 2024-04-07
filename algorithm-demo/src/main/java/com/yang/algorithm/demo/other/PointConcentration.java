package com.yang.algorithm.demo.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointConcentration {

    public static double calculateRadius(List<Point> points) {
        double meanLongitude = points.stream().mapToDouble(Point::getLongitude).average().getAsDouble();
        double meanLatitude = points.stream().mapToDouble(Point::getLatitude).average().getAsDouble();

        double[] distances = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            distances[i] = Math.sqrt(Math.pow(points.get(i).getLongitude() - meanLongitude, 2) + Math.pow(points.get(i).getLatitude() - meanLatitude, 2));
        }

        return Math.sqrt(Arrays.stream(distances).sum() / distances.length);
    }

    public static double calculateConcentration(List<Point> points) {
        double radius = calculateRadius(points);
        return 1 / radius;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();

//        points.add(new Point(117.298688,31.851165));
//        points.add(new Point(117.516581,31.86147));
//        points.add(new Point(117.21475,31.932103));

//        points.add(new Point(117.291214,31.874963));
//        points.add(new Point(117.29107,31.864537));
//        points.add(new Point(117.292651,31.876926));


        points.add(new Point(117.286066,31.869812));
        points.add(new Point(117.286165,31.869839));
        points.add(new Point(117.285662,31.870287));

        double radius = PointConcentration.calculateRadius(points);
        double concentration = PointConcentration.calculateConcentration(points);

        System.out.println(radius);
        System.out.println(concentration);

    }
}
