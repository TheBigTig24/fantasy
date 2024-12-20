package com.fantasy.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Setting {

    @Column(name = "killMult", table = "Settings")
    private int killMult;

    @Column(name = "deathMult", table = "Settings")
    private int deathMult;

    @Column(name = "assistMult", table = "Settings")
    private int assistMult;

    @Column(name = "csMult", table = "Settings")
    private int csMult;

    @Column(name = "kpMult", table = "Settings")
    private int kpMult;

    @Column(name = "dmgPercMult", table = "Settings")
    private int dmgPercentageMult;

    @Column(name = "wardsPlacedMult", table = "Settings")
    private int wardsPlacedMult;

    @Column(name = "wardsDestroyedMult", table = "Settings")
    private int wardsDestroyedMult;

    @Column(name = "gameResultMult", table = "Settings")
    private int gameResultMult;

    public Setting() {}

    public Setting(int killMult, int deathMult, int assistMult, int csMult, int kpMult, int dmgPercentageMult, int wardsPlacedMult, int wardsDestroyedMult, int gameResultMult) {
        this.killMult = killMult;
        this.deathMult = deathMult;
        this.assistMult = assistMult;
        this.csMult = csMult;
        this.kpMult = kpMult;
        this.dmgPercentageMult = dmgPercentageMult;
        this.wardsPlacedMult = wardsPlacedMult;
        this.wardsDestroyedMult = wardsDestroyedMult;
        this.gameResultMult = gameResultMult;
    }

    public int getKillMult() {
        return killMult;
    }

    public void setKillMult(int killMult) {
        this.killMult = killMult;
    }

    public int getDeathMult() {
        return deathMult;
    }

    public void setDeathMult(int deathMult) {
        this.deathMult = deathMult;
    }

    public int getAssistMult() {
        return assistMult;
    }

    public void setAssistMult(int assistMult) {
        this.assistMult = assistMult;
    }

    public int getCsMult() {
        return csMult;
    }

    public void setCsMult(int csMult) {
        this.csMult = csMult;
    }

    public int getKpMult() {
        return kpMult;
    }

    public void setKpMult(int kpMult) {
        this.kpMult = kpMult;
    }

    public int getDmgPercMult() {
        return dmgPercentageMult;
    }

    public void setDmgPercMult(int dmgPercentageMult) {
        this.dmgPercentageMult = dmgPercentageMult;
    }

    public int getWardsPlacedMult() {
        return wardsPlacedMult;
    }

    public void setWardsPlacedMult(int wardsPlacedMult) {
        this.wardsPlacedMult = wardsPlacedMult;
    }

    public int getWardsDestroyedMult() {
        return wardsDestroyedMult;
    }

    public void setWardsDestroyedMult(int wardsDestroyedMult) {
        this.wardsDestroyedMult = wardsDestroyedMult;
    }

    public int getGameResultMult() {
        return gameResultMult;
    }

    public void setGameResultMult(int gameResultMult) {
        this.gameResultMult = gameResultMult;
    }
}
