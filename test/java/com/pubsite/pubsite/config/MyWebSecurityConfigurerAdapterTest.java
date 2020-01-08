/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pubsite.pubsite.config;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 *
 * @author jakub
 */
public class MyWebSecurityConfigurerAdapterTest {
    
    public MyWebSecurityConfigurerAdapterTest() {
    }


    /**
     * Test of successHandler method, of class MyWebSecurityConfigurerAdapter.
     */
    @Test
    public void testSuccessHandler() {
        System.out.println("successHandler");
        
        //given
        MyWebSecurityConfigurerAdapter instance = new MyWebSecurityConfigurerAdapter();
        AuthenticationSuccessHandler expResult = new MyAuthenticationSuccessHandler();
        
        //when
        AuthenticationSuccessHandler result = instance.successHandler();
        
        //then
        assertNotEquals(expResult, result);
    }

    
}
