package codevkook.study;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {

            ClientConfig conf = new DefaultClientConfig();
            conf.getFeatures().get()

            Client client = Client.create(conf);

            WebResource webResource = client.resource("http://localhost:9090/JerseyJSONExample/rest/jsonServices/send");

            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, st);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Server response .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }


    }
}
