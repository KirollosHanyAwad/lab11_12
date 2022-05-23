package com.company;

enum ShapeType{
    Square, Rectangle, Circle, Trapezium, Rhombus, Triangle, Oval, Hexagon
}

public class ShowEnum {
    public static void main(String[] args) {
            for (ShapeType s : ShapeType.values())
                System.out.println(s + " order value " + s.ordinal());
    }
}
