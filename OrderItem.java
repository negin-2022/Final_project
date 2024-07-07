public class OrderItem {
    private int product_id; // شناسه محصول
    private int quantity; // تعداد محصول
    private String product_name; // نام محصول
    private double price; // قیمت محصول

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public OrderItem(int product_id, String product_name, int quantity, double price) {
        this.product_id = product_id; // مقداردهی اولیه به شناسه محصول با مقدار ورودی
        this.quantity = quantity; // مقداردهی اولیه به تعداد محصول با مقدار ورودی
        this.product_name = product_name; // مقداردهی اولیه به نام محصول با مقدار ورودی
        this.price = price; // مقداردهی اولیه به قیمت محصول با مقدار ورودی
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private)
    public double getPrice() {
        return price; // برگرداندن مقدار قیمت محصول
    }

    public int getProduct_id() {
        return product_id; // برگرداندن مقدار شناسه محصول
    }

    public int getQuantity() {
        return quantity; // برگرداندن مقدار تعداد محصول
    }

    public String getProduct_name() {
        return product_name; // برگرداندن مقدار نام محصول
    }

    // متدهای setter برای تغییر مقادیر متغیرهای خصوصی (private)
    public void setProduct_id(int product_id) {
        this.product_id = product_id; // تنظیم مقدار جدید برای شناسه محصول
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; // تنظیم مقدار جدید برای تعداد محصول
    }
}
