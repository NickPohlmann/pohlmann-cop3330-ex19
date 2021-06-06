/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String heightString = myApp.readInput("Enter your height in inches: ");
        String weightString = myApp.readInput("Enter your weight in pounds: ");
        float height = myApp.convertToFloat(heightString);
        float weight = myApp.convertToFloat(weightString);
        float BMI = myApp.calcBMI(height, weight);
        String outputString = myApp.generateOutputString(BMI);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(float BMI) {
        if(BMI < 18.5) {
            return String.format("Your BMI is %.1f.\nYou are underweight. You should see a medical professional.",BMI);
        } else if (BMI < 25) {
            return String.format("Your BMI is %.1f.\nYou are within the ideal weight range.", BMI);
        } else {
            return String.format("Your BMI is %.1f.\nYou are overweight. You should see a medical professional", BMI);
        }
    }

    private float calcBMI(float height, float weight) {
        float BMI = (weight / (height * height)) * 703;
        return BMI;
    }

    private float convertToFloat(String str) {
        float num = Float.parseFloat(str);
        return num;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        if (!input.matches("[0-9]+")){
            System.out.print("The data you entered is invalid");
            System.exit(0);
        }
        return input;
    }
}