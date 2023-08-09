package au.souza.webflux.service;

import au.souza.webflux.model.StockPrice;

import java.time.Duration;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StockPriceService {

  private final Random random = new Random();

  public Flux<StockPrice> getStockPriceUpdates(String symbol) {
    // Return a Flux that emits a new stock price for the given symbol every second
    return Flux
      .interval(Duration.ofSeconds(1))
      .map(interval -> new StockPrice(symbol, randomPrice()));
    // Return a Flux that emits a new stock price for the given symbol every second, and take only 10 values
    //  return Flux.interval(Duration.ofSeconds(1))
    //  .take(10) // Take only 10 values before completing the Flux  ... just like RXJS take
    //  .map(interval -> new StockPrice(symbol, randomPrice()));

  }

  private double randomPrice() {
    return 100 + random.nextDouble() * 10; // Random price between 100 and 110
  }
}
