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
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author jakub
 */
public class MailConfigTest {
    
    public MailConfigTest() {
    }
    


    /**
     * Test of mailSender method, of class MailConfig.
     */
    @Test
    public void testMailSender() {
        System.out.println("mailSender");
        
        //given
        MailConfig instance = new MailConfig();
        
        //when
        JavaMailSenderImpl result = instance.mailSender();
        
        //then
        assertNotNull(instance);
        assertEquals(587, result.getPort());
        
    }
    
}
