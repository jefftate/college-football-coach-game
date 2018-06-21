/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.dto;

import java.util.Objects;

/**
 *
 * @author jefftate
 */
public class Coach {

    public Coach(String coachName) {
        this.coachName = coachName;
    }

    private String coachName;

    private int qbStrength;
    private int rbStrength;
    private int wrStrength;
    private int dStrength;
    private int totalStrength;

    private boolean goodOffSeason;
    private boolean goodWeeklyRandom;

    private boolean wonLastGame;
    private int teamScoreLastGame;
    private int oppScoreLastGame;

    private boolean playingBowlGame;
    private String bowlGame;
    private boolean nationalChamp;

    private int seasonWins;
    private int seasonLosses;

    private int careerWins;
    private int numberOfSeasons;

    private int preSeasonRank;
    private boolean rankedPostSeason;
    private int postSeasonRank;

    public boolean isNationalChamp() {
        return nationalChamp;
    }

    public void setNationalChamp(boolean nationalChamp) {
        this.nationalChamp = nationalChamp;
    }

    public int getSeasonLosses() {
        return seasonLosses;
    }

    public void setSeasonLosses(int seasonLosses) {
        this.seasonLosses = seasonLosses;
    }

    public int getTotalStrength() {
        return totalStrength;
    }

    public void setTotalStrength(int totalStrength) {
        this.totalStrength = totalStrength;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getQbStrength() {
        return qbStrength;
    }

    public void setQbStrength(int qbStrength) {
        this.qbStrength = qbStrength;
        if (qbStrength > 100) {
            this.qbStrength = 100;
        }
        if (qbStrength < 0) {
            this.qbStrength = 0;
        }
    }

    public int getRbStrength() {
        return rbStrength;
    }

    public void setRbStrength(int rbStrength) {
        this.rbStrength = rbStrength;
        if (rbStrength > 100) {
            this.rbStrength = 100;
        }
        if (rbStrength < 0) {
            this.rbStrength = 0;
        }
    }

    public int getWrStrength() {
        return wrStrength;
    }

    public void setWrStrength(int wrStrength) {
        this.wrStrength = wrStrength;
        if (wrStrength > 100) {
            this.wrStrength = 100;
        }
        if (wrStrength < 0) {
            this.wrStrength = 0;
        }
    }

    public int getdStrength() {
        return dStrength;
    }

    public void setdStrength(int dStrength) {
        this.dStrength = dStrength;
        if (dStrength > 100) {
            this.dStrength = 100;
        }
        if (dStrength < 0) {
            this.dStrength = 0;
        }
    }

    public boolean isWonLastGame() {
        return wonLastGame;
    }

    public void setWonLastGame(boolean wonLastGame) {
        this.wonLastGame = wonLastGame;
    }

    public int getTeamScoreLastGame() {
        return teamScoreLastGame;
    }

    public void setTeamScoreLastGame(int teamScoreLastGame) {
        this.teamScoreLastGame = teamScoreLastGame;
    }

    public int getOppScoreLastGame() {
        return oppScoreLastGame;
    }

    public void setOppScoreLastGame(int oppScoreLastGame) {
        this.oppScoreLastGame = oppScoreLastGame;
    }

    public String getBowlGame() {
        return bowlGame;
    }

    public void setBowlGame(String bowlGame) {
        this.bowlGame = bowlGame;
    }

    public int getSeasonWins() {
        return seasonWins;
    }

    public void setSeasonWins(int seasonWins) {
        this.seasonWins = seasonWins;
    }

    public int getCareerWins() {
        return careerWins;
    }

    public void setCareerWins(int careerWins) {
        this.careerWins = careerWins;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getPreSeasonRank() {
        return preSeasonRank;
    }

    public void setPreSeasonRank(int preSeasonRank) {
        this.preSeasonRank = preSeasonRank;
    }

    public boolean isRankedPostSeason() {
        return rankedPostSeason;
    }

    public void setRankedPostSeason(boolean rankedPostSeason) {
        this.rankedPostSeason = rankedPostSeason;
    }

    public int getPostSeasonRank() {
        return postSeasonRank;
    }

    public void setPostSeasonRank(int postSeasonRank) {
        this.postSeasonRank = postSeasonRank;
    }

    public boolean isPlayingBowlGame() {
        return playingBowlGame;
    }

    public void setPlayingBowlGame(boolean playingBowlGame) {
        this.playingBowlGame = playingBowlGame;
    }

    public boolean isGoodOffSeason() {
        return goodOffSeason;
    }

    public void setGoodOffSeason(boolean goodOffSeason) {
        this.goodOffSeason = goodOffSeason;
    }

    public boolean isGoodWeeklyRandom() {
        return goodWeeklyRandom;
    }

    public void setGoodWeeklyRandom(boolean goodWeeklyRandom) {
        this.goodWeeklyRandom = goodWeeklyRandom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.coachName);
        hash = 97 * hash + this.qbStrength;
        hash = 97 * hash + this.rbStrength;
        hash = 97 * hash + this.wrStrength;
        hash = 97 * hash + this.dStrength;
        hash = 97 * hash + this.totalStrength;
        hash = 97 * hash + (this.goodOffSeason ? 1 : 0);
        hash = 97 * hash + (this.goodWeeklyRandom ? 1 : 0);
        hash = 97 * hash + (this.wonLastGame ? 1 : 0);
        hash = 97 * hash + this.teamScoreLastGame;
        hash = 97 * hash + this.oppScoreLastGame;
        hash = 97 * hash + (this.playingBowlGame ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.bowlGame);
        hash = 97 * hash + (this.nationalChamp ? 1 : 0);
        hash = 97 * hash + this.seasonWins;
        hash = 97 * hash + this.seasonLosses;
        hash = 97 * hash + this.careerWins;
        hash = 97 * hash + this.numberOfSeasons;
        hash = 97 * hash + this.preSeasonRank;
        hash = 97 * hash + (this.rankedPostSeason ? 1 : 0);
        hash = 97 * hash + this.postSeasonRank;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coach other = (Coach) obj;
        if (this.qbStrength != other.qbStrength) {
            return false;
        }
        if (this.rbStrength != other.rbStrength) {
            return false;
        }
        if (this.wrStrength != other.wrStrength) {
            return false;
        }
        if (this.dStrength != other.dStrength) {
            return false;
        }
        if (this.totalStrength != other.totalStrength) {
            return false;
        }
        if (this.goodOffSeason != other.goodOffSeason) {
            return false;
        }
        if (this.goodWeeklyRandom != other.goodWeeklyRandom) {
            return false;
        }
        if (this.wonLastGame != other.wonLastGame) {
            return false;
        }
        if (this.teamScoreLastGame != other.teamScoreLastGame) {
            return false;
        }
        if (this.oppScoreLastGame != other.oppScoreLastGame) {
            return false;
        }
        if (this.playingBowlGame != other.playingBowlGame) {
            return false;
        }
        if (this.nationalChamp != other.nationalChamp) {
            return false;
        }
        if (this.seasonWins != other.seasonWins) {
            return false;
        }
        if (this.seasonLosses != other.seasonLosses) {
            return false;
        }
        if (this.careerWins != other.careerWins) {
            return false;
        }
        if (this.numberOfSeasons != other.numberOfSeasons) {
            return false;
        }
        if (this.preSeasonRank != other.preSeasonRank) {
            return false;
        }
        if (this.rankedPostSeason != other.rankedPostSeason) {
            return false;
        }
        if (this.postSeasonRank != other.postSeasonRank) {
            return false;
        }
        if (!Objects.equals(this.coachName, other.coachName)) {
            return false;
        }
        if (!Objects.equals(this.bowlGame, other.bowlGame)) {
            return false;
        }
        return true;
    }

}
