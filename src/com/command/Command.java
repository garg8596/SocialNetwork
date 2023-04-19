package com.command;

import com.commons.Session;

public abstract class Command {
    public abstract void execute(String[] args, Session session);
}
