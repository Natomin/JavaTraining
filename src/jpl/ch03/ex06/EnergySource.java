package jpl.ch03.ex06;

public abstract class EnergySource {
	enum fuelLevel{FULL, HALF, EMPTY};
	abstract fuelLevel empty();
}
