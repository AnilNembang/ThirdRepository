package com.project;

import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date dt=new Date();
		String value=dt.toString().replace(":", "_").replace(" ", "_");
		System.out.println(dt);
		System.out.println(value);
	}

}
