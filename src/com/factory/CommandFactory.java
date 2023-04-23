package com.factory;

import com.command.*;
import com.commons.Messages;
import com.executor.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commandMap;
    public CommandFactory(){
        commandMap = new HashMap<>();
        commandMap.put(Messages.SIGNUP, new SignUpCommand());
        commandMap.put(Messages.LOGIN, new LoginCommand());
        commandMap.put(Messages.FOLLOW, new FollowCommand());
        commandMap.put(Messages.POSTING, new PostCommand());
        commandMap.put(Messages.UPVOTES_POST, new UpvotePostCommand());
        commandMap.put(Messages.UPVOTES_COMMENT, new UpvoteCommentCommand());
        commandMap.put(Messages.DOWNVOTES_POST, new DownvotePostCommand());
        commandMap.put(Messages.DOWNVOTES_COMMENT, new DownvoteCommentCommand());
        commandMap.put(Messages.COMMENTSS, new CommentCommand());
        commandMap.put(Messages.REPLY, new ReplyCommand());
        commandMap.put(Messages.SHOW_FEED, new ShowFeedCommand());
        commandMap.put(Messages.SHOW_PROFILE, new ShowProfileCommand());
    }


    public Command getCommand(String command){
        return commandMap.get(command);
    }

}
