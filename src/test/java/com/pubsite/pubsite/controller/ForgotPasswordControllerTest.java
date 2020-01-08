/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pubsite.pubsite.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jakub
 */
public class ForgotPasswordControllerTest {
    
    public ForgotPasswordControllerTest() {
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

    /**
     * Test of handleMissingParams method, of class ForgotPasswordController.
     */
    @Test
    public void testHandleMissingParams() {
        System.out.println("handleMissingParams");
        MissingServletRequestParameterException ex = new MissingServletRequestParameterException("Error", "Error");
        ForgotPasswordController instance = new ForgotPasswordController();
        String expResult = "redirect:/login";
        String result = instance.handleMissingParams(ex);
        assertEquals(expResult, result);
    }
    
}
