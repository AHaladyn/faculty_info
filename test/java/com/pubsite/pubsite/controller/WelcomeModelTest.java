/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pubsite.pubsite.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jakub
 */
public class WelcomeModelTest {
    
    WelcomeModel instance = new WelcomeModel();
    
    public WelcomeModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance.setMessage("test");
        instance.setDescription("testDesc2");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMessage method, of class WelcomeModel.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        
        //given
        String expResult = "test";
        
        //when
        String result = instance.getMessage();
        
        //then
        assertEquals(expResult, result);
    }


    /**
     * Test of getDescription method, of class WelcomeModel.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        
        //given
        String expResult = "testDesc";
        
        //when
        String result = instance.getDescription();
        
        //then
        assertNotEquals(expResult, result);
    }


    
}
