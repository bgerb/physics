package com.example.demofx;
import java.lang.Math;
import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Graviety {

        public static double[] simulate(CreatePlanet small, CreatePlanet big) {
            // define the properties of the first planet

            double velX1 = 0.0;
            double velY1 = 0.0;

            // define the properties of the second planet

            double velX2 = 0.0;
            double velY2 = 0.0;

            // define the gravitational constant
            double G = 6.67408e-7;
            // calculate the distance between the two planets
            double dx = Math.abs(small.getX() - big.getX());
            double dy = Math.abs(small.getY() - big.getY());
            double distance = Math.sqrt(dx * dx + dy * dy);

            // calculate the gravitational force between the two planets
            double force = (G * small.getMass() * big.getMass()) / (distance * distance);


            // calculate the acceleration of each planet
            double accX1 = ((force * (big.getX()-small.getX()) / distance )/ small.getMass());
            double accY1 = ((force * (big.getY()-small.getY()) / distance )/ small.getMass());
            double accX2 = ((force * (small.getX()-big.getX()) / distance )/ big.getMass());
            double accY2 = ((force * (small.getY()-big.getY()) / distance )/ big.getMass());






            // update the velocity of each planet
            double[] velocity = new double[4];
            velX1 = (accX1 + (small.getSpeedX()));
            velY1 = (accY1 + (small.getSpeedY()));
            velX2 = (accX2 + (big.getSpeedX()));
            velY2 = (accY2 + (big.getSpeedY()));







            // add velocity to array then return

            velocity[0] = velX1;
            velocity[1] = velY1;
            velocity[2] = velX2;
            velocity[3] = velY2;



            return velocity;

        }

        public static ArrayList<Double> simulate(ArrayList<CreatePlanet> planets){
            ArrayList<CreatePlanet> fortest = new ArrayList<>();
            for (int i = 0; i < planets.size(); i++) {
                fortest.add(planets.get(i));

            }

            ArrayList<Double> returnxy = new ArrayList<>();
            for (int i = 1; i <= fortest.size(); i++) {
                double x =fortest.get(0).getSpeedX();
                double y =fortest.get(0).getSpeedY();

                for (int j = 1; j < fortest.size(); j++) {
                    // define the properties of the second planet
                    // define the gravitational constant
                    double G = 6.67408e-7;
                    // calculate the distance between the two planets
                    double dx = Math.abs(fortest.get(0).getX() - fortest.get(j).getX());
                    double dy = Math.abs(fortest.get(0).getY() - fortest.get(j).getY());
                    double distance = Math.sqrt(dx * dx + dy * dy);

                    // calculate the gravitational force between the two planets
                    double force = (G * fortest.get(0).getMass() * fortest.get(j).getMass()) / (distance * distance);
                    // calculate the acceleration of each planet
                   x += ((force * (fortest.get(j).getX()-fortest.get(0).getX()) / distance )/ fortest.get(0).getMass());
                   y += ((force * (fortest.get(j).getY()-fortest.get(0).getY()) / distance )/ fortest.get(0).getMass());

                    // update the velocity of each planet
                }

                returnxy.add(x);
                returnxy.add(y);

                if(i < fortest.size()) {
                    Collections.swap(fortest, 0, i);

                }


            }
            return returnxy;



        }


    }


