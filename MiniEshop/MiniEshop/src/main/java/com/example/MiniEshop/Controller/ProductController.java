package com.example.MiniEshop.Controller;

import com.example.MiniEshop.ProductRequest;
import com.example.MiniEshop.ServiceResults;
import com.example.MiniEshop.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ServiceResults> addProduct (@RequestBody ProductRequest request){

        try{

            ServiceResults result = service.addProduct(request);
            return new ResponseEntity<ServiceResults>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ServiceResults>(HttpStatus.BAD_REQUEST);
        }
    }
}
