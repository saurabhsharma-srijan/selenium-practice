package com.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MyTestng {

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass successful");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod successful");
	}

	@Test
	public void firstTest() {
		System.out.println("first Test");
	}

	@Test
	public void secondTest() {
		System.out.println("second Test");
	}

	@Test
	public void thirdTest() {
		System.out.println("third Test");
	}


	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod successful");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass successful");

	}

}
