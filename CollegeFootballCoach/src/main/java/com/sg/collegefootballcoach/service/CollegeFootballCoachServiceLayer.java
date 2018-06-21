/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.service;

import com.sg.collegefootballcoach.dao.CollegeFootballCoachPersistenceException;
import com.sg.collegefootballcoach.dto.Coach;
import com.sg.collegefootballcoach.dto.Team;

/**
 *
 * @author jefftate
 */
public interface CollegeFootballCoachServiceLayer {

    Coach setStats(Coach coach);

    Coach calculateRecruiting(Coach coach, int selection);

    Coach runOffSeasonRandoms(Coach coach);

    Coach setPreSeasonRank(Coach coach);

    Coach runWeeklyTraining(Coach coach, int trainingChoice);

    Coach runWeeklyRandoms(Coach coach);

    Team getTeam(int teamNumber) throws CollegeFootballCoachPersistenceException;

    Coach playGame(Coach coach1, Team currentTeam);

    Coach checkIfBowlGame(Coach coach);

    Coach playBowlGame(Coach coach);

    Coach setPostSeasonRank(Coach coach);

    Coach resetSeasonStats(Coach coach);

}
