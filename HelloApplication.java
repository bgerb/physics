package com.example.demofx;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.*;

import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.ArrayList;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.lang.Math;
import java.io.*;
import java.lang.Thread;

public class HelloApplication extends Application{
    @Override
    public void start(Stage primaryStage) {
        //creates planets and pane then adds
        BorderPane pane = new BorderPane();
        /*
        CreatePlanet big = new CreatePlanet(2000000000, 30, 0, 0, 500,350);
        BallPane big1 = new BallPane(big);
        big.addCircle(big1);
        CreatePlanet small = new CreatePlanet(10000000, 2, 0, -1.75, 800,350);
        BallPane small1 = new BallPane(small);
        small.addCircle(small1);
        CreatePlanet extra = new CreatePlanet(1, 3, 0, -5.25, 550,350);
        BallPane extra1 = new BallPane(extra);
        extra.addCircle(extra1);
        CreatePlanet supersmall =  new CreatePlanet(.1, .2, 0 ,-2.47, 810, 350);
        BallPane supersmall1 = new BallPane(supersmall);
        supersmall.addCircle(supersmall1);

         */
        CreatePlanet big = new CreatePlanet(1000000000, 30, 0, 0, 300,110);
        BallPane big1 = new BallPane(big);
        big.addCircle(big1);
        CreatePlanet small = new CreatePlanet(200000000, 30, 0, 0, 200,200);
        BallPane small1 = new BallPane(small);
        small.addCircle(small1);
        CreatePlanet extra = new CreatePlanet(300000000, 30, 0, 0, 300,320);
        BallPane extra1 = new BallPane(extra);
        extra.addCircle(extra1);
        //CreatePlanet supersmall =  new CreatePlanet(.1, .2, 0 ,-2.47, 810, 350);
       // BallPane supersmall1 = new BallPane(supersmall);
        //supersmall.addCircle(supersmall1);
        pane.getChildren().addAll(big1, small1, extra1);



        // creates a scence
        Scene scene = new Scene(pane, 1000, 1000);

        primaryStage.setTitle("E15_03");
        primaryStage.setScene(scene);
        primaryStage.setWidth(10000);
        primaryStage.setHeight(10000);
        // makes a timeline for what happens once picture is on screen
        Timeline test = new Timeline(

                new KeyFrame(Duration.millis(15), e -> {

                    ArrayList<CreatePlanet> test1 = new ArrayList<>();
                    test1.add(small);
                    test1.add(big);
                    //test1.add(supersmall);
                    test1.add(extra);
                    int accum =0;
                    ArrayList<Double> moveplanets = Graviety.simulate(test1);



                    for (int i = 0; i < moveplanets.size(); i+=2) {
                        test1.get(accum).updateSpeed(moveplanets.get(i), moveplanets.get(i+1));
                        test1.get(accum).returnCircle().moveX(moveplanets.get(i));
                        test1.get(accum).returnCircle().moveY(moveplanets.get(i+1));
                        test1.get(accum).setX(test1.get(accum).returnCircle().centerX());
                        test1.get(accum).setY(test1.get(accum).returnCircle().centerY());
                        ++accum;


                    }









/*
                    double[] newstuff = Graviety.simulate(small,big);
                    // update the speed of both planets
                    small.updateSpeed(newstuff[0],newstuff[1]);
                    big.updateSpeed(newstuff[2],newstuff[3]);
                    // move each planet both x and y directions

                    small1.moveX(newstuff[0]);
                    small1.moveY(newstuff[1]);
                    big1.moveX(newstuff[2]);
                    big1.moveY(newstuff[3]);
                    // sets new x and y position for the planets
                    small.setX(small1.centerX());
                    small.setY(small1.centerY());
                    big.setX(big1.centerX());
                    big.setY(big1.centerY());

 */










                })
        );
        test.setCycleCount(100000000);
        test.play();

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);


    }
}
// create ball
class BallPane extends Pane {
        // ball
    private Circle ball;
    // takes a planet and makes a ball
    public BallPane(CreatePlanet test) {
        ball = new Circle(test.getX(), test.getY(), test.getRadius());
        ball.setFill(Color.WHITE);
        ball.setStroke(Color.BLACK);
        getChildren().add(ball);

    }
    // returns the cordinates
    public double centerX(){return ball.getCenterX();}
    public double centerY(){return ball.getCenterY();}
    public Circle returnCirc() { // retursn circle
        return ball;
    }
    public void moveX(double speed){ ball.setCenterX(ball.getCenterX()+speed);}// moves a planet in just x direction
    public void moveY(double speed){ ball.setCenterY(ball.getCenterY()+speed);}// moves a planet in just y direction



}