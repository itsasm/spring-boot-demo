package com.java.api.configuration.bean;

import org.springframework.stereotype.Component;

@Component
public class FourWheeler implements Vehical {

	@Override
	public String run(int speed) {
		return "Four Wheeler Running @ " + speed + " kmph";
	}

}
