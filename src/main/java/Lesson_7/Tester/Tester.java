package Lesson_7.Tester;

import Lesson_7.ClassesToTest.Cat;
import Lesson_7.ClassesToTest.Dog;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {
        public static void main(String[] args) {

        Cat cat = new Cat("Barsik",5, 3.0, "white");
        Dog dog = new Dog("Tuzik", 10, 15.0, "black");

        try {
            start(Cat.class, cat);
            start(Dog.class, dog);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void start(Class testClass, Object testObject) throws InvocationTargetException, IllegalAccessException {
        if(!isBeforeSuiteSingle(testClass)) {
            throw new RuntimeException("There is more than 1 BeforeSuite annotation used.");
        }
        if(!isAfterSuiteSingle(testClass)) {
            throw new RuntimeException("There is more than 1 AfterSuite annotation used.");
        }


        Method[] methods = testClass.getDeclaredMethods();

        //looking for BeforeSuite annotation and invoking it
        for(Method m : methods) {
            if(m.getAnnotation(BeforeSuite.class) != null) {
                m.setAccessible(true);
                m.invoke(testObject);
            }
        }

        //creating sorted map of methods by priority
        TreeMap<Integer, ArrayList<Method>> map = new TreeMap<>();
        for(Method m: methods) {
            if (m.getAnnotation(Test.class) != null) {
                if(!map.containsKey(m.getAnnotation(Test.class).priority())) {
                    ArrayList<Method> newList = new ArrayList<>();
                    newList.add(m);
                    map.put(m.getAnnotation(Test.class).priority(),newList);
                } else {
                    ArrayList<Method> listToUpdate = map.get(m.getAnnotation(Test.class).priority());
                    listToUpdate.add(m);
                    map.put(m.getAnnotation(Test.class).priority(), listToUpdate);
                }
            }
        }

        //executing methods
        for(Map.Entry<Integer, ArrayList<Method>> entry : map.entrySet()) {
            for(Method methodInList : entry.getValue()) {
                methodInList.setAccessible(true);
                methodInList.invoke(testObject);
            }
        }

        //executing AfterSuite annotation
        for(Method m : methods) {
            if(m.getAnnotation(AfterSuite.class) != null) {
                m.setAccessible(true);
                m.invoke(testObject,4);
            }
        }


    }

    private static boolean isBeforeSuiteSingle(Class classToCheck) {
        int countAnnotation = 0;

        Method[] methods = classToCheck.getDeclaredMethods();

        if (methods.length > 0) {
            for (Method m : methods) {
                if(m.getAnnotation(BeforeSuite.class) != null) {
                    countAnnotation++;
                }
            }
        }
        return countAnnotation <= 1;
    }

    private static boolean isAfterSuiteSingle(Class classToCheck) {
        int countAnnotation = 0;

        Method[] methods = classToCheck.getDeclaredMethods();

        if (methods.length > 0) {
            for (Method m : methods) {
                if(m.getAnnotation(AfterSuite.class) != null) {
                    countAnnotation++;
                }
            }
        }
        return countAnnotation <= 1;
    }


}
