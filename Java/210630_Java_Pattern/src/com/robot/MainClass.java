package com.robot;

import com.robot.inter.FlyNo;
import com.robot.inter.FlyYes;
import com.robot.inter.KnifeLazer;
import com.robot.inter.MisailYes;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("SuperBobot을 만들어 주세요");
		Robot superRobot = new SuperRobot();
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		
		//superRobot.setFly(new FlyYes());
		superRobot.actionFly();
		//superRobot.setMisail(new MisailYes());
		superRobot.actionMisail();
		//superRobot.setKnife(new KnifeLazer());
		superRobot.actionKnife();
		
		superRobot.setFly(new FlyNo());
		superRobot.actionFly();
	}

}
