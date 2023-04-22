package com.socialnetworking;

import com.command.Command;
import com.commons.Session;
import com.factory.CommandFactory;
import com.model.User;

import java.util.HashSet;

public class SocialNetworkingApp {

    private CommandFactory commandFactory;
    private Session session;

    public SocialNetworkingApp(){
        this.session = new Session();
        this.commandFactory = new CommandFactory();
    }
    public void handleCommand(String input) {
        String[] commandTokens = input.split(" ");
        String commandName = commandTokens[0].toLowerCase();
        Command command = commandFactory.getCommand(commandName);

        if(command!=null){
            String[] args = new String[commandTokens.length-1];
            System.arraycopy(commandTokens, 1, args, 0, commandTokens.length - 1);
            command.execute(args, session);
        }
    }

    public void availableFunctionalities() {
        System.out.println("Here are the list of things you can do:");
        System.out.print(" 1.login/signup <userId> <password>");
        System.out.print(" 2.post <content>");
        System.out.print(" 3.follow <user_id>");
        System.out.print(" 4.reply <comment_id> <reply_text>");
        System.out.print(" 5.upvote_c/downvote_c(for comment) <comment_id>");
        System.out.print(" 6.upvote_p/downvote_p(for post) <post_id>");
        System.out.print(" 7.showfeed <sortOptions>");
        System.out.print(" 8.showprofile");
        System.out.print(" 9.comment <post_id> <comment_text>");
        System.out.print(" 10.logout");
        System.out.print(" 11.exit");
        System.out.println();
    }

    public void sortOption(){
        System.out.println("Here are the SortOption you can use:");
        System.out.print("1.Followed users: posts by followed users appear first.");
        System.out.print(" 2.<score> (= upvotes - downvotes): higher the better.");
        System.out.print(" 3.<comments>: higher the better.");
        System.out.print(" 4.<timestamp>: more recent the better.");
        System.out.println();
    }

    public void logout() {
        if(session.getLoggedInUser()==null){
            System.out.println("Please login before logout!!!");
        }
        else{
            System.out.println(session.getLoggedInUser().toString());
            session.setLoggedInUser(null);
            System.out.println("logout successful");
            return;
        }
    }
}
