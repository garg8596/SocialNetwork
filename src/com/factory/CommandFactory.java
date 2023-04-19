package com.factory;

import com.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commandMap;
    public CommandFactory(){
        commandMap = new HashMap<>();
        commandMap.put("signup", new SignUpCommand());
        commandMap.put("login", new LoginCommand());
        commandMap.put("follow", new FollowCommand());
        commandMap.put("post", new PostCommand());
        commandMap.put("upvote", new UpvoteCommand());
        commandMap.put("downvote", new DownvoteCommand());
        commandMap.put("comment", new CommentCommand());
        commandMap.put("reply", new ReplyCommand());
    }

    public Command getCommand(String command){
        return commandMap.get(command);
    }
}
