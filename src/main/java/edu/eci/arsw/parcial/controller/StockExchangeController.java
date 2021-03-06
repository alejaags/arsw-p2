/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.controller;

import edu.eci.arsw.parcial.services.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2110111
 */
@RestController
@RequestMapping("/stock")
public class StockExchangeController {
    
    @Autowired
    private HttpConnection m;
    
    @RequestMapping(path="/{time}/{business}",method = RequestMethod.GET)
    public StringBuffer index(@PathVariable String time,@PathVariable String business) {
        
        try {
            if(time.equals("intraday")){
                return m.getIntradayData(business);
            }else if(time.equals("daily")){
                return m.getDailyData(business);
            }else if(time.equals("weekly")){
                return m.getWeeklyData(business);
            }else if(time.equals("monthly")){
                return m.getMonthlyData(business);            
            }else{
                return null;
            }
          
        } catch (Exception ex) {
            return null;
        }
    }
}
