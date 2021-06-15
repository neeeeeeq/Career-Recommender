/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Muneeb
 */
public class Job {
        private String jobType;
    private String requiredQualification;
    private boolean fullTime;
    private boolean partTime;

    
    Job()
    {
        jobType="";
        requiredQualification="";
        fullTime=true;
        partTime=true;
                
    }
    Job(String type, String qualification, boolean fullTime, boolean partTime)
    {
        jobType=type;
        requiredQualification=qualification;
        this.fullTime=fullTime;
        this.partTime=partTime;
                
        
    }
    
    
        
    
}

