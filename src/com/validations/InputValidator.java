package com.validations;

import com.commons.Messages;

public class InputValidator extends Throwable {
    public static void validateLoginAttempts(String[] args){
        if (args.length < 2) {
            System.out.println(Messages.INSUFFICENT_ARGUMENTS);
        }
    }
}
