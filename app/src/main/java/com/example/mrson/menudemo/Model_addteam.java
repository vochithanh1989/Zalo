package com.example.mrson.menudemo;

/**
 * Created by Tuy on 7/9/2015.
 */
public class Model_addteam {
    private int icon;
    private String title;
    private boolean check=false;

    private boolean isGroupHeader = false;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }



    public Model_addteam(String title) {
        this(-1, title);
        isGroupHeader = true;
    }

    public Model_addteam(int icon, String title, boolean check) {
        super();
        this.icon = icon;
        this.title = title;
        this.check = check;

    }

    public Model_addteam(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;

    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGroupHeader() {
        return isGroupHeader;
    }

    public void setGroupHeader(boolean isGroupHeader) {
        this.isGroupHeader = isGroupHeader;
    }
}
