package com.az.invivo.idservice.controller;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicLong;

import com.az.invivo.idservice.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeter {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping({"/","/greeting"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name)+getIpaddress());
    }


    private String getIpaddress(){
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

        } catch (Exception e) {

            e.printStackTrace();
        }
        String s = hostname + ip.toString();
        return s;
    }
}