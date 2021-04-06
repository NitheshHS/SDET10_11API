package com.rmg.apitest;

public class MethodChaining {
	
	MethodChaining a() {System.out.println("a"); return this;}
	MethodChaining b() {System.out.println("b"); return this;}
	MethodChaining c() {System.out.println("c"); return this;}
	
	public static void main(String[] args) {
		
		new MethodChaining().a().b().c().a().c().b();
		
		new Manage().manage().window().maximize();
	}
}
class Manage{
	Window manage() {
		return new Window();
	}
}
class Window{
	Window window() {
		return this;
	}
	void maximize() {
		System.out.println("Screen maximized");
	}
}
