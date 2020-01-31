package nl.capgemini.sespringdemo.api;

import nl.capgemini.sespringdemo.model.Printer;
import nl.capgemini.sespringdemo.persistence.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/printers")
public class PrinterController {


	@Autowired
	private PrinterRepository repository;


	@GetMapping
	public List<Printer> list() {
		return this.repository.findAll();
	}

	@PostMapping
	public Printer create(@RequestBody  Printer printer) { // here, the default constructor is invoked.
		return this.repository.save(printer);
	}



	@GetMapping("{id}")
	public ResponseEntity<Printer> findById(@PathVariable long id) {

		Optional<Printer> optionalPrinter = this.repository.findById(id);

		if(optionalPrinter.isPresent()) {
			Printer printer = optionalPrinter.get();
			return  ResponseEntity.ok(printer);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Printer> updateById(@PathVariable long id, @RequestBody Printer input) {
		Optional<Printer> optionalPrinter = this.repository.updateById(id, input);

		if(optionalPrinter.isPresent()) {
			return  ResponseEntity.ok(optionalPrinter.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) {

		boolean success = this.repository.deleteById(id);

		if (success) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}









	// this methods start when the spring boot application starts
	@PostConstruct
	public void init() {
		{
			Printer first = new Printer();
			first.setPrice(250.00);
			first.setType("Poedel");
			this.repository.save(first);
		}
		{
			Printer first = new Printer();
			first.setPrice(450.00);
			first.setType("Creality");
			this.repository.save(first);
		}
		{
			Printer first = new Printer();
			first.setPrice(2150.00);
			first.setType("Francien");
			this.repository.save(first);
		}
	}
}
