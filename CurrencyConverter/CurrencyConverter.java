import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            try {
                
                System.out.println("===== REAL TIME CURRENCY CONVERTER =====");
                
                System.out.print("Enter Base Currency (USD, INR, EUR): ");
                String baseCurrency = sc.nextLine().toUpperCase();
                
                System.out.print("Enter Target Currency: ");
                String targetCurrency = sc.nextLine().toUpperCase();
                
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                
                String apiKey = "114523b033238c6786b3b96a";
                
                String url =
                        "https://v6.exchangerate-api.com/v6/"
                        + apiKey
                        + "/latest/"
                        + baseCurrency;
                
                HttpClient client = HttpClient.newHttpClient();
                
                HttpRequest request =
                        HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
                
                HttpResponse<String> response =
                        client.send(
                                request,
                                HttpResponse.BodyHandlers.ofString()
                        );
                
                String json = response.body();
                
                String searchText =
                        "\"" + targetCurrency + "\":";
                
                int start =
                        json.indexOf(searchText)
                        + searchText.length();
                
                int end =
                        json.indexOf(",", start);
                
                if(end == -1) {
                    end = json.indexOf("}", start);
                }
                
                double exchangeRate =
                        Double.parseDouble(
                                json.substring(start, end)
                        );
                
                double convertedAmount =
                        amount * exchangeRate;
                
                System.out.println("\nExchange Rate: "
                        + exchangeRate);
                
                System.out.println("Converted Amount: "
                        + convertedAmount + " "
                        + targetCurrency);
                
            }
            catch(IOException | InterruptedException | NumberFormatException e) {
                
                System.out.println(
                        "Error fetching exchange rates."
                );
                
            }

        }    }
}