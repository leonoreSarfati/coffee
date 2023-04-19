package io.github.oliviercailloux.samples.coffee;

import java.util.Scanner;

/**
 * <p>
 * A <a href=
 * "https://www.startpage.com/sp/search?query=drip+coffee+maker&cat=pics">drip
 * coffee maker</a>. It uses a specific brand of coffee, which makes it able to
 * produce coffee of any strength from 0 to 10. It takes a constant time of 2
 * minutes to produce coffee (of strength higher than zero). Unrealistically, we
 * suppose here that it produces only one coffee at a time.
 * </p>
 * <p>
 * The energy required for producing a coffee (of strength higher than zero) is
 * an estimated 83 <a href="https://en.wikipedia.org/wiki/Watt_hour">watt
 * hours</a>.
 * </p>
 */
public class DripCoffeeMaker implements CoffeeMachine {
	private int numberCoffee = 0;
	private double lastStrength;
	
	public double getMaxStrength() {
		return 10d;
	}
	
	public int getTimeForCoffee(double strength) {
		if (strength <0 || strength > getMaxStrength()) {
			throw new IllegalArgumentException("Wrong strength");
		}
		if (strength == 0) {
			return 0;
		}
		return 120;
	}
	
	
	public void produceCoffee (double strength) {
		if (strength <0 || strength > getMaxStrength()) {
			throw new IllegalArgumentException("Wrong strength");
		}
		numberCoffee += 1;
		lastStrength = strength;
	}
	
	public int getNumberOfCoffeesProduced() {
		return numberCoffee;
	}
	
	public double getEnergySpent() {
		if (numberCoffee == 0) {
			throw new IllegalStateException("No coffees produced");
		}
		if(lastStrength == 0) {
			return 0;
		}
		return 83d;
	}
	
	public static void main(String[] args){
		DripCoffeeMaker dripMachine = new DripCoffeeMaker();
		dripMachine.produceCoffee(0.3d);
		System.out.println(dripMachine.getEnergySpent());
		dripMachine.produceCoffee(0d);
		System.out.println(dripMachine.getEnergySpent());
		System.out.println(dripMachine.getTimeForCoffee(0.8d));
		System.out.println(dripMachine.getTimeForCoffee(10.2d));
	}

}
