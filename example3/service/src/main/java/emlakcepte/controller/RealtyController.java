package emlakcepte.controller;

import emlakcepte.model.Realty;
import emlakcepte.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {

	@Autowired
	private RealtyService realtyService;

	// GET /realtyes
	@GetMapping
	public List<Realty> getAll() {
		return realtyService.getAll();
	}

	// POST /realtyes
	@PostMapping
	public ResponseEntity<Realty> create(@RequestBody Realty realty) {
		System.out.println("realty" + realty);
		realtyService.create(realty);
		return new ResponseEntity<>(realty, HttpStatus.CREATED);
	}

}
