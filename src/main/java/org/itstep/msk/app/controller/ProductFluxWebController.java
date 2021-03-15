package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public class ProductFluxWebController {

    private  final WebClient webClient = WebClient.create("http://localhost:8089");

    @GetMapping
    public Flux<Product> getProduct() {
        return webClient.get().uri("/getproduct")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Product.class);

    }

    @GetMapping("/exchange")
    public Flux<Product> exchangeProduct() {
        return webClient.get()
                .uri("/exproduct")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(
                        pr -> pr.bodyToFlux(Product.class)
                );


    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable("id") Integer id) {
        return webClient.get()

                .uri("/product/{id}", id)

                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Product.class);


    }

    @PostMapping(value = "/product")
    public Mono<Product> createProduct(@RequestBody Product prod) {
        return webClient.post().uri("/product")
                .accept(MediaType.APPLICATION_JSON)

                .body(BodyInserters.fromObject(prod))
                .retrieve()
                .bodyToMono(Product.class);



    }

    @PutMapping("/product")
    public Mono<Product> updateProduct(@RequestBody Product prod, @RequestParam("name_product") String name, @RequestParam("final_price") Double totalPrice) {
        return webClient.put().uri("/product", name, totalPrice)
                .accept(MediaType.APPLICATION_JSON)
                .syncBody(prod)
                .retrieve()
                .bodyToMono(Product.class);


    }

    @DeleteMapping("/productdel{id}")
    public Mono<Void> deleteProductById (
            @RequestBody Product product, @PathVariable("id") Integer id){

        return webClient.delete().uri("/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Void.class);

    }








}

