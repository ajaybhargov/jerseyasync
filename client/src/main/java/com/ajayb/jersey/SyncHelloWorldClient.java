package com.ajayb.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class SyncHelloWorldClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		String response = client
				.target("http://localhost:8080/jerseyhelloworldserver/api/helloworld")
				.request()
				.get(String.class);


		System.out.println("response="+ response);
	}
}
