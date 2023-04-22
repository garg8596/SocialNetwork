package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.FeedController;

public class ShowFeedCommand extends Command {
    FeedController feedController;

    public ShowFeedCommand(){
        feedController = new FeedController();
    }

    @Override
    public void execute(String[] args, Session session) {
        String sortOption;
        if(args.length==0){
            sortOption = "default";
        }
        else sortOption = args[0];
        feedController.showFeed(session, sortOption);
    }

}
