package com.fantasy.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Setting {

    @Column(name = "killMult", table = "Settings")
    private float killMult;

    @Column(name = "deathMult", table = "Settings")
    private float deathMult;

    @Column(name = "assistMult", table = "Settings")
    private float assistMult;

    @Column(name = "csMult", table = "Settings")
    private float csMult;

    @Column(name = "kpMult", table = "Settings")
    private float kpMult;

    @Column(name = "dmgPercMult", table = "Settings")
    private float dmgPercentageMult;

    @Column(name = "wardsPlacedMult", table = "Settings")
    private float wardsPlacedMult;

    @Column(name = "wardsDestroyedMult", table = "Settings")
    private float wardsDestroyedMult;

    @Column(name = "gameResultMult", table = "Settings")
    private float gameResultMult;

    public Setting() {
        this.killMult = 3f;
        this.deathMult = -.5f;
        this.assistMult = 1f;
        this.csMult = .1f;
        this.kpMult = 1f;
        this.dmgPercentageMult = 1f;
        this.wardsPlacedMult = 2f;
        this.wardsDestroyedMult = 2f;
        this.gameResultMult = 5f;
    }

    public Setting(float killMult, float deathMult, float assistMult, float csMult, float kpMult, float dmgPercentageMult, float wardsPlacedMult, float wardsDestroyedMult, float gameResultMult) {
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

    public float getKillMult() {
        return killMult;
    }

    public void setKillMult(float killMult) {
        this.killMult = killMult;
    }

    public float getDeathMult() {
        return deathMult;
    }

    public void setDeathMult(float deathMult) {
        this.deathMult = deathMult;
    }

    public float getAssistMult() {
        return assistMult;
    }

    public void setAssistMult(float assistMult) {
        this.assistMult = assistMult;
    }

    public float getCsMult() {
        return csMult;
    }

    public void setCsMult(float csMult) {
        this.csMult = csMult;
    }

    public float getKpMult() {
        return kpMult;
    }

    public void setKpMult(float kpMult) {
        this.kpMult = kpMult;
    }

    public float getDmgPercMult() {
        return dmgPercentageMult;
    }

    public void setDmgPercMult(float dmgPercentageMult) {
        this.dmgPercentageMult = dmgPercentageMult;
    }

    public float getWardsPlacedMult() {
        return wardsPlacedMult;
    }

    public void setWardsPlacedMult(float wardsPlacedMult) {
        this.wardsPlacedMult = wardsPlacedMult;
    }

    public float getWardsDestroyedMult() {
        return wardsDestroyedMult;
    }

    public void setWardsDestroyedMult(float wardsDestroyedMult) {
        this.wardsDestroyedMult = wardsDestroyedMult;
    }

    public float getGameResultMult() {
        return gameResultMult;
    }

    public void setGameResultMult(float gameResultMult) {
        this.gameResultMult = gameResultMult;
    }
}
