/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.dao;

import com.sg.collegefootballcoach.dto.Team;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachDaoStubImpl implements CollegeFootballCoachDao {

    Team onlyTeam;

    public CollegeFootballCoachDaoStubImpl() {
        onlyTeam = new Team("Alaska");
        onlyTeam.setTeamStrength(200);
    }

    @Override
    public Team getTeam(int teamNumber) throws CollegeFootballCoachPersistenceException {
        return onlyTeam;
    }

}
