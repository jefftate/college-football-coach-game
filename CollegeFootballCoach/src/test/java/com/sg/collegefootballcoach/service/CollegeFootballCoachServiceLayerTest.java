/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.service;

import com.sg.collegefootballcoach.dto.Coach;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachServiceLayerTest {

    CollegeFootballCoachServiceLayer service;

    public CollegeFootballCoachServiceLayerTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("serviceLayer", CollegeFootballCoachServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetStats() {
        Coach coach = new Coach("Test");

        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
        assertTrue(100 <= service.setStats(coach).getTotalStrength() && service.setStats(coach).getTotalStrength() <= 300);
    }

    @Test
    public void testCalculateRecruiting() {
        Coach coach = new Coach("Test");
        coach.setQbStrength(10);
        coach.setRbStrength(50);
        coach.setWrStrength(50);
        coach.setdStrength(80);
        coach.setTotalStrength(coach.getQbStrength() + coach.getRbStrength() + coach.getWrStrength() + coach.getdStrength());

        assertEquals(service.calculateRecruiting(coach, 1).getTotalStrength(), 194);
        assertEquals(service.calculateRecruiting(coach, 2).getTotalStrength(), 194);
        assertEquals(service.calculateRecruiting(coach, 3).getTotalStrength(), 194);
        assertEquals(service.calculateRecruiting(coach, 4).getTotalStrength(), 190);
    }

    @Test
    public void testRunOffSeasonRandoms() {
        Coach coach = new Coach("Test");
        coach.setQbStrength(10);
        coach.setRbStrength(50);
        coach.setWrStrength(50);
        coach.setdStrength(80);
        coach.setTotalStrength(coach.getQbStrength() + coach.getRbStrength() + coach.getWrStrength() + coach.getdStrength());

        Coach testCoach = service.runOffSeasonRandoms(coach);
        if (testCoach.isGoodOffSeason()) {
            assertEquals(testCoach.getTotalStrength(), 194);
        } else {
            assertEquals(testCoach.getTotalStrength(), 186);
        }
    }

    @Test
    public void testSetPreSeasonRank() {
        Coach coach = new Coach("Test");
        coach.setQbStrength(60);
        coach.setRbStrength(60);
        coach.setWrStrength(60);
        coach.setdStrength(60);
        coach.setTotalStrength(coach.getQbStrength() + coach.getRbStrength() + coach.getWrStrength() + coach.getdStrength());

        Coach testCoach = service.setPreSeasonRank(coach);

        Coach coach2 = new Coach("Test2");
        coach2.setQbStrength(70);
        coach2.setRbStrength(70);
        coach2.setWrStrength(70);
        coach2.setdStrength(70);
        coach2.setTotalStrength(coach2.getQbStrength() + coach2.getRbStrength() + coach2.getWrStrength() + coach2.getdStrength());

        Coach testCoach2 = service.setPreSeasonRank(coach2);

        Coach coach3 = new Coach("Test3");
        coach3.setQbStrength(100);
        coach3.setRbStrength(100);
        coach3.setWrStrength(100);
        coach3.setdStrength(100);
        coach3.setTotalStrength(coach3.getQbStrength() + coach3.getRbStrength() + coach3.getWrStrength() + coach3.getdStrength());

        Coach testCoach3 = service.setPreSeasonRank(coach3);

        assertTrue(11 <= testCoach.getPreSeasonRank() && testCoach.getPreSeasonRank() <= 26);
        assertTrue(3 <= testCoach2.getPreSeasonRank() && testCoach2.getPreSeasonRank() <= 10);
        assertTrue(1 <= testCoach3.getPreSeasonRank() && testCoach3.getPreSeasonRank() <= 2);
    }

    @Test
    public void testRunWeeklyTraining() {
        Coach coach = new Coach("Test");
        coach.setQbStrength(10);
        coach.setRbStrength(50);
        coach.setWrStrength(50);
        coach.setdStrength(80);
        coach.setTotalStrength(coach.getQbStrength() + coach.getRbStrength() + coach.getWrStrength() + coach.getdStrength());

        assertEquals(service.runWeeklyTraining(coach, 1).getTotalStrength(), 192);
        assertEquals(service.runWeeklyTraining(coach, 2).getTotalStrength(), 193);
        assertEquals(service.runWeeklyTraining(coach, 3).getTotalStrength(), 194);
        assertEquals(service.runWeeklyTraining(coach, 4).getTotalStrength(), 191);
    }

    @Test
    public void testRunWeeklyRandoms() {
        Coach coach = new Coach("Test");
        coach.setQbStrength(10);
        coach.setRbStrength(50);
        coach.setWrStrength(50);
        coach.setdStrength(80);
        coach.setTotalStrength(coach.getQbStrength() + coach.getRbStrength() + coach.getWrStrength() + coach.getdStrength());

        Coach testCoach = service.runWeeklyRandoms(coach);
        if (testCoach.isGoodWeeklyRandom()) {
            assertEquals(testCoach.getTotalStrength(), 194);
        } else {
            assertEquals(testCoach.getTotalStrength(), 186);
        }
    }

    @Test
    public void testCheckIfBowlGame() {
        Coach coach = new Coach("Test");
        coach.setSeasonWins(3);

        Coach coach2 = new Coach("Test2");
        coach2.setSeasonWins(6);

        Coach coach3 = new Coach("Test3");
        coach3.setSeasonWins(9);

        assertFalse(service.checkIfBowlGame(coach).isPlayingBowlGame());
        assertTrue(service.checkIfBowlGame(coach2).isPlayingBowlGame());
        assertTrue(service.checkIfBowlGame(coach3).isPlayingBowlGame());
    }

    @Test
    public void playBowlGame() {
        Coach coach = new Coach("Test");
        coach.setSeasonWins(11);

        Coach coach2 = new Coach("Test2");
        coach2.setSeasonWins(8);

        Coach coach3 = new Coach("Test3");
        coach3.setSeasonWins(6);

        assertTrue((service.playBowlGame(coach).getBowlGame()).equals("National Championship"));
        assertTrue((service.playBowlGame(coach2).getBowlGame()).equals("Alamo Bowl"));
        assertTrue((service.playBowlGame(coach3).getBowlGame()).equals("Arizona Bowl"));
    }

    @Test
    public void testSetPostSeasonRank() {
        Coach coach = new Coach("Test");
        coach.setSeasonWins(13);
        coach.setNationalChamp(true);

        Coach coach2 = new Coach("Test2");
        coach2.setSeasonWins(12);
        coach2.setNationalChamp(false);

        Coach coach3 = new Coach("Test3");
        coach3.setSeasonWins(11);
        coach3.setNationalChamp(false);

        Coach coach4 = new Coach("Test4");
        coach4.setSeasonWins(10);
        coach4.setNationalChamp(false);

        Coach coach5 = new Coach("Test5");
        coach5.setSeasonWins(9);
        coach5.setNationalChamp(false);

        assertEquals(service.setPostSeasonRank(coach).getPostSeasonRank(), 1);
        assertEquals(service.setPostSeasonRank(coach2).getPostSeasonRank(), 2);

        assertTrue(3 <= service.setPostSeasonRank(coach3).getPostSeasonRank() && service.setPostSeasonRank(coach3).getPostSeasonRank() <= 7);
        assertTrue(8 <= service.setPostSeasonRank(coach4).getPostSeasonRank() && service.setPostSeasonRank(coach4).getPostSeasonRank() <= 16);
        assertTrue(17 <= service.setPostSeasonRank(coach5).getPostSeasonRank() && service.setPostSeasonRank(coach5).getPostSeasonRank() <= 25);
    }

    @Test
    public void testResetSeasonStats() {
        Coach coach = new Coach("Test");
        coach.setSeasonWins(6);
        coach.setSeasonLosses(6);

        assertEquals(service.resetSeasonStats(coach).getSeasonWins(), 0);
        assertEquals(service.resetSeasonStats(coach).getSeasonLosses(), 0);
    }
}
