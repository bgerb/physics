package com.example.demofx;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.lang.Math;
public class CreatePlanet {
    private double mass;
    private double radius;
    private double speedX;
    private double speedY;
    private BallPane test;

    private double intitalX;
    private double intitalY;
    // creates random planet with random cordinate
    public CreatePlanet(){
        mass = (double) Math.random()*500;
        radius = Math.random()*100;
        speedX = Math.random()*500;
        speedY = Math.random()*500;
        intitalX = Math.random()*1000;
        intitalY = Math.random()*1000;
    }
    // sets a planet
    public CreatePlanet(double _mass, double _radius, double _speedX, double _speedY, double _initalX, double _intitalY){
        mass = _mass;
        radius = _radius;
        speedX = _speedX;
        speedY = _speedY;
        intitalX = _initalX;
        intitalY = _intitalY;
    }
    public void addCircle(BallPane test1){test = test1;}
    public BallPane returnCircle(){return test;}
    public double getX(){return intitalX;}
    public double getY(){return intitalY;}
    public double getRadius(){return this.radius;}
    public double getSpeedX() {return speedX;}
    public double getSpeedY() {return speedY;}
    public double getMass() {return mass;}
    public void updateSpeed(double _speedX, double _speedY){ // updates x and y speed of the planet
        speedX = _speedX;
        speedY = _speedY;
    }
    public void setX(double newx){intitalX=newx;}
    public void setY(double newy){intitalY=newy;}



}
