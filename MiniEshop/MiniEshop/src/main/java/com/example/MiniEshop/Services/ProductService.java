package com.example.MiniEshop.Services;

import com.example.MiniEshop.Models.Product;
import com.example.MiniEshop.ProductRequest;
import com.example.MiniEshop.Repositories.ProductRepo;
import com.example.MiniEshop.ServiceResults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ServiceResults addProduct (ProductRequest request){

        Optional<Product> product = productRepo.findByName (request.getName());
        if(product.isPresent()){

            return new ServiceResults("Already exists","error",400);

        }
        productRepo.save(new Product(request.getName(),request.getPrice(),request.getStock()));

        return new ServiceResults("Product created","success",200);

    }


}
