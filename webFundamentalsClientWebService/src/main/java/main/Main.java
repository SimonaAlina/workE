package main;

import web.service.Comment;
import web.service.CommentWebServiceClient;
import web.service.CommentWebServiceClientImpl;

public class Main {

	public static void main(String[] args) {
		CommentWebServiceClient client = new CommentWebServiceClientImpl();
		
		//client.findAll();
		
		Comment c1 = new Comment();
		c1.setId(1);
		c1.setComment("comm1");
		
		//client.save(c1);
		
		client.findById((long)1);
		
	}
}