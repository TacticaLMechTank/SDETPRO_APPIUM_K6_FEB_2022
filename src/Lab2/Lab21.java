package Lab2;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        //Input value
        System.out.println("Please enter your height (m): ");
        double height = scanner.nextFloat();
        System.out.println("Please enter your weight (kg): ");
        double weight = scanner.nextInt();

        //Calculate result
        double bmi = weight/(height*height);
        String roundBmi = decimalFormat.format(bmi);

        //Output result
        if (bmi <= 18.5) {
            System.out.printf("Your BMI is %s, you are Underweight", roundBmi);
        } else if (bmi < 25){
            System.out.printf("Your BMI is %s, you have Normal weight", roundBmi);
        } else if (bmi < 30){
            System.out.printf("Your BMI is %s, you are Overweight", roundBmi);
        } else {
            System.out.printf("Your BMI is %s, you are Obesity", roundBmi);
        }
    }
}
