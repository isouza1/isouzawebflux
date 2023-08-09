package au.souza.webflux.controller;

import au.souza.webflux.model.StockPrice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import au.souza.webflux.service.StockPriceService;

import reactor.core.publisher.Flux;

@RestController
public class StockPriceController {

    private final StockPriceService stockPriceService;

    public StockPriceController(StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @GetMapping(value = "/stocks/{symbol}", produces = "text/event-stream")
    public Flux<StockPrice> getStockPrices(@PathVariable String symbol) {
        return stockPriceService.getStockPriceUpdates(symbol);
    }
}
