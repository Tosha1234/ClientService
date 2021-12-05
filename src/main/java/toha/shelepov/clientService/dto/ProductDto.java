package toha.shelepov.clientService.dto;


import toha.shelepov.clientService.model.Product;

public class ProductDto {

    private String id;
    private String name;
    private String price;
    private String weight;
    private String height;
    private String width;
    private String count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    public Product getProduct() {
        Product product=new Product();
        product.setId(Integer.parseInt(this.getId()));
//        product.set(Integer.parseInt(this.getId()));
        product.setId(Integer.parseInt(this.getId()));
        product.setId(Integer.parseInt(this.getId()));
        return product;
    }
}
