package br.usp.exoma.dao.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


public class CreateLogger{

    public CreateLogger() {
    }
    
    @Produces
    public Logger makeLogger(InjectionPoint ip){
       // return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
       return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
    }
}
