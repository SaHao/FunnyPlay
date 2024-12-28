package com.iejnnnmokkk.funnyplay.play.eventBean;

public class GamePlayVideoAds {
    private String action;
    private boolean any;

    public GamePlayVideoAds(String action,boolean any) {
        this.action = action;
        this.any = any;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isAny() {
        return any;
    }

    public void setAny(boolean any) {
        this.any = any;
    }
}
