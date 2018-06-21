/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jefftate
 */
public class CollegeFootballCoachDaoTest {

    private CollegeFootballCoachDao dao = new CollegeFootballCoachDaoFileImpl();

    public CollegeFootballCoachDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetTeam() throws Exception {
        assertNotNull(dao.getTeam(6));
    }
}
