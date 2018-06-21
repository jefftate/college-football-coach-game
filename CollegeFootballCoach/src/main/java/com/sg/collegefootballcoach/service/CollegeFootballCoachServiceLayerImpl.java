/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.service;

import com.sg.collegefootballcoach.dao.CollegeFootballCoachPersistenceException;
import com.sg.collegefootballcoach.dao.CollegeFootballCoachDao;
import com.sg.collegefootballcoach.dto.Coach;
import com.sg.collegefootballcoach.dto.Team;
import java.util.Random;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachServiceLayerImpl implements CollegeFootballCoachServiceLayer {

    private CollegeFootballCoachDao dao;

    public CollegeFootballCoachServiceLayerImpl(CollegeFootballCoachDao dao) {
        this.dao = dao;
    }

    @Override
    public Coach setStats(Coach coach) {
        Coach setCoach = coach;
        Random random = new Random();
        int qbStrength = random.nextInt(51) + 25;
        int rbStrength = random.nextInt(51) + 25;
        int wrStrength = random.nextInt(51) + 25;
        int dStrength = random.nextInt(51) + 25;
        int totalStrength = qbStrength + rbStrength + wrStrength + dStrength;

        setCoach.setQbStrength(qbStrength);
        setCoach.setRbStrength(rbStrength);
        setCoach.setWrStrength(wrStrength);
        setCoach.setdStrength(dStrength);
        setCoach.setTotalStrength(totalStrength);

        return setCoach;
    }

    @Override
    public Coach calculateRecruiting(Coach coach, int selection) {
        Coach coachUpdated = coach;
        int startingStrength = 0;
        int endingStrength = 0;

        switch (selection) {
            case 1:
                startingStrength = coach.getQbStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 4;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 4;
                } else {
                    endingStrength = startingStrength;
                }
                coachUpdated.setQbStrength(endingStrength);
                if (coachUpdated.getQbStrength() > 100) {
                    coachUpdated.setQbStrength(100);
                }
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
            case 2:
                startingStrength = coach.getRbStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 4;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 4;
                } else {
                    endingStrength = startingStrength;
                }
                coachUpdated.setRbStrength(endingStrength);
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
            case 3:
                startingStrength = coach.getWrStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 4;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 4;
                } else {
                    endingStrength = startingStrength;
                }
                coachUpdated.setWrStrength(endingStrength);
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
            case 4:
                startingStrength = coach.getdStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 4;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 4;
                } else {
                    endingStrength = startingStrength;
                }
                coachUpdated.setdStrength(endingStrength);
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
        }

        return coachUpdated;
    }

    @Override
    public Coach runOffSeasonRandoms(Coach coach) {
        Random random = new Random();
        Coach coach1 = coach;
        int result = random.nextInt(2) + 1;
        if (result == 1) {
            coach1.setGoodOffSeason(false);
            coach1.setQbStrength(coach.getQbStrength() - 1);
            coach1.setRbStrength(coach.getRbStrength() - 1);
            coach1.setWrStrength(coach.getWrStrength() - 1);
            coach1.setdStrength(coach.getdStrength() - 1);
            coach1.setTotalStrength(coach1.getQbStrength() + coach1.getRbStrength() + coach1.getWrStrength() + coach1.getdStrength());
        } else {
            coach1.setGoodOffSeason(true);
            coach1.setQbStrength(coach.getQbStrength() + 1);
            coach1.setRbStrength(coach.getRbStrength() + 1);
            coach1.setWrStrength(coach.getWrStrength() + 1);
            coach1.setdStrength(coach.getdStrength() + 1);
            coach1.setTotalStrength(coach1.getQbStrength() + coach1.getRbStrength() + coach1.getWrStrength() + coach1.getdStrength());
        }

        return coach1;
    }

    @Override
    public Coach setPreSeasonRank(Coach coach) {
        Random random = new Random();
        Coach coachRanked = coach;
        int strength = coach.getTotalStrength();
        int rank = 0;

        if (strength > 228) {
            if (strength > 300) {
                rank = random.nextInt(2) + 1;
            } else if (strength > 260) {
                rank = random.nextInt(8) + 3;
            } else if (strength > 228) {
                rank = random.nextInt(15) + 11;
            }
            coachRanked.setPreSeasonRank(rank);
        }

        return coachRanked;
    }

    @Override
    public Coach runWeeklyTraining(Coach coach, int trainingChoice) {
        Coach coachUpdated = coach;
        int startingStrength = 0;
        int endingStrength = 0;

        switch (trainingChoice) {
            case 1:
                startingStrength = coach.getQbStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 2;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 3;
                } else {
                    endingStrength = startingStrength + 1;
                }
                coachUpdated.setQbStrength(endingStrength);
                if (coachUpdated.getQbStrength() > 100) {
                    coachUpdated.setQbStrength(100);
                }
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
            case 2:
                startingStrength = coach.getRbStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 2;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 3;
                } else {
                    endingStrength = startingStrength + 1;
                }
                coachUpdated.setRbStrength(endingStrength);
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
            case 3:
                startingStrength = coach.getWrStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 2;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 3;
                } else {
                    endingStrength = startingStrength + 1;
                }
                coachUpdated.setWrStrength(endingStrength);
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
            case 4:
                startingStrength = coach.getdStrength();
                if (startingStrength < 45) {
                    endingStrength = startingStrength + 2;
                } else if (startingStrength > 65) {
                    endingStrength = startingStrength - 3;
                } else {
                    endingStrength = startingStrength + 1;
                }
                coachUpdated.setdStrength(endingStrength);
                coachUpdated.setTotalStrength(coachUpdated.getQbStrength() + coachUpdated.getRbStrength() + coachUpdated.getWrStrength() + coachUpdated.getdStrength());
                break;
        }

        return coachUpdated;
    }

    @Override
    public Coach runWeeklyRandoms(Coach coach) {
        Random random = new Random();
        Coach coach1 = coach;
        int result = random.nextInt(2) + 1;
        if (result == 1) {
            coach1.setGoodWeeklyRandom(false);
            coach1.setQbStrength(coach.getQbStrength() - 1);
            coach1.setRbStrength(coach.getRbStrength() - 1);
            coach1.setWrStrength(coach.getWrStrength() - 1);
            coach1.setdStrength(coach.getdStrength() - 1);
            coach1.setTotalStrength(coach1.getQbStrength() + coach1.getRbStrength() + coach1.getWrStrength() + coach1.getdStrength());
        } else {
            coach1.setGoodWeeklyRandom(true);
            coach1.setQbStrength(coach.getQbStrength() + 1);
            coach1.setRbStrength(coach.getRbStrength() + 1);
            coach1.setWrStrength(coach.getWrStrength() + 1);
            coach1.setdStrength(coach.getdStrength() + 1);
            coach1.setTotalStrength(coach1.getQbStrength() + coach1.getRbStrength() + coach1.getWrStrength() + coach1.getdStrength());
        }

        return coach1;
    }

    @Override
    public Team getTeam(int teamNumber) throws CollegeFootballCoachPersistenceException {
        return dao.getTeam(teamNumber);
    }

    @Override
    public Coach playGame(Coach coach1, Team currentTeam) {
        Random random = new Random();
        Coach updatedCoach = coach1;
        int ourStrength = updatedCoach.getTotalStrength();
        int oppStrength = currentTeam.getTeamStrength();
        int dif = ourStrength - oppStrength;
        int toCheck = 1;
        int result;
        boolean weWin;

        if (dif >= 200) {
            result = random.nextInt(100) + 1;
            if (toCheck == result) {
                weWin = false;
            } else {
                weWin = true;
            }
        } else if (dif < 200 && dif >= 100) {
            result = random.nextInt(20) + 1;
            if (toCheck == result) {
                weWin = false;
            } else {
                weWin = true;
            }
        } else if (dif < 100 && dif >= 60) {
            result = random.nextInt(8) + 1;
            if (toCheck == result) {
                weWin = false;
            } else {
                weWin = true;
            }

        } else if (dif < 60 && dif >= 40) {
            result = random.nextInt(4) + 1;
            if (toCheck == result) {
                weWin = false;
            } else {
                weWin = true;
            }
        } else if (dif < 40 && dif >= 20) {
            toCheck = 1;
            result = random.nextInt(3) + 1;
            if (toCheck == result) {
                weWin = false;
            } else {
                weWin = true;
            }
        } else if (dif < 20 && dif >= -20) {
            result = random.nextInt(2) + 1;
            if (toCheck == result) {
                weWin = false;
            } else {
                weWin = true;
            }
        } else if (dif < -20 && dif >= -40) {
            toCheck = 1;
            result = random.nextInt(3) + 1;
            if (toCheck == result) {
                weWin = true;
            } else {
                weWin = false;
            }
        } else if (dif < -40 && dif >= -60) {
            result = random.nextInt(4) + 1;
            if (toCheck == result) {
                weWin = true;
            } else {
                weWin = false;
            }

        } else if (dif < -60 && dif >= -100) {
            result = random.nextInt(8) + 1;
            if (toCheck == result) {
                weWin = true;
            } else {
                weWin = false;
            }

        } else if (dif < -100 && dif >= -200) {
            result = random.nextInt(20) + 1;
            if (toCheck == result) {
                weWin = true;
            } else {
                weWin = false;
            }

        } else {
            result = random.nextInt(100) + 1;
            if (toCheck == result) {
                weWin = true;
            } else {
                weWin = false;
            }
        }

        updatedCoach.setWonLastGame(weWin);
        if (weWin) {
            int currentSeasonWins = updatedCoach.getSeasonWins();
            int currentCareerWins = updatedCoach.getCareerWins();
            updatedCoach.setSeasonWins(currentSeasonWins + 1);
            updatedCoach.setCareerWins(currentCareerWins + 1);
        } else {
            int currentSeasonLosses = updatedCoach.getSeasonLosses();
            updatedCoach.setSeasonLosses(currentSeasonLosses + 1);
        }

        int ourScore;
        int oppScore;
        int addToScore = random.nextInt(20) + 2;

        if (weWin) {
            oppScore = random.nextInt(30) + 2;
            ourScore = oppScore + addToScore;
        } else {
            ourScore = random.nextInt(30) + 2;
            oppScore = ourScore + addToScore;
        }

        updatedCoach.setTeamScoreLastGame(ourScore);
        updatedCoach.setOppScoreLastGame(oppScore);
        return updatedCoach;
    }

    @Override
    public Coach checkIfBowlGame(Coach coach) {
        Coach updatedCoach = coach;
        if (coach.getSeasonWins() >= 6) {
            updatedCoach.setPlayingBowlGame(true);
        } else {
            updatedCoach.setPlayingBowlGame(false);
        }

        int currentSeasons = updatedCoach.getNumberOfSeasons();
        updatedCoach.setNumberOfSeasons(currentSeasons + 1);

        return updatedCoach;
    }

    @Override
    public Coach playBowlGame(Coach coach) {
        Coach updatedCoach = coach;
        int wins = updatedCoach.getSeasonWins();
        Random random = new Random();

        if (wins >= 11) {
            coach.setBowlGame("National Championship");
        } else if (wins == 10) {
            coach.setBowlGame("Rose Bowl");
        } else if (wins == 9) {
            coach.setBowlGame("Sun Bowl");
        } else if (wins == 8) {
            coach.setBowlGame("Alamo Bowl");
        } else if (wins == 7) {
            coach.setBowlGame("Cactus Bowl");
        } else {
            coach.setBowlGame("Arizona Bowl");
        }

        boolean weWin;
        int toCheck = 1;
        int result = random.nextInt(2) + 1;
        if (toCheck == result) {
            weWin = false;
        } else {
            weWin = true;
        }

        updatedCoach.setWonLastGame(weWin);
        if (weWin) {
            int currentSeasonWins = updatedCoach.getSeasonWins();
            int currentCareerWins = updatedCoach.getCareerWins();
            updatedCoach.setSeasonWins(currentSeasonWins + 1);
            updatedCoach.setCareerWins(currentCareerWins + 1);
        } else {
            int currentSeasonLosses = updatedCoach.getSeasonLosses();
            updatedCoach.setSeasonWins(currentSeasonLosses + 1);
        }

        int ourScore;
        int oppScore;
        int addToScore = random.nextInt(20) + 2;

        if (weWin) {
            oppScore = random.nextInt(30);
            ourScore = oppScore + addToScore;
        } else {
            ourScore = random.nextInt(30);
            oppScore = ourScore + addToScore;
        }

        if (wins >= 11 && weWin) {
            updatedCoach.setNationalChamp(true);
        } else {
            updatedCoach.setNationalChamp(false);
        }

        updatedCoach.setTeamScoreLastGame(ourScore);
        updatedCoach.setOppScoreLastGame(oppScore);

        return updatedCoach;
    }

    @Override
    public Coach setPostSeasonRank(Coach coach) {
        Random random = new Random();
        Coach updatedCoach = coach;
        int wins = updatedCoach.getSeasonWins();
        int rank;

        if (wins >= 9) {
            if (updatedCoach.isNationalChamp()) {
                rank = 1;
            } else if (wins == 12) {
                rank = 2;
            } else if (wins == 11) {
                rank = random.nextInt(5) + 3;
            } else if (wins == 10) {
                rank = random.nextInt(9) + 8;
            } else {
                rank = random.nextInt(9) + 17;
            }
            updatedCoach.setPostSeasonRank(rank);
        }
        return updatedCoach;
    }

    @Override
    public Coach resetSeasonStats(Coach coach) {
        Coach resetCoach = coach;

        resetCoach.setSeasonWins(0);
        resetCoach.setSeasonLosses(0);

        return resetCoach;
    }
}
