package main;

import web.service.Comment;
import web.service.CommentWebServiceClient;
import web.service.CommentWebServiceClientImpl;

public class Main {

	public static void main(String[] args) {
		CommentWebServiceClient client = new CommentWebServiceClientImpl();
		System.out.println(client.findAll());
		
		Comment c1 = new Comment();
		c1.setId(1L);
		c1.setName("Simona");
		c1.setEmail("1@gmail.com");
		c1.setComment("comm1");
		
		client.save(c1);
		
		Comment c2 = new Comment();
		c2.setId(2L);
		c2.setName("Alina");
		c2.setEmail("2@gmail.com");
		c2.setComment("comm2");
		
		client.save(c2);
				
		System.out.println(client.findAll());
		
		c2.setName("Alina R");
		client.update(c2);
		
		System.out.println(client.findAll());
		
		client.delete(1L);
		client.delete(2L);
		
		System.out.println(client.findAll());
		
	}
}