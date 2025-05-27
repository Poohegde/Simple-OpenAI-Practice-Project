package ai.generator;

import java.net.URI;
import java.net.http.*;
import org.json.*;

public class GPTClient {
    private final String apiKey = System.getenv("OPENAI_API_KEY");
    private final HttpClient client = HttpClient.newHttpClient();

    public String generateMethodStub(String description) throws Exception {
        String prompt = "Generate a Java method stub (signature + Javadoc comment) for this description:\n" + description;

        JSONObject message = new JSONObject()
            .put("model", "gpt-3.5-turbo")
            .put("messages", new JSONArray()
                .put(new JSONObject()
                    .put("role", "user")
                    .put("content", prompt)));

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.openai.com/v1/chat/completions"))
            .header("Authorization", "Bearer " + apiKey)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(message.toString()))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseBody = new JSONObject(response.body());

        if (!responseBody.has("choices")) {
            throw new RuntimeException("API response missing 'choices': " + response.body());
        }

        return responseBody
            .getJSONArray("choices")
            .getJSONObject(0)
            .getJSONObject("message")
            .getString("content")
            .trim();
    }
}
