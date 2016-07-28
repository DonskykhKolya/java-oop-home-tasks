package com.shpach.cat;

public class Main {

	public static void main(String[] args) {
		Cat cat1=new Cat("Рыжий","мейкун",Cat.sexType.mail,"red",2010,false);
		System.out.println("Init cat "+ cat1);
		while(cat1.getHungry()<100){
			cat1.feed();
		}
		System.out.println("Full feed "+cat1);
		for(int i=0;i<4;i++){
		cat1.punish();
		}
		System.out.println("after punish "+cat1);
		cat1.play();
		cat1.play();
		System.out.println("after play "+cat1);
		cat1.makeNeuter();
		System.out.println("after neutering "+cat1);
		while(cat1.getHappiness()<100){
		cat1.takeCare();
		}
		System.out.println("after take care "+cat1);
	}

}
