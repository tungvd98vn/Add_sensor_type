package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Assume that an Object that resembles a class got passed in");
        System.out.println("For now, the Object is simplified with only 3 properties: ");
        System.out.print("Class name, properties, methods");
        System.out.println("expected out put is a java class of the sensor");
        //create object
        // create write file object
        //call write file
        Object o = new Object("testSensor");
        o.addMethods("sample method()");

        o.addProperties("private static final double LOW_THRESHOLD = 30;");
        o.addProperties("private static final double HIGH_THRESHOLD = 50;");

        WriteSensor ws = new WriteSensor(o.getName(),"");

        ws.CreateFile();
        ws.WriteFile(o);

    }
}
