package com.utils;

import com.commons.Messages;
import com.db.PostDatabase;
import com.model.Post;

import java.time.Duration;
import java.time.LocalDateTime;

public class SocialMediaUtils {

    public String calculateElapsedTime(LocalDateTime timestamp) {
        LocalDateTime now = LocalDateTime.now();
        Duration durationDiff = Duration.between(timestamp, now);

        long days = durationDiff.toDays();
        long hours = durationDiff.toHours();
        long minutes = durationDiff.toMinutes();
        long seconds = durationDiff.toSeconds();

        if(days>0){
            return days+ Messages.D_AG0;
        }
        else if(hours>0){
            return hours+Messages.H_AG0;
        }
        else if(minutes>0){
            return minutes+Messages.M_AG0;
        }
        else{
            return seconds+Messages.S_AG0;
        }
    }

    public Post getPostById(String postId) {
        return PostDatabase.getInstance().getPostHashMap().get(postId);
    }
}
