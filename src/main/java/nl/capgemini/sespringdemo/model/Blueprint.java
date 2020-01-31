package nl.capgemini.sespringdemo.model;

import java.io.Serializable;

public class Blueprint implements Serializable {
	private String model;
	private double cost;
	private String colour;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
