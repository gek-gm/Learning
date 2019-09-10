package smell;

class LineItem {
    private int _productId;
    private int _imageId;
    private int _quantity;
    private double _unitPrice;
 
    public LineItem(int productId, int imageId, int quantity) {
        _productId = productId;
        _imageId = imageId;
        _quantity = quantity;
    }
    int getProductId() {
        return _productId;
    }
 
    int getImageId() {
        return _imageId;
    }
 
    int getQuantity() {
        return _quantity;
    }
 
    double getUnitPrice() {
        return _unitPrice;
    }
 
    void setProductId(int id) {
        _productId = id;
    }
 
    void setImageID(int id) {
        _imageId = id;
    }
 
    void setQuantity(int quantity) {
        _quantity = quantity;
    }
 
    void setUnitPrice(int price) {
        _unitPrice = price;
    }
    
    double getTotal() {
        return _unitPrice * _quantity;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Begin Line Item");
        sb.append("Product = " + getProductId());
        sb.append("Image = " + getImageId());
        sb.append("Quantity = " + getQuantity());
        sb.append("Total = " + getTotal());
        sb.append("End Line Item");
        return sb.toString();
    }
}