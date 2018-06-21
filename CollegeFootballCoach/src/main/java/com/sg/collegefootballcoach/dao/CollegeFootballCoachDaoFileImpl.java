/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.dao;

import com.sg.collegefootballcoach.dto.Team;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachDaoFileImpl implements CollegeFootballCoachDao {

    public static final String TEAM_FILE = "teamlist.txt";
    public static final String DELIMITER = ",";
    private List<Team> teamList = new ArrayList<>();

    @Override
    public Team getTeam(int teamNumber) throws CollegeFootballCoachPersistenceException {
        loadTeams();
        Team team = teamList.get(teamNumber);
        return team;
    }

    private void loadTeams() throws CollegeFootballCoachPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TEAM_FILE)));
        } catch (FileNotFoundException e) {
            throw new CollegeFootballCoachPersistenceException(
                    "-_- Could not load library data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Team currentTeam = new Team(currentTokens[0]);
            currentTeam.setTeamStrength(Integer.parseInt(currentTokens[1]));

            teamList.add(currentTeam);
        }
        scanner.close();
    }

}
