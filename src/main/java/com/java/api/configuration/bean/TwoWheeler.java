package com.java.api.configuration.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TwoWheeler implements Vehical {

	@Override
	public String run(int speed) {
		return "Two Wheeler Running @ " + speed + " kmph";
	}

}
