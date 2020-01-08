/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Role;
import com.pubsite.pubsite.repository.RoleRepository;
import com.pubsite.pubsite.service.RoleService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author jakub
 */
@RunWith(SpringRunner.class)
public class RoleServiceImpTest {
    
    public RoleServiceImpTest() {
        
    }
    
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public RoleService roleService() {
            return new RoleServiceImp();
        }
    }
    
    @Autowired
    private RoleService roleService;
 
    @MockBean
    private RoleRepository roleRepository;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Role nowy = new Role();
        nowy.setName("nowy");
 
        Mockito.when(roleRepository.findByName(nowy.getName()))
      .thenReturn(nowy);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    @Ignore
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Role found = roleService.findByName(name);

         assertEquals(found.getName(), name);
     }

//    /**
//     * Test of add method, of class RoleServiceImp.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        Role role = null;
//        RoleServiceImp instance = new RoleServiceImp();
//        instance.add(role);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByName method, of class RoleServiceImp.
//     */
//    @Test
//    public void testFindByName() {
//        System.out.println("findByName");
//        String name = "";
//        RoleServiceImp instance = new RoleServiceImp();
//        Role expResult = null;
//        Role result = instance.findByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class RoleServiceImp.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        Integer id = null;
//        RoleServiceImp instance = new RoleServiceImp();
//        Role expResult = null;
//        Role result = instance.findById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
