package com.socialnetworking;

import com.command.Command;
import com.commons.Session;
import com.factory.CommandFactory;
import com.model.User;

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
        System.out.print("1.Login/SignUp <userId> <password>");
        System.out.print(" 2.Post <content>");
        System.out.print(" 3.Follow <user_id>");
        System.out.print(" 4.Reply <feed_id> <reply_text>");
        System.out.print(" 5.Upvote/Downvote <feed_id>");
        System.out.print(" 6.Show NewsFeed <sortOptions>");
        System.out.print(" 7.Logout");
        System.out.println();
    }

    public void sortOption(){
        System.out.println("Here are the SortOption you can use:");
        System.out.print("1.Followed users: posts by followed users appear first.");
        System.out.print(" 2.Score (= upvotes - downvotes): higher the better.");
        System.out.print(" 3.The number of comments: higher the better.");
        System.out.print(" 4.Timestamp: more recent the better.");
        System.out.println();
    }

}
