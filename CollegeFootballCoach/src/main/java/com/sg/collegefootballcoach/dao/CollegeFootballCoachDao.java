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
public interface CollegeFootballCoachDao {

    Team getTeam(int teamNumber) throws CollegeFootballCoachPersistenceException;

}
