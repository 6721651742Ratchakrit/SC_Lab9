
import java.util.List;
import java.util.stream.*;

public class ProductAnalytics {
    private List<Product> productCatalog;

    public ProductAnalytics(List<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    // TODO: Refactor เมธอดทั้งหมดด้านล่างนี้ให้ใช้ Stream API

    /**
     * ค้นหาสินค้าทั้งหมดในหมวดหมู่ที่กำหนด
     */
    public List<Product> findProductsByCategory(String category) {
        List<Product> results = productCatalog.stream()
        .filter(p -> p.category()
        .equalsIgnoreCase(category))
        .collect(Collectors.toList());
        return results;
    }

    /**
     * คืนค่า "ชื่อ" ของสินค้าทั้งหมดที่มีราคาต่ำกว่าที่กำหนด
     */
    public List<String> getProductNamesWithPriceLessThan(double maxPrice) {
        List<String> results = productCatalog.stream()
        .filter(p -> p.price() < maxPrice)
        .map(p -> p.name())
        .collect(Collectors.toList());
        return results;
    }

    /**
     * คำนวณมูลค่ารวมของสต็อกสินค้าในหมวดหมู่ที่กำหนด
     */
    public double calculateTotalStockValueForCategory(String category) {
        double totalValue = productCatalog.stream()
        .filter(p -> p.category().equalsIgnoreCase(category))
        .mapToDouble(p ->  p.price() * p.stock())
        .sum();
        return totalValue;
    }

    /**
     * ตรวจสอบว่ามีสินค้าที่หมดสต็อก (stock = 0) หรือไม่
     */
    public boolean hasProductOutOfStock() {
        return productCatalog.stream()
        .filter(p -> p.stock() == 0)
        .count() != 0;
        
    }
}
