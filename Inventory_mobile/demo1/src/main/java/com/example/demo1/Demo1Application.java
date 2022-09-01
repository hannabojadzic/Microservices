package com.example.demo1;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	InventoryRepository inventoryRepository;


	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Location location1 = Location
				.builder()
				.id(1L)
				.address("Mehmeda Spahe")
				.city("Sarajevo, Bosna i Hercegovina")
				.phoneNumber("011-111-111")
				.build();
		Location location2 = Location
				.builder()
				.id(2L)
				.address("Maršala tita 5")
				.city("Sarajevo, Bosna i Hercegovina")
				.phoneNumber("011-111-112")
				.build();
		Location location3 = Location
				.builder()
				.id(3L)
				.address("Akifa Šeremeta 10")
				.city("Dobrinja, Bosna i Hercegovina")
				.phoneNumber("011-111-112")
				.build();
		locationRepository.save(location1);
		locationRepository.save(location2);
		locationRepository.save(location3);

		inventoryRepository.save(
				Inventory
						.builder()
						.name("LAPTOP ASUS TUF FX506LHB-HN323")
						.cpu("Intel Core i5-10300H (2.5- 4.5GHz, 8MB)")
						.description("OS: Ne Display: 15.6\", Rezolucija: 1920x1080, IPS, 144 Hz CPU: Intel Core i5-10300H (2.5- 4.5GHz, 8MB) RAM: 8GB DDR4 SSD: 512GB VGA: nVidia GeForce GTX1650 (4GB) Mreža: WiFi, Bluetooth 5.0, Priključci: SD")
						.display("1920x1080")
						.graphics("nVidia GeForce GTX1650 (4GB)")
						.hdd("512GB")
						.id(1L)
						.imageUrl("https://static.imtec.ba/201804-large_default/laptop-asus-tuf-fx506lhb-hn323-ruksak-asus-rog-ranger.jpg")
						.ports("SD reader, 1xUSB 2.0, 2xUSB 3.2, 1xUSB Type C, HDMI")
						.locations(Arrays.asList(location1, location3))
						.price("1.849,00 KM")
						.priceDouble(1849D)
						.qty(2L)
						.ram("8GB DDR4")
						.shortDesc("8GB, i5-10300H, 512GB, GeForce GTX1650")
						.build()
		);
		inventoryRepository.save(
				Inventory
						.builder()
						.name("LAPTOP TOSHIBA DYNABOOK TECRA")
						.cpu("Intel Core i7-1165G7 (2.8- 4.7GHz, 12MB)")
						.description("OS: Ne Display: 15.6\", Rezolucija: 1920x1080, IPS, 144 Hz CPU: Intel Core i5-10300H (2.5- 4.5GHz, 8MB) RAM: 8GB DDR4 SSD: 512GB VGA: nVidia GeForce GTX1650 (4GB) Mreža: WiFi, Bluetooth 5.0, Priključci: SD")
						.display("1920x1080")
						.graphics("Intel Iris Xe Graphics")
						.hdd("512GB")
						.id(2L)
						.imageUrl("https://static.imtec.ba/202038-home_default/laptop-toshiba-dynabook-tecra-a50-j-1gj-.jpg")
						.ports("SD reader, 1xUSB 2.0, 2xUSB 3.2, 1xUSB Type C, HDMI")
						.locations(Arrays.asList(location1, location3, location2))
						.price("2.649,00 KM")
						.priceDouble(2649D)
						.shortDesc("16GB, i7-1165G7, 512GB, Intel Iris Xe Graphics")
						.qty(1L)
						.ram("16GB DDR4")
						.build()
		);
		inventoryRepository.save(
				Inventory
						.builder()
						.name("LAPTOP TOSHIBA DYNABOOK TECRA")
						.cpu("Intel Core i7-1165G7 (2.8- 4.7GHz, 12MB)")
						.description("OS: Windows 11 Pro Display: 15.6\", Rezolucija: 1920x1080 CPU: Intel Core i7-1165G7 (2.8- 4.7GHz, 12MB) RAM: 16GB DDR4 SSD: 512GB VGA: Intel Iris Xe Graphics Mreža: WiFi, Bluetooth Priključci: SD reader, 2x Type-C, 2xUSB3.2, HDMI, audio Baterija: 3-cell Osvjetljena tastatura, fingerprint, Smartcard reader, MIL-810H Garancija: 36 mjeseci")
						.display("1920x1080")
						.graphics("Intel Iris Xe Graphics")
						.hdd("512GB")
						.id(3L)
						.imageUrl("https://static.imtec.ba/202038-home_default/laptop-toshiba-dynabook-tecra-a50-j-1gj-.jpg")
						.ports("SD reader, 1xUSB 2.0, 2xUSB 3.2, 1xUSB Type C, HDMI")
						.locations(Arrays.asList(location1, location3, location2))
						.price("2.649,00 KM")
						.priceDouble(2649D)
						.qty(1L)
						.shortDesc("16GB, i7-1165G7, 512GB, Intel Iris Xe Graphics")
						.ram("16GB DDR4")
						.build()
		);
		inventoryRepository.save(
				Inventory
						.builder()
						.name("LAPTOP HP ELITEBOOK 850 G8")
						.cpu("Intel Core i7-1165G7 (2.8- 4.7GHz, 12MB)")
						.description("OS: Windows 11 Pro Display: 15.6\", Rezolucija: 1920x1080 CPU: Intel Core i7-1165G7 (2.8- 4.7GHz, 12MB) RAM: 16GB DDR4 SSD: 512GB VGA: Intel Iris Xe Graphics Mreža: WiFi, Bluetooth Priključci: SD reader, 2x Type-C, 2xUSB3.2, HDMI, audio Baterija: 3-cell Osvjetljena tastatura, fingerprint, Smartcard reader, MIL-810H Garancija: 36 mjeseci")
						.display("1920x1080")
						.graphics("Intel Iris Xe Graphics")
						.hdd("512GB")
						.id(4L)
						.imageUrl("https://static.imtec.ba/198462-home_default/laptop-hp-elitebook-850-g8-2y2r6ea-.jpg")
						.ports("SD reader, 1xUSB 2.0, 2xUSB 3.2, 1xUSB Type C, HDMI")
						.locations(Arrays.asList(location2))
						.shortDesc("16GB, i7-1165G7, 512GB, Intel Iris Xe Graphics")
						.price("3.149,00 KM")
						.priceDouble(3149D)
						.qty(1L)
						.ram("16GB DDR4")
						.build()
		);
		inventoryRepository.save(
				Inventory
						.builder()
						.name("LAPTOP HP ELITEBOOK 840 AERO G8")
						.cpu(" Intel Core i5-1135G7 (do 4.2GHz, 8MB)")
						.description("OS: Windows 10 Pro Display: 14\" AG, Rezolucija: 1920x1080 CPU: Intel Core i5-1135G7 (do 4.2GHz, 8MB) RAM: 8GB DDR4 SSD: 256GB VGA: Intel Iris Xe Graphics Priključci: SD reader, 1x USB3.1, 2x TypeC, HDMI, audio Baterija: 3-cell Garancija: 36 mjeseci.")
						.display("1920x1080")
						.graphics("Intel Iris Xe Graphics")
						.hdd("512GB")
						.id(5L)
						.imageUrl("https://static.imtec.ba/196430-home_default/laptop-hp-elitebook-840-aero-g8-401f3ea-.jpg")
						.ports("SD reader, 1x USB3.1, 2x TypeC, HDMI")
						.shortDesc("8GB, i7-1165G7, 512GB, Intel Iris Xe Graphics")
						.locations(Arrays.asList(location2))
						.price("2.999,00 KM")
						.priceDouble(3149D)
						.qty(1L)
						.ram("8GB DDR4")
						.build()
		);
	}

}

@RestController
class Hello {
	@Autowired
	InventoryRepository inventoryRepository;

	@RequestMapping("/")
	String index() {
		return "Hello world demo 1";
	}

	@RequestMapping("/inventory_slow")
	String function_that_takes_too_long() throws InterruptedException {
		Thread.sleep(6000);
		return "Hello world demo 1";
	}

	@RequestMapping("/inventory")
	InventoryListDTO getAllInventoryEndpoint(@RequestParam("pageNum") Integer pageNum,  @RequestParam("pageSize") Integer pageSize) throws InterruptedException {
		Page<Inventory> inventoryPage = getInventory(pageNum, pageSize);
		return InventoryListDTO
				.builder()
				.pageNumber(pageNum)
				.pageSize(pageSize)
				.totalElements(inventoryPage.getTotalElements())
				.inventory(inventoryPage
						.getContent()
						.stream()
						.map(inventory -> InventoryShort
								.builder()
								.shortDesc(inventory.getShortDesc())
								.id(inventory.getId())
								.price(inventory.getPrice())
								.imageUrl(inventory.getImageUrl())
								.name(inventory.getName())
								.qty(inventory.getQty())
								.build())
						.collect(Collectors.toList()))
				.build();
	}
	@RequestMapping("/inventory/getById/{id}")
	String getSingleInventoryEndpoint() throws InterruptedException {
		return "Inventory160";
	}
	public Inventory getInventoryById(Long id) {
		return inventoryRepository.getById(id);
	}

	public Page<Inventory> getInventory(Integer pN, Integer pS) {
		return inventoryRepository.findAll(PageRequest.of(pN, pS));
	}
}


@Data
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
class Inventory {
	@Id
	Long id;
	String name;
	Long qty;
	String imageUrl;
	@Column(length = 3000)
	String description;
	@ManyToMany
	List<Location> locations;
	String price;
	Double priceDouble;
	String shortDesc;

	//specs
	String ram;
	String hdd;
	String cpu;
	String display;
	String graphics;
	String ports;

	public Inventory() {

	}
}

@Data
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
class Location {
	String address;
	String city;
	String phoneNumber;
	@Id
	private Long id;

	public Location() {
	}

}

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
class InventoryShort {
	Long id;
	String name;
	Long qty;
	String imageUrl;
	String price;
	String shortDesc;
}

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
class InventoryListDTO {
	Integer pageNumber;
	Integer pageSize;
	Long totalElements;
	List<InventoryShort> inventory;
}


