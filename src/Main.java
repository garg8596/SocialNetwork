import com.socialnetworking.SocialNetworkingApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetworkingApp socialNetworkingApp = new SocialNetworkingApp();

        System.out.println("Welcome to Garg Social Networking :)");
        System.out.println("Before Login/Signup please type \"functionalities\" or \"sortOption\" to know what can you do");
        while(true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("functionalities")) {
                socialNetworkingApp.availableFunctionalities();
            }
            else if(input.equalsIgnoreCase("sortOption")){
                socialNetworkingApp.sortOption();
            }
            else if(input.equalsIgnoreCase("exit")){
                break;
            }
            else{
                socialNetworkingApp.handleCommand(input);
            }
        }

    }
}