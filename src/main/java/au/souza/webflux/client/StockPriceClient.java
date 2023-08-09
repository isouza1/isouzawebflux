package au.souza.webflux.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class StockPriceClient {

    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080");

        String[] symbols = {"AAPL", "GOOG", "MSFT"}; // The stock symbols to subscribe to

        // Create a Flux for each symbol and merge them into a single Flux
        // Flux<Object> stockPriceUpdates = Flux.merge(
        //         Flux.fromArray(symbols)
        //             .flatMap(symbol -> webClient.get()
        //                     .uri("/stocks/{symbol}", symbol)
        //                     .retrieve()
        //                     .bodyToFlux(StockPrice.class))
        // );
        
//        stockPriceUpdates.subscribe(stockPrice -> {
//            System.out.println("Received stock price update for " + stockPrice.getSymbol() + ": " + stockPrice.getPrice());
//        });
    }

    public static class StockPrice {
        private String symbol;
        private double price;

        // Getters and setters

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
