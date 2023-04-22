import com.commons.Messages;
import com.commons.Session;
import com.socialnetworking.SocialNetworkingApp;

import java.util.Scanner;

public class Main {
    private static Session session;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetworkingApp socialNetworkingApp = new SocialNetworkingApp();

        System.out.println(Messages.WELCOME);
        System.out.println(Messages.PROMPT);
        while(true) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase(Messages.EXIT)){
                break;
            }
            else if(input.equalsIgnoreCase(Messages.SORT_OPTION)){
                socialNetworkingApp.sortOption();
            }
            else if(input.equalsIgnoreCase(Messages.LOGOUT)){
                    socialNetworkingApp.logout();
            }
            else if(input.equalsIgnoreCase(Messages.FUNCTIONALITIES)){
                socialNetworkingApp.availableFunctionalities();
            }
            else{
                socialNetworkingApp.handleCommand(input);
            }
        }

    }
}