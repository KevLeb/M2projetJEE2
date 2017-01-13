package fr.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(name = "Hello")
@LocalBean()
public class Hello {

    public String sayHello() {
        return "Hello " + System.currentTimeMillis();
    }

}