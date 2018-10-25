/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.services;

import java.io.IOException;

/**
 *
 * @author 2110111
 */
public interface HttpConnection {
    
    /**
     * 
     * @param Business
     * @return
     * @throws IOException 
     */
    public StringBuffer getDailyData(String Business) throws IOException;
    
    /**
     * 
     * @param Business
     * @return
     * @throws IOException 
     */
    public StringBuffer getWeeklyData(String Business) throws IOException;
    
    /**
     * 
     * @param Business
     * @return
     * @throws IOException 
     */
    public StringBuffer getMonthlyData(String Business) throws IOException;
    
    /**
     * 
     * @param Business
     * @return
     * @throws IOException 
     */
    public StringBuffer getIntradayData(String Business) throws IOException;
    
}
