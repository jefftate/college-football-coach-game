/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.ui;

import com.sg.collegefootballcoach.dto.Coach;
import com.sg.collegefootballcoach.dto.Team;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachView {

    private UserIO io;

    public CollegeFootballCoachView(UserIO io) {
        this.io = io;
    }

    public void displayWelcome() {
        io.print("");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("Welcome to College Football Coach!");
        io.print("");
        io.print("You will experience the career of a college football coach as you lead");
        io.print("your team over the course of multiple seasons. Focus on improving your");
        io.print("team's weaknesses through recruiting and training to have the best");
        io.print("chance at building a dynasty!");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.readString("Please press enter to continue.");
    }

    public boolean displayKeepPlayingCheck() {
        io.print("");
        io.print("Would you like to continue coaching your team for another season? Please enter");
        boolean runAgain = true;
        String answer;
        String toCompare;
        do {
            answer = io.readString("Yes or No:");
            toCompare = answer.toLowerCase();
            if (toCompare.equals("yes") || toCompare.equals("no")) {
                runAgain = false;
            } else {
                io.print("Error: Must enter 'Yes' or 'No'");
            }
        } while (runAgain);

        if (toCompare.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean displayPlayAgainCheck() {
        io.print("");
        io.print("Would you like to start a new career or quit the game? Please enter");
        boolean runAgain = true;
        String answer;
        String toCompare;
        do {
            answer = io.readString("Yes or No ('No' to quit):");
            toCompare = answer.toLowerCase();
            if (toCompare.equals("yes") || toCompare.equals("no")) {
                runAgain = false;
            } else {
                io.print("Error: Must enter 'Yes' or 'No'");
            }
        } while (runAgain);

        if (toCompare.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public Coach displayCreateCoach() {
        io.print("");
        io.print("It's time to get your career started!");
        String coachName = "Coach " + io.readString("Please enter your last name:");
        Coach newCoach = new Coach(coachName);
        return newCoach;
    }

    public void displayStartingInfo(Coach coach) {
        io.print("");
        io.print("Hi " + coach.getCoachName() + "! Your team is excited to have new leadership.");
        if (coach.getTotalStrength() > 228) {
            io.print("Luckily you are starting with a very strong team. Below are the specific ratings of your team:");
        }
        if (coach.getTotalStrength() > 171 && coach.getTotalStrength() < 229) {
            io.print("Your team is fairly average. With the right coach they might have a shot at a great season.");
            io.print("Below are the specific ratings of your team:");
        }
        if (coach.getTotalStrength() < 172) {
            io.print("Unfortunately, you are starting out with a weak team. The team is going to need a lot of great coaching");
            io.print("in order to improve. Below are the specific ratings of your team:");
        }
        if (coach.getQbStrength() > 65) {
            io.print("QB: Strong");
        } else if (coach.getQbStrength() > 44 && coach.getQbStrength() < 66) {
            io.print("QB: Average");
        } else {
            io.print("QB: Weak");
        }

        if (coach.getRbStrength() > 65) {
            io.print("RB: Strong");
        } else if (coach.getRbStrength() > 44 && coach.getRbStrength() < 66) {
            io.print("RB: Average");
        } else {
            io.print("RB: Weak");
        }

        if (coach.getWrStrength() > 65) {
            io.print("WR: Strong");
        } else if (coach.getWrStrength() > 44 && coach.getWrStrength() < 66) {
            io.print("WR: Average");
        } else {
            io.print("WR: Weak");
        }

        if (coach.getdStrength() > 65) {
            io.print("Defense: Strong");
        } else if (coach.getdStrength() > 44 && coach.getdStrength() < 66) {
            io.print("Defense: Average");
        } else {
            io.print("Defense: Weak");
        }
        io.readString("Please press enter to continue.");
    }

    public int displayRecruiting1() {
        io.print("");
        io.print("It's your first recruiting trip of the year. Enjoy your time in the midwest!");
        io.print("You need to recruit new talent to improve your team. You can focus on one area");
        io.print("during this trip. Your options are below:");
        io.print("1. QB");
        io.print("2. RB");
        io.print("3. WR");
        io.print("4. Defense");
        int selection = io.readInt("What's your focus going to be? Enter the number of your choice:", 1, 4);

        return selection;
    }

    public int displayRecruiting2() {
        io.print("");
        io.print("It's your second recruiting trip of the year. Enjoy your time on the west coast!");
        io.print("You need to recruit new talent to improve your team. You can focus on one area");
        io.print("during this trip. Your options are below:");
        io.print("1. QB");
        io.print("2. RB");
        io.print("3. WR");
        io.print("4. Defense");
        int selection = io.readInt("What's your focus going to be? Enter the number of your choice:", 1, 4);

        return selection;
    }

    public int displayRecruiting3() {
        io.print("");
        io.print("It's your final recruiting trip of the year. Enjoy your time in the south!");
        io.print("You need to recruit new talent to improve your team. You can focus on one area");
        io.print("during this trip. Your options are below:");
        io.print("1. QB");
        io.print("2. RB");
        io.print("3. WR");
        io.print("4. Defense");
        int selection = io.readInt("What's your focus going to be? Enter the number of your choice:", 1, 4);

        return selection;
    }

    public void displayRecruitingFail() {
        io.print("");
        io.print("It looks like you failed to focus on improving your team's weaknesses. This was");
        io.print("not a successful year for recruiting.");
        io.readString("Please press enter to continue.");
    }

    public void displayRecruitingSuccess() {
        io.print("");
        io.print("It looks like you were able to sign recruits to help improve your team's weakest areas.");
        io.print("Your team will benefit from your successful recruiting season.");
        io.readString("Please press enter to continue.");
    }

    public void displayRecruitingNoChange() {
        io.print("");
        io.print("It was a modest year for recruiting. Your team did not gain much from recruiting, but");
        io.print("at least some of the recruits will help fill holes left by graduating players. ");
        io.readString("Please press enter to continue.");
    }

    public void displayOffSeasonRandoms(Coach coach) {
        io.print("");
        if (coach.isGoodOffSeason()) {
            io.print("This was a lucky offseason. You snagged some great transfer players and your team will be better");
            io.print("this upcoming season as a result.");
            io.readString("Please press enter to continue.");
        } else {
            io.print("This was an unlucky offseason. You has some key players transfer to other schools and your team");
            io.print("will not be as strong this upcoming season as a result.");
            io.readString("Please press enter to continue.");
        }
    }

    public void displayPreSeasonDescription(Coach coach) {
        io.print("");
        io.print("The season is about to get underway, " + coach.getCoachName() + ". Below is the status of your team:");
        if (coach.getTotalStrength() > 228) {
            io.print("Your team is quite strong and is expected to have an excellent season. Your team is ranked in the top 25");
            io.print("preseason poll. Your rank is #" + coach.getPreSeasonRank() + " in the country. Below are the specific ratings of your team:");
        }
        if (coach.getTotalStrength() > 171 && coach.getTotalStrength() < 229) {
            io.print("Your team is expected to have a decent season. You didn't manage to make the preseaon rankings.");
            io.print("Below are the specific ratings of your team:");
        }
        if (coach.getTotalStrength() < 172) {
            io.print("It looks like it could be a tough year for your team. As expected you are not in the preseason rankings");
            io.print("Below are the specific ratings of your team:");
        }
        if (coach.getQbStrength() > 65) {
            io.print("QB: Strong");
        } else if (coach.getQbStrength() > 44 && coach.getQbStrength() < 66) {
            io.print("QB: Average");
        } else {
            io.print("QB: Weak");
        }

        if (coach.getRbStrength() > 65) {
            io.print("RB: Strong");
        } else if (coach.getRbStrength() > 44 && coach.getRbStrength() < 66) {
            io.print("RB: Average");
        } else {
            io.print("RB: Weak");
        }

        if (coach.getWrStrength() > 65) {
            io.print("WR: Strong");
        } else if (coach.getWrStrength() > 44 && coach.getWrStrength() < 66) {
            io.print("WR: Average");
        } else {
            io.print("WR: Weak");
        }

        if (coach.getdStrength() > 65) {
            io.print("Defense: Strong");
        } else if (coach.getdStrength() > 44 && coach.getdStrength() < 66) {
            io.print("Defense: Average");
        } else {
            io.print("Defense: Weak");
        }
        io.readString("Please press enter to continue.");
    }

    public int displaySelectTraining() {
        io.print("");
        io.print("Time to select which of the areas listed below you will focus on during practice this week.");
        io.print("1. QB");
        io.print("2. RB");
        io.print("3. WR");
        io.print("4. Defense");
        int selection = io.readInt("What's your focus going to be? Enter the number of your choice:", 1, 4);
        return selection;
    }

    public void displayTrainingSuccess() {
        io.print("");
        io.print("Your team has improved after a week of focusing on your team's weaknesses in training!");
        io.readString("Please press enter to continue.");
    }

    public void displayTrainingFail() {
        io.print("");
        io.print("Your team has gotten weaker as a result of focusing too much on areas where your team");
        io.print("is already strong!");
        io.readString("Please press enter to continue.");
    }

    public void displayAfterWeeklyRandoms(Coach coach) {
        io.print("");
        if (coach.isGoodWeeklyRandom()) {
            io.print("This was a lucky week. One of your best players really improved in practice and your team will be");
            io.print("better as a result.");
            io.readString("Please press enter to continue.");
        } else {
            io.print("This was a unlucky week. One of your best players was injured during practice and will be out for much");
            io.print("of the season. Your team will be weaker as a result.");
            io.readString("Please press enter to continue.");
        }
    }

    public void displayPreGame(Coach coach1, Team currentTeam, int gameWeek) {
        String gameWeekS = Integer.toString(gameWeek + 1);

        int ourStrength = coach1.getTotalStrength();
        int oppStrength = currentTeam.getTeamStrength();

        if ((ourStrength - oppStrength) > 20) {
            io.print("");
            io.print("It's week " + gameWeekS + " of the season and you are playing " + currentTeam.getTeamName() + ".");
            io.print("You are favored in this matchup, so hopefully your team can take home an easy win.");
            io.readString("Please press enter to continue.");
        } else if ((ourStrength - oppStrength) < -20) {
            io.print("");
            io.print("It's week " + gameWeekS + " of the season and you are playing " + currentTeam.getTeamName() + ".");
            io.print("Your opponent is favored in this matchup. Your team will need to play their best for a chance at the upset.");
            io.readString("Please press enter to continue.");
        } else {
            io.print("");
            io.print("It's week " + gameWeekS + " of the season and you are playing " + currentTeam.getTeamName() + ".");
            io.print("Both teams are evenly matched, so this game could go either way.");
            io.readString("Please press enter to continue.");
        }
    }

    public void displayPostGame(Coach coach) {
        if (coach.isWonLastGame()) {
            io.print("");
            io.print("Your team won " + coach.getTeamScoreLastGame() + " - " + coach.getOppScoreLastGame() + ". Congratulations!");
            io.print("Your record for the season is now " + coach.getSeasonWins() + " - " + coach.getSeasonLosses() + ".");
            io.readString("Please press enter to continue.");
        } else {
            io.print("Your team lost, with the other team beating you " + coach.getOppScoreLastGame() + " - " + coach.getTeamScoreLastGame() + ".");
            io.print("Your record for the season is now " + coach.getSeasonWins() + " - " + coach.getSeasonLosses() + ".");
            io.readString("Please press enter to continue.");
        }
    }

    public void displayBowlResults(Coach coach) {
        if ((coach.getBowlGame()).equals("National Championship")) {

            io.print("");
            io.print("After an amazing season your team has won a spot in the National Championship!");
            io.print("A combination of great coaching and outstanding players has earned your team this opportunity.");
            io.readString("Please press enter to continue.");
            if (coach.isWonLastGame()) {
                io.print("");
                io.print("Your team won the National Championship " + coach.getTeamScoreLastGame() + " - " + coach.getOppScoreLastGame() + ". Congratulations!");
                io.print("This National Championship will certainly help cement your legacy.");
                io.readString("Please press enter to continue.");
            } else {
                io.print("Your team lost, with the other team beating you " + coach.getOppScoreLastGame() + " - " + coach.getTeamScoreLastGame() + ".");
                io.print("It's hard to lose such an important game, but this was still a great year for your team.");
                io.readString("Please press enter to continue.");
            }
        } else {
            io.print("");
            io.print("After a successful season your team has earned the chance to play in the " + coach.getBowlGame() + "!");
            io.readString("Please press enter to continue.");
            if (coach.isWonLastGame()) {
                io.print("");
                io.print("Your team won " + coach.getTeamScoreLastGame() + " - " + coach.getOppScoreLastGame() + ". Congratulations!");
                io.readString("Please press enter to continue.");
            } else {
                io.print("Your team lost, with the other team beating you " + coach.getOppScoreLastGame() + " - " + coach.getTeamScoreLastGame() + ".");
                io.readString("Please press enter to continue.");
            }
        }
    }

    public void displayEndOfSeasonResults(Coach coach) {
        io.print("");
        io.print("The season is now over!");
        io.print("You finished the season with a record of " + coach.getSeasonWins() + " - " + coach.getSeasonLosses() + ".");
        if (coach.getSeasonWins() >= 9) {
            io.print("Congratulations on your team finishing the season ranked #" + coach.getPostSeasonRank() + " in the country!");
        }
        if (coach.getNumberOfSeasons() > 1) {
            io.print("After " + coach.getNumberOfSeasons() + " seasons you have now have " + coach.getCareerWins() + " career wins.");
        } else {
            io.print("After " + coach.getNumberOfSeasons() + " season you have now have " + coach.getCareerWins() + " career wins.");
        }
        io.readString("Please press enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
