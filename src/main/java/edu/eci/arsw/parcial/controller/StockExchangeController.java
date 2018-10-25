/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.controller;

import edu.eci.arsw.parcial.services.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(method = RequestMethod.GET)
    StringBuffer index() {
        StringBuffer sb = new StringBuffer("No funciono");
        try{
            return m.getDailyData("fb");}
        catch(Exception e){
            return sb;
        }
    }
}
