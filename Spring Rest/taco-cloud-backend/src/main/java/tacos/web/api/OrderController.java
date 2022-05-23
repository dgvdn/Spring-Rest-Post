package tacos.web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tacos.Order;
import tacos.Taco;
import tacos.data.OrderRepository;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
	private OrderRepository orderRepository;

	@Autowired
//	EntityLinks entityLinks;

	public OrderController(OrderRepository repository) {
		this.orderRepository = repository;
	}

	@GetMapping("/recent")
	public Iterable<Order> recentOrder() {
		return orderRepository.findAll();
	}

	@GetMapping("/{id}")
	public Order orderById(@PathVariable("id") Long id) {
		Optional<Order> optOrder = orderRepository.findById(id);
		if (optOrder.isPresent()) {
			return optOrder.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Order postOrder(@RequestBody Order taco) {
		return orderRepository.save(taco);
	}
}
