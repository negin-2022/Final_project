// Product.java - کلاس محصول

import java.util.ArrayList; // ایمپورت کردن کلاس ArrayList از پکیج java.util
import java.util.HashMap; // ایمپورت کردن کلاس HashMap از پکیج java.util
import java.util.List; // ایمپورت کردن کلاس List از پکیج java.util
import java.util.Map; // ایمپورت کردن کلاس Map از پکیج java.util

// تعریف کلاس Product
public class Product {
    private int seller_id; // شناسه فروشنده
    private String name; // نام محصول
    private double price; // قیمت محصول
    private int stockQuantity; // موجودی انبار
    private List<String> comments; // لیست نظرات کاربران
    private String category; // دسته‌بندی محصول
    private Map<String, String> additionalData; // داده‌های اضافی محصول (به صورت کلید-مقدار)

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Product(int seller_id, String name, double price, int stockQuantity, String category) {
        this.seller_id = seller_id; // مقداردهی اولیه به شناسه فروشنده با مقدار ورودی
        this.name = name; // مقداردهی اولیه به نام محصول با مقدار ورودی
        this.price = price; // مقداردهی اولیه به قیمت محصول با مقدار ورودی
        this.stockQuantity = stockQuantity; // مقداردهی اولیه به موجودی انبار با مقدار ورودی
        this.comments = new ArrayList<>(); // مقداردهی اولیه به لیست نظرات
        this.category = category; // مقداردهی اولیه به دسته‌بندی محصول با مقدار ورودی
        this.additionalData = new HashMap<>(); // مقداردهی اولیه به داده‌های اضافی
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private)
    public int getSeller_id() {
        return seller_id; // برگرداندن مقدار شناسه فروشنده
    }

    public String getName() {
        return name; // برگرداندن مقدار نام محصول
    }

    public double getPrice() {
        return price; // برگرداندن مقدار قیمت محصول
    }

    public int getStockQuantity() {
        return stockQuantity; // برگرداندن مقدار موجودی انبار
    }

    public List<String> getComments() {
        return comments; // برگرداندن لیست نظرات کاربران
    }

    public String getCategory() {
        return category; // برگرداندن مقدار دسته‌بندی محصول
    }

    public Map<String, String> getAdditionalData() {
        return additionalData; // برگرداندن داده‌های اضافی محصول
    }

    // متدهای setter برای تغییر مقادیر متغیرهای خصوصی (private)
    public void setPrice(double price) {
        this.price = price; // تنظیم مقدار جدید برای قیمت محصول
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity; // تنظیم مقدار جدید برای موجودی انبار
    }

    public void setCategory(String category) {
        this.category = category; // تنظیم مقدار جدید برای دسته‌بندی محصول
    }

    // متدهای دیگر
    public void addComment(String comment) {
        comments.add(comment); // اضافه کردن نظر جدید به لیست نظرات
    }

    public void addAdditionalData(String key, String value) {
        additionalData.put(key, value); // اضافه کردن داده اضافی جدید به داده‌های اضافی
    }

    // متد کاهش موجودی (هنگام خرید)
    public void decreaseStock(int quantity) {
        if (quantity <= stockQuantity) { // بررسی موجودی انبار
            stockQuantity -= quantity; // کاهش موجودی انبار
        } else {
            // در صورت کمبود موجودی، می‌توان خطا ایجاد کرد یا پیغام مناسب نمایش داد.
            System.out.println("Not enough stock for product: " + name); // نمایش پیغام خطا در صورت کمبود موجودی
        }
    }

    // متد toString برای نمایش بهتر محصول
    public String toString() {
        String s = ""; // ایجاد یک رشته خالی برای شروع
        s += "Seller ID: " + seller_id + "\n"; // اضافه کردن شناسه فروشنده به رشته s
        s += "Name: " + name + "\n"; // اضافه کردن نام محصول به رشته s
        s += "Price: " + price + "\n"; // اضافه کردن قیمت محصول به رشته s
        s += "Stock Quantity: " + stockQuantity + "\n"; // اضافه کردن موجودی انبار به رشته s
        s += "Category: " + category + "\n"; // اضافه کردن دسته‌بندی محصول به رشته s
        s += "Comments:\n"; // اضافه کردن عنوان نظرات به رشته s
        for (String comment : comments) { // پیمایش لیست نظرات
            s += comment + "\n"; // اضافه کردن هر نظر به رشته s
        }
        s += "Additional Data:\n"; // اضافه کردن عنوان داده‌های اضافی به رشته s
        for (Map.Entry<String, String> entry : additionalData.entrySet()) { // پیمایش داده‌های اضافی
            s += entry.getKey() + ": " + entry.getValue() + "\n"; // اضافه کردن هر داده به رشته s
        }
        return s; // برگرداندن رشته s که حاوی تمام اطلاعات است
    }
}
