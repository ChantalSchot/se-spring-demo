package nl.capgemini.sespringdemo.persistence;

import nl.capgemini.sespringdemo.model.Printer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PrinterRepository {

	private static long counter = 0;

	List<Printer> content = new ArrayList<>();

	public List<Printer> findAll() {
		return this.content;
	}

	public Printer save(Printer printer) {
		printer.setId(++counter);

		this.content.add(printer);

		return printer;
	}

	public Optional<Printer> findById(long id) {
		for(Printer printer : content) {

			if(id == printer.getId()) {
				return Optional.of(printer);
			}
		}

		return Optional.empty();
	}

	public Optional<Printer> updateById(long id, Printer input) {
		Optional<Printer> optionalPrinter = findById(id);

		if(optionalPrinter.isPresent()) {
			Printer printer = optionalPrinter.get();
			printer.setType(input.getType());
			printer.setPrice(input.getPrice());

			return Optional.of(printer);
		} else {
			return Optional.empty();
		}
	}

	public boolean deleteById(long id) {
		Optional<Printer> optionalPrinter = findById(id);

		if(optionalPrinter.isPresent()) {
			Printer printer = optionalPrinter.get();
			this.content.remove(printer);

			return true;
		} else {
			return false;
		}
	}
	
//	public List<Printer> deleteById(long id) {
//		Optional<Printer> optionalPrinter = findById(id);
//
//		if(optionalPrinter.isPresent()) {
//			content.remove(optionalPrinter);
//		}
//		return this.content;
//	}

}