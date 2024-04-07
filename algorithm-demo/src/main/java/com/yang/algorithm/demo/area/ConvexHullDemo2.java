package com.yang.algorithm.demo.area;

import org.locationtech.jts.algorithm.ConvexHull;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPoint;

import java.util.ArrayList;
import java.util.List;

public class ConvexHullDemo2 {

    public static double calculateConvexHullArea(List<Coordinate> coordinates) {
        GeometryFactory geometryFactory = new GeometryFactory();
        MultiPoint multiPoint = geometryFactory.createMultiPointFromCoords(coordinates.toArray(new Coordinate[0]));

        ConvexHull convexHull = new ConvexHull(multiPoint);
        Geometry convexHullGeometry = convexHull.getConvexHull();

        return convexHullGeometry.getArea();
    }

    public static void main(String[] args) {
        // Example usage
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(117.295454,31.855275));
        coordinates.add(new Coordinate(117.313132,31.849202));
        coordinates.add(new Coordinate(117.290783,31.856441));
        coordinates.add(new Coordinate(117.310761,31.860673));

        double area = calculateConvexHullArea(coordinates);
        area *= 10000;
        System.out.println("Convex Hull Area: " + area);
    }
}
