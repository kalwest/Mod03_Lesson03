package com.kaiser.learningJpa.jpaTuts;

import com.kaiser.learningJpa.jpaTuts.entities.ProductEntity;
import com.kaiser.learningJpa.jpaTuts.repositories.ProductRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	private DataSource dataSource;


	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){

		ProductEntity productEntity = ProductEntity.builder()
				.sku("kitkat333")
				.title("Kit KAt bar")
				.price(BigDecimal.valueOf(111.45))
				.quantity(10)
				.build();


		ProductEntity savedPRoductEntity =   productRepository.save(productEntity);
		System.out.println(savedPRoductEntity);
	}

	@Test
	void getRepository() throws SQLException {
//		List<ProductEntity> entities = productRepository.findAll();
//		System.out.println(entities);

//		List<ProductEntity> entities = productRepository.findByTitle("Kit KAt bar");
//		System.out.println(entities);

//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(LocalDateTime.of(2026,8,8, 17,30,0));
//		System.out.println(entities);

//		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(12, BigDecimal.valueOf(123.45));
//		System.out.println(entities);

//		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(9, BigDecimal.valueOf(130.00));
//		System.out.println(entities);

		//List<ProductEntity> entities = productRepository.findByTitleContaining("Kit");
		//*******************************************************************
//		System.out.println(
//				"DATABASE URL: " +
//						dataSource.getConnection().getMetaData().getURL()
//		);
//
//		List<ProductEntity> entities =
//				productRepository.findByTitleContaining("Kit");
//
//		System.out.println("RESULT COUNT: " + entities.size());
//		entities.forEach(System.out::println);
//
//		System.out.println("TOTAL ROWS: " + productRepository.count());
//
//		productRepository.findAll()
//				.forEach(product ->
//						System.out.println(
//								product.getId() + " : [" + product.getTitle() + "]"
//						)
//				);
		//******************************************************************
		List<ProductEntity> entities =
				productRepository.findByTitleContaining("Kit");

		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("Nestle Chocolate", BigDecimal.valueOf(123.45));
		System.out.println(productEntity);
	}


}
