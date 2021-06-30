package com.robot;

import com.robot.inter.FlyYes;
import com.robot.inter.KnifeLazer;
import com.robot.inter.MisailYes;

public class SuperRobot extends Robot{
	
	public SuperRobot() {
		fly = new FlyYes();
		misail = new MisailYes();
		knife = new KnifeLazer();
	}
	
	@Override
	public void shape() {
		System.out.println("SuperRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");

	}
		
}
