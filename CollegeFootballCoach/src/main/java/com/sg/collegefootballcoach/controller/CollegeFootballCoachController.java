/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.controller;

import com.sg.collegefootballcoach.dao.CollegeFootballCoachPersistenceException;
import com.sg.collegefootballcoach.dto.Coach;
import com.sg.collegefootballcoach.dto.Team;
import com.sg.collegefootballcoach.ui.CollegeFootballCoachView;
import com.sg.collegefootballcoach.service.CollegeFootballCoachServiceLayer;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachController {

    private CollegeFootballCoachView view;
    private CollegeFootballCoachServiceLayer service;

    public CollegeFootballCoachController(CollegeFootballCoachServiceLayer service, CollegeFootballCoachView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean playAgain;
        boolean keepPlaying;

        view.displayWelcome();

        do {
            Coach coach = createCoach();
            do {
                try {
                    coach = playSeason(coach);
                } catch (CollegeFootballCoachPersistenceException e) {
                    view.displayErrorMessage(e.getMessage());
                }
                keepPlaying = view.displayKeepPlayingCheck();
            } while (keepPlaying);
            playAgain = view.displayPlayAgainCheck();
        } while (playAgain);
    }

    private Coach createCoach() {
        Coach coach = view.displayCreateCoach();
        Coach coachWithStats = service.setStats(coach);
        view.displayStartingInfo(coach);
        return coachWithStats;
    }

    private Coach playSeason(Coach coach) throws CollegeFootballCoachPersistenceException {
//        Handles offseason - recruiting and randoms
        Coach coach1 = doRecruiting(coach);
        coach1 = service.runOffSeasonRandoms(coach1);
        view.displayOffSeasonRandoms(coach1);

        coach1 = service.setPreSeasonRank(coach1);
        view.displayPreSeasonDescription(coach1);

//        Season loop - repeats for each weekly game
        for (int gameWeek = 0; gameWeek < 12; gameWeek++) {

//            Weekly training
            int trainingChoice = view.displaySelectTraining();
            int beforeStrength = coach1.getTotalStrength();
            coach1 = service.runWeeklyTraining(coach1, trainingChoice);
            int afterStrength = coach1.getTotalStrength();
            if (afterStrength > beforeStrength) {
                view.displayTrainingSuccess();
            } else {
                view.displayTrainingFail();
            }

//            Weekly random occurrences
            coach1 = service.runWeeklyRandoms(coach1);
            view.displayAfterWeeklyRandoms(coach1);

//            Actual weekly game
            Team currentTeam = service.getTeam(gameWeek);
            view.displayPreGame(coach1, currentTeam, gameWeek);
            coach1 = service.playGame(coach1, currentTeam);
            view.displayPostGame(coach1);
        }

//        Handles possible bowl game
        coach1 = service.checkIfBowlGame(coach1);
        boolean playBowl = coach1.isPlayingBowlGame();
        if (playBowl) {
            coach1 = service.playBowlGame(coach1);
            view.displayBowlResults(coach1);
        }

//        Season results and reset of season wins and losses
        coach1 = service.setPostSeasonRank(coach1);
        view.displayEndOfSeasonResults(coach1);
        coach1 = service.resetSeasonStats(coach1);

        return coach1;
    }

    private Coach doRecruiting(Coach coach) {
        int selection = view.displayRecruiting1();
        int startingStrength = coach.getTotalStrength();

        Coach coachR = coach;
        coachR = service.calculateRecruiting(coachR, selection);

        selection = view.displayRecruiting2();
        coachR = service.calculateRecruiting(coachR, selection);

        selection = view.displayRecruiting3();
        coachR = service.calculateRecruiting(coachR, selection);

        int endingStrength = coachR.getTotalStrength();

        if (startingStrength > endingStrength) {
            view.displayRecruitingFail();
        }
        if (startingStrength < endingStrength) {
            view.displayRecruitingSuccess();
        }
        if (startingStrength == endingStrength) {
            view.displayRecruitingNoChange();
        }

        return coachR;
    }

}
