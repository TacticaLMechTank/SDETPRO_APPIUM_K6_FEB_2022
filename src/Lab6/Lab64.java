package Lab6;

import java.util.Scanner;

public class Lab64 {
    public static void main(String[] args) {
        //Begin to input the string
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Please input the link to check for its properties:");
        String myLink = scanner.nextLine();

        //Extract main parts of link
        String protocol = myLink.substring(0, myLink.indexOf("://"));
        String domainName = myLink.substring(myLink.indexOf("://"),myLink.indexOf("."));
        domainName = domainName.replaceAll("://","");
        domainName = domainName.replaceAll("\\.","");
        String domain = myLink.substring(myLink.indexOf("."));

        //Output result
        System.out.println("The link's protocol is: " + protocol);
        System.out.println("The link's domain name is: " + domainName);
        System.out.println("The link's domain is: " + domain);

    }
}
