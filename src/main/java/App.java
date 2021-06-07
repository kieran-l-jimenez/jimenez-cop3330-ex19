import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
 *bmi = (weight / (height × height)) * 703
 *           "BMI Calculator" output
 *Your BMI is 19.5.
 *You are within the ideal weight range.
 *          or
 *Your BMI is 32.5.
 *You are overweight. You should see your doctor.
 */
public class App
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();

        System.out.print("What is your weight (lbs)? ");
        double weight = myApp.validation();
        System.out.print("What is your height (inches)? ");
        double height = myApp.validation();

        myApp.prognosis(myApp.calculateBMI(weight, height));

    }

    private double validation()
    {
        double result = -1;
        if(in.hasNextDouble())
            result = in.nextDouble();
        else
        {
            int numberFlag = 0;
            while(numberFlag == 0)
            {
                System.out.print("Please enter a numeric value ");
                in.next();
                if(in.hasNextDouble())
                {
                    result = in.nextDouble();
                    numberFlag = 1;
                }
            }
        }

        return result;
    }

    private double calculateBMI(double w, double h)
    {
        return (w / (h * h)) * 703;
    }

    private void prognosis(double BMI)
    {
        System.out.printf("Your BMI is %.1f\n", BMI);
        if(BMI < 18.5)
            System.out.println("You are underweight. You should see your doctor.");
        else if(BMI > 25)
            System.out.println("You are overweight. You should see your doctor.");
        else
            System.out.println("You are within the ideal weight range.");

    }
}