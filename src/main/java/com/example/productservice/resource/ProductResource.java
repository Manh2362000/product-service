package com.example.productservice.resource;

import com.example.productservice.entity.Product;
import com.example.productservice.model.InMemoryModel;
import com.example.productservice.model.ProductModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class ProductResource {
    ProductModel productModel;

    public ProductResource(){
        productModel = new InMemoryModel();
    }

    @GET
    public List<Product> productlist() {
        return productModel.findall();
    }

    @GET
    @Path("{id}")
    public Product productdetail(@PathParam("id") int id) {
        return productModel.findbyid(id);
    }

    @POST
    public Product Create (Product product){
        return productModel.save(product);
    }

    @PUT
    @Path("{id}")
    public Product update (@PathParam("id")int id,Product product){
        return productModel.update(product,id);
    }

}