package com.shpach.stack;

public class Main {

	public static void main(String[] args) {
		Stack stack=new Stack();
		int a=10;
		String b="second";
		String c ="third";
		
		stack.add(a);
		stack.add(b);
		stack.addClassToBlackList(String.class);
		stack.add(c);

	}

}
