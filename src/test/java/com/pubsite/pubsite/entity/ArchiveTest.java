/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pubsite.pubsite.entity;

import java.sql.Date;
import java.util.Objects;
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
public class ArchiveTest {
    
    
    Archive mainInstance = new Archive();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mainInstance.setContent("testContent");
        mainInstance.setContentType("testContentType");
        mainInstance.setCreated(Date.valueOf("2020-01-10"));
        mainInstance.setDescription("testDescription");
        mainInstance.setFilename("testFilename");
        mainInstance.setId(1);
        mainInstance.setName("testName");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Archive.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        //given
        Archive instance = mainInstance;
        Integer expResult = 1;
        
        //when
        Integer result = instance.getId();
        
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Archive.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        //given
        Integer id = 2;
        Archive instance = new Archive();
        instance.setId(id);
        assertTrue(Objects.equals(instance.getId(), id));
    }

    /**
     * Test of getName method, of class Archive.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        //given
        Archive instance = mainInstance;
        String expResult = "testName";
        
        //when
        String result = instance.getName();
        
        //then
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Archive.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        //given
        String name = "testName2";
        Archive instance = mainInstance;
        
        //when
        instance.setName(name);
        
        //then
        assertNotEquals(name, "testName3");
    }

    /**
     * Test of getDescription method, of class Archive.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        //given
        Archive instance = mainInstance;
        String expResult = "";
        
        //when
        String result = instance.getDescription();
        
        //then
        assertNotEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Archive.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        //given
        String description = "";
        Archive instance = new Archive();
        
        //when
        instance.setDescription(description);
        String result = instance.getDescription();
        
        //then
        assertEquals(description, result);
    }

    /**
     * Test of getFilename method, of class Archive.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");
        //given
        Archive instance = mainInstance;
        String expResult = "";
        
        //when
        String result = instance.getFilename();
        
        //then
        assertNotSame(expResult, result);
    }

    /**
     * Test of setFilename method, of class Archive.
     */
    @Test
    public void testSetFilename() {
        System.out.println("setFilename");
        //given
        String filename = "testFilename";
        Archive instance = new Archive();
        
        //when
        instance.setFilename(filename);
        
        //then
        assertSame(instance.getFilename(), mainInstance.getFilename());
    }

    /**
     * Test of getContent method, of class Archive.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        //given
        Archive instance = mainInstance;
        String expResult = "testContent";
        
        //when
        String result = instance.getContent();
        
        //then
        assertEquals(expResult, result);
    }

    
}
