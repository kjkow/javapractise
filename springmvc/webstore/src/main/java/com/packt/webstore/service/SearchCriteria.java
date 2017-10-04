package com.packt.webstore.service;

/**
 * Created by kamil on 2017-10-04.
 */
public class SearchCriteria {
    private boolean searchAllProducts;
    private String category;
    private String type;
    private String id;

    public boolean isSearchAllProducts() {
        return searchAllProducts;
    }

    public void setSearchAllProducts(boolean searchAllProducts) {
        this.searchAllProducts = searchAllProducts;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
