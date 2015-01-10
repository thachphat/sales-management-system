package models;

import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinh on 1/4/15.
 */
public class Product {

    private static List<Product> products;

    static{
        products = new ArrayList<Product>();
        products.add(new Product("11111","Paperclip 1","Paperclip description 1"));
        products.add(new Product("22222","Paperclip 2","Paperclip description 2"));
        products.add(new Product("33333","Paperclip 3","Paperclip description 3"));
        products.add(new Product("44444","Paperclip 4","Paperclip description 4"));
        products.add(new Product("55555","Paperclip 5","Paperclip description 5"));

    }

    @Constraints.Required
    public String ean;
    @Constraints.Required
    public String name;
    public String description;

    public Product() {}

    public Product(String ean, String name, String description){
        this.ean = ean;
        this.name = name;
        this.description = description;
    }

    public  String toString(){
        return String.format("%s - %s",ean,name);
    }

    public static List<Product> findAll(){
        return new ArrayList<Product>(products);
    }

    public static Product findByEan(String ean){
        for (Product candidate: products){
            if (candidate.ean.equals(ean)){
                return candidate;
            }
        }
        return null;
    }

    public static List<Product> findByName(String term){
        final List<Product> results = new ArrayList<Product>();
        for (Product candidate: products){
            if(candidate.name.toLowerCase().contains(term.toLowerCase())){
                results.add(candidate);
            }
        }
        return results;
    }

    public static boolean remove(Product product){
        return products.remove(product);
    }

    public void save(){
        products.remove(findByEan(this.ean));
        products.add(this);
    }

}
