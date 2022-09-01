package com.example.demo1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}

@RestController
class Hello {

	@RequestMapping("/")
	String index() {
		return "Hello world demo 1";
	}

	@RequestMapping("/inventory_slow")
	String function_that_takes_too_long() throws InterruptedException {
		Thread.sleep(6000);
		return "Hello world demo 1";
	}

	@RequestMapping("/inventory_web")
	String backends_for_frontends() throws InterruptedException {
		return "Hello world demo 1";
	}

	@RequestMapping("/billing/getPaymentOptions/{id}")
	Payment_Inventory getSingleInventoryEndpoint(@PathVariable("id") Long id) throws InterruptedException {
		return getPIById(id);
	}

	public Payment_Inventory getPIById(Long id) {
		return getAllPaymentInventory().stream().filter(payment_inventory -> payment_inventory.getExtInventoryId().equals(id)).findFirst().get();
	}

	public List<Payment_Inventory> getAllPaymentInventory() {
		Payment payment1 = Payment
				.builder()
				.discount("10%")
				.id(1L)
				.logo("https://www.paypalobjects.com/webstatic/mktg/logo/pp_cc_mark_111x69.jpg")
				.provider("PayPal")
				.build();
		Payment payment2 = Payment
				.builder()
				.id(2L)
				.logo("https://play-lh.googleusercontent.com/2PS6w7uBztfuMys5fgodNkTwTOE6bLVB2cJYbu5GHlARAK36FzO5bUfMDP9cEJk__cE")
				.provider("Stripe")
				.build();
		List<Payment_Inventory> p = new ArrayList<>();
		p.add(
				Payment_Inventory
						.builder()
						.extInventoryId(1L)
						.payments(Arrays.asList(payment1, payment2))
						.build()
		);
		p.add(
				Payment_Inventory
						.builder()
						.extInventoryId(2L)
						.payments(Arrays.asList(payment1, payment2))
						.build()
		);
		p.add(
				Payment_Inventory
						.builder()
						.extInventoryId(3L)
						.payments(Arrays.asList(payment1))
						.build()
		);
		p.add(
				Payment_Inventory
						.builder()
						.extInventoryId(4L)
						.payments(Arrays.asList(payment1, payment2))
						.build()
		);
		p.add(
				Payment_Inventory
						.builder()
						.extInventoryId(5L)
						.payments(Arrays.asList(payment1))
						.build()
		);
		return p;
	}
}

@Data
@AllArgsConstructor
@Builder
class Payment_Inventory {
	Long id;
	Long extInventoryId;
	List<Payment> payments;
}
@Data
@AllArgsConstructor
@Builder
class Payment {
	Long id;
	String provider;
	String logo;
	String discount;
}