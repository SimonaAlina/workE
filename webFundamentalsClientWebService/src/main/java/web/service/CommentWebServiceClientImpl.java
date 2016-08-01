package web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.DeserializationConfig;
import org.json.JSONArray;
import org.json.JSONObject;


public class CommentWebServiceClientImpl implements CommentWebServiceClient {

	public static final String LOCAL_URI = "http://localhost:9090/restfulapis/";
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

	public Comment save(Comment comment) {
		HttpClient hc = new DefaultHttpClient();
		HttpPost hp = new HttpPost(LOCAL_URI + "comment/");
		hp.setHeader("Content-Type", "application/json");

		String jsonComm = null;
		try {
			jsonComm = ow.writeValueAsString(comment);
			StringEntity params = new StringEntity(jsonComm);
			hp.setEntity(params);
			hc.execute(hp);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comment;
	}

	public Comment update(Comment comment) {
		HttpClient hc = new DefaultHttpClient();
		HttpPut hp = new HttpPut(LOCAL_URI + "comment/" + comment.getId());
		hp.setHeader("Content-Type", "application/json");
		StringEntity params = null;
		String jsonComm = null;
		try {
			jsonComm = ow.writeValueAsString(comment);
			params = new StringEntity(jsonComm);
			hp.setEntity(params);
			hc.execute(hp);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comment;
	}

	public Comment findById(Long commentId) {
		HttpClient hc = new DefaultHttpClient();
		HttpGet hg = new HttpGet(LOCAL_URI + "comment/" + commentId);
		hg.setHeader("Content-Type", "application/json");
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Comment comment = null;
		HttpResponse hr = null;
		try {
			hr = hc.execute(hg);
			String jsonComm = EntityUtils.toString(hr.getEntity());
			comment = mapper.readValue(jsonComm, Comment.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comment;
	}

	public List<Comment> findAll() {
		List<Comment> listComm = new ArrayList<>();
		HttpClient hc = new DefaultHttpClient();
		HttpGet hg = new HttpGet(LOCAL_URI + "comment/");
		HttpResponse hr = null;
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			hr = hc.execute(hg);

			JSONObject jsonObject = new JSONObject(EntityUtils.toString(hr.getEntity()));
			JSONArray jsonArray = jsonObject.getJSONObject("_embedded").getJSONArray("comment");
			for (Object obj : jsonArray) {
				listComm.add(mapper.readValue(obj.toString(), Comment.class));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listComm;

	}

	public void delete(Long commentId) {
		HttpClient hc = new DefaultHttpClient();
		HttpDelete hd = new HttpDelete(LOCAL_URI + "comment/" + commentId);
		try {
			hc.execute(hd);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}