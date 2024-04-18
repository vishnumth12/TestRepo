package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsPractice {

	
	@Test
	public void test1(){
		System.out.println("--------test 1 ---------");
	}
	
	@Test
	public void test2(){
		System.out.println("--------test 2 ---------");
	}
	
	@BeforeMethod
	public void bm1() {
		System.out.println("------before method 1-----");
	}
	
	@BeforeSuite
	public void bs1(){
		System.out.println("------before suite 1-------");
	}
	
	@AfterClass
	public void ac1() {
		System.out.println("---------after class 1---------");
	}
	
	@AfterMethod
	public void am1() {
		System.out.println("----------after method 1--------");
	}
	
	@AfterSuite
	public void as1() {
		System.out.println("-------after suite 1-----------");
	}
	
	@BeforeClass
	public void bc1() {
		System.out.println("--------before class 1------");
	}
	
	@BeforeSuite
	public void bs2(){
		System.out.println("------before suite 2-------");
	}
	
	@AfterClass
	public void ac2() {
		System.out.println("---------after class 2---------");
	}
	
	@AfterMethod
	public void am2() {
		System.out.println("----------after method 2--------");
	}
	
}
