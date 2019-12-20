package com.shop;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shop.dao.ProductRepository;
import com.shop.entities.Product;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner{

    @Autowired
    private ProductRepository productRepository;
	
    public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	  @Override
	    public void run(String... args) throws Exception {
	        Random rnd=new Random();
	     
	            //Add products
	            for (int i = 0; i <10 ; i++) {
	                Product p=new Product();
	                p.setName(RandomString.make(15));
	                p.setPrice(100+rnd.nextInt(100));
	                productRepository.save(p);
	            }
	    }
}
