package Lab6;

import java.util.Scanner;

public class Lab61 {
    public static void main(String[] args) {

        //Begin to input the time string
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Please input the time to calculate (format: 'x hour(s) and y minute(s)'): ");
        String timeString = scanner.nextLine();

        //Extract hour and minute substring
        String hourString = timeString.substring(0, timeString.indexOf("and"));
        String hourTime = hourString.replaceAll("[^0-9]","");
        String minString = timeString.substring(timeString.indexOf("and"));
        String minTime = minString.replaceAll("[^0-9]","");

        //Convert to integer
        int hour = Integer.parseInt(hourTime);
        int minute = Integer.parseInt(minTime);

        //Calculate the total value of minute from both input hour and minute
        minute = hour*60 + minute;

        //Output result
        System.out.printf("Total time is: %d minute(s)", minute);

    }
}
