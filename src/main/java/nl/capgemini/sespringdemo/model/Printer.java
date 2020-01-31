package nl.capgemini.sespringdemo.model;

import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Objects;

public class Printer implements Serializable {

	private long id;
	private String type;
	private double price;

	public Printer() {
	}

	public Printer(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Printer printer = (Printer) o;
		return id == printer.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
