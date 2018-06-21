/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.collegefootballcoach;

import com.sg.collegefootballcoach.controller.CollegeFootballCoachController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jefftate
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        CollegeFootballCoachController controller
                = ctx.getBean("controller", CollegeFootballCoachController.class);
        controller.run();
    }
}
