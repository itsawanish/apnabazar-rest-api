package com.apnabazar.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnabazar.app.entity.ProductEntity;
import com.apnabazar.app.repository.ProductRepository;
import com.apnabazar.app.request.ProductRequest;

@Service
public class ProductService {

	@Autowired
    private ProductRepository repo ;

    public ProductEntity create(ProductRequest r) {
    	ProductEntity p = new ProductEntity();
        p.setName(r.name);
        p.setPrice(r.price);
        p.setCategory(r.category);
        p.setDescription(r.description);

        repo.save(p);
        return p;
    }

    public List<ProductEntity> search(String name) {
        return repo.search(name);
    }
}
