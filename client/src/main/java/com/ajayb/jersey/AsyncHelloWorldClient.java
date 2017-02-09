package com.ajayb.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;

public class AsyncHelloWorldClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        try {

            List<Future<String>> futureList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Future<String> stringFuture = client.target("http://localhost:8080/jerseyhelloworldserver/api/helloworld").request().async().get(new InvocationCallback<String>() {
                    @Override
                    public void completed(String response) {
                        System.out.println("Response entity '" + response + "' received.");
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        System.out.println("Invocation failed.");
                        throwable.printStackTrace();
                    }
                });

                futureList.add(stringFuture);
            }

            for (Future<String> stringFuture : futureList) {
                System.out.println(stringFuture.get());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
