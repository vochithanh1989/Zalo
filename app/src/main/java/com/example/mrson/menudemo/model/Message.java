package com.example.mrson.menudemo.model;

/**
 * Created by mrson on 14/07/2015.
 */
public class Message {
    String messages;

    boolean istatus;
    boolean isyou;

    public Message(String messages, boolean isyou) {
        super();
        this.messages = messages;

        this.isyou=isyou;
        this.istatus =false;
    }
    public Message(boolean istatus , String messages) {
        super();
        this.messages = messages;

        this.istatus=istatus;
        this.isyou =false;
    }


    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public boolean isyou() {
        return isyou;
    }

    public void setIsyou(boolean isyou) {
        this.isyou = isyou;
    }

    public boolean istatus() {
        return istatus;
    }

    public void setIstatus(boolean istatus) {
        this.istatus = istatus;
    }
}
