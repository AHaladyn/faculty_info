/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pubsite.pubsite.entity;

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
public class AdminsTest {
    
    
    Admins testAdmin = new Admins();
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testAdmin.setFirstName("TestFirstName");
        testAdmin.setLastName("testLastName");
        testAdmin.setUserId(1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserId method, of class Admins.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        //given
        Admins instance = testAdmin;
        Integer expResult = 1;
        
        //when
        Integer result = testAdmin.getUserId();
        
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserId method, of class Admins.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        //given
        Admins instance = testAdmin;
        Integer expResult = 2;
        
        //when
        instance.setUserId(expResult);
        
        //then
        assertEquals(expResult, instance.getUserId());
    }

    /**
     * Test of getFirstName method, of class Admins.
     */
    @Test
    public void testGetFirstNameNull() {
        System.out.println("getFirstName");
        //given
        Admins instance = new Admins();
        
        //when
        String result = instance.getFirstName();
        
        //then
        assertNull(result);
    }

    /**
     * Test of setFirstName method, of class Admins.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        //given
        String expResult = "test";
        Admins instance = new Admins();
        
        //when
        instance.setFirstName(expResult);
        
        //then
        assertEquals(expResult, instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class Admins.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        //given
        Admins instance = testAdmin;
        String expResult = "testLastName";
        
        //when
        String result = instance.getLastName();
        
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Admins.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        //given
        String lastName = "testLastTest";
        Admins instance = testAdmin;
        
        //when
        instance.setLastName(lastName);
        
        //then
        assertNotEquals(instance.getLastName(), "testLastName");
    }
    
}
