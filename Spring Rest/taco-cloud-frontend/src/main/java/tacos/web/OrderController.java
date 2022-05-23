package tacos.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Order;
import tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@RequestParam("name") String name, @RequestParam("street") String street,
			@RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zip") String zip,
			@RequestParam("ccNumber") String ccnumber, @RequestParam("ccExpiration") String ccexpiration,
			@RequestParam("ccCVV") String cccvv) {
		Order order = new Order();
		order.setName(name);
		order.setStreet(name);
		order.setCity(name);
		order.setState(name);
		order.setZip(name);
		order.setCcNumber(name);
		order.setCcExpiration(name);
		order.setCcCVV(name);
		rest.postForObject("http://localhost:8080/order", order, Order.class);
		return "redirect:/";
	}
}
