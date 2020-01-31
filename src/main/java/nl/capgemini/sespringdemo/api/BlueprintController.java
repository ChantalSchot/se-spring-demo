package nl.capgemini.sespringdemo.api;

import nl.capgemini.sespringdemo.model.Blueprint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("api/blueprints")
public class BlueprintController {
	private List<Blueprint> modelList = new ArrayList<>();

	@GetMapping
	public List<Blueprint> getList() {
		Blueprint model = new Blueprint();
		model.setColour("Green and blue");
		model.setCost(25);
		model.setModel("Tree");

		modelList.add(model);

		return modelList;
	}

}
