package web.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CommentWebServiceClientImpl implements CommentWebServiceClient {

	public static final String LOCAL_URI = "http://localhost:9090/restfulapis/";

	private Client client = ClientBuilder.newClient();

	public Comment save(Comment comment) {
		WebTarget wt = client.target(LOCAL_URI);

		Response response = wt.path("comment/").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(comment, MediaType.APPLICATION_JSON));
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + "error on the server (PUT)");
		}
		return response.readEntity(Comment.class);
	}

	public Comment update(Comment comment) {
		WebTarget wt = client.target(LOCAL_URI);

		Response response = wt.path("comment/").request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(comment, MediaType.APPLICATION_JSON));
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + "error on the server (POST)");
		}
		return response.readEntity(Comment.class);
	}

	public Comment findById(Long commentId) {
		WebTarget wt = client.target(LOCAL_URI);
		Response response = wt.path("comment/" + commentId).request(MediaType.APPLICATION_JSON).get(Response.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " error on the server (GET)");
		}
		System.out.println("RESPONSE: " + response);
		return response.readEntity(Comment.class);
	}

	public List<Comment> findAll() {
		WebTarget wt = client.target(LOCAL_URI);
		List<Comment> response = wt.path("comment/").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Comment>>() {
				});

		return response;
	}

	public void delete(Long commentId) {
		WebTarget wt = client.target(LOCAL_URI);
		Response response = wt.path("comment/" + commentId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + "error on the server (DELETE)");
		}
	}

}