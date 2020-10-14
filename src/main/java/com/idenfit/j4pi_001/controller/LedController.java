package com.idenfit.j4pi_001.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.pi4j.io.gpio.PinState.HIGH;

public class LedController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting(){
        return "Hello World!";
    }

    @RequestMapping("/light")
    public String light(){
        GpioController gpio = GpioFactory.getInstance();
        pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        for(int i=0;i<20;i++){
            pin.setState(HIGH);
            Gpio.delay(500);
        }
        gpio.shutdown();
        return "OK";
    }
}
