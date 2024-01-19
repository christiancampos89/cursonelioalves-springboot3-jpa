package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User usuario1 = new User(null, "Christian Rafael e Campos", "christian@pti.com.br", "45999886639", "12345");
		User usuario2 = new User(null, "Elisangela Campos", "elisagenla@gmail.com", "45999989295", "12345");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, usuario1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, usuario2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, usuario1);
		
		Category c1 = new Category(null, "eletronicos");
		Category c2 = new Category(null, "portateis");
		Category c3 = new Category(null, "esportes");
		Category c4 = new Category(null, "higiene");
		
		Product p1 = new Product(null, "Iphone 14 Plus 256", "Celular ultima geracao Apple", 1490.00, c2, "imgteste");
		Product p2 = new Product(null, "Tenis Nike Hard", "Tenis mega confortavel para correr", 250.00, c3, "imgteste");
		Product p3 = new Product(null, "Desodorante Rexona nunca abandona","Desodorante masculino", 20.00, c4, "imgteste");
		Product p4 = new Product(null, "Notebook Dell G3 Expiron", "Notebook Gammer Profissional", 1975.00, c1, "imgteste");
		
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}
}
