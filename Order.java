// Order.java - کلاس سفارش

import java.util.ArrayList; // ایمپورت کردن کلاس ArrayList از پکیج java.util
import java.util.List; // ایمپورت کردن کلاس List از پکیج java.util

// تعریف کلاس Order
public class Order {
    private List<OrderItem> products; // لیست محصولات سفارش
    private double totalCost; // هزینه کل سفارش
    private boolean status; // وضعیت سفارش (تحویل شده یا در انتظار)
    private int user_id; // شناسه کاربر که سفارش را ثبت کرده است

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Order(List<OrderItem> products, int user_id) {
        this.products = new ArrayList<>(); // مقداردهی اولیه به لیست محصولات
        this.products = products; // تنظیم لیست محصولات با مقدار ورودی
        this.user_id = user_id; // مقداردهی اولیه به شناسه کاربر با مقدار ورودی
        this.status = false; // وضعیت اولیه سفارش در انتظار است

        // محاسبه هزینه کل سفارش
        calculateTotalCost();
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public List<OrderItem> getProducts() {
        return products; // برگرداندن لیست محصولات
    }

    public double getTotalCost() {
        return totalCost; // برگرداندن هزینه کل سفارش
    }

    public boolean getStatus() {
        return status; // برگرداندن وضعیت سفارش
    }

    public int getUserID() {
        return user_id; // برگرداندن شناسه کاربر
    }

    // متد setter برای تغییر وضعیت سفارش
    public void setStatus(boolean status) {
        this.status = status; // تنظیم وضعیت جدید برای سفارش
    }

    // متد محاسبه هزینه کل سفارش
    private void calculateTotalCost() {
        totalCost = 0.0; // مقداردهی اولیه به هزینه کل
        for (OrderItem product : products) { // پیمایش لیست محصولات
            totalCost += product.getPrice() * product.getQuantity(); // محاسبه هزینه کل بر اساس قیمت و تعداد هر محصول
        }
    }

    // متد toString برای نمایش بهتر سفارش
    public String toString() {
        String s = ""; // ایجاد یک رشته خالی برای شروع
        s += "User ID: " + user_id + "\n"; // اضافه کردن شناسه کاربر به رشته s
        s += "Status: " + (status ? "Delivered" : "Pending") + "\n"; // اضافه کردن وضعیت سفارش به رشته s
        s += "Total cost: " + totalCost + "\n"; // اضافه کردن هزینه کل به رشته s
        s += "Products:\n"; // اضافه کردن عنوان محصولات به رشته s
        for (OrderItem product : products) { // پیمایش لیست محصولات
            s += product.getProduct_name() + " - " + product.getQuantity() + " - " + product.getPrice() + "\n"; // اضافه
                                                                                                                // کردن
                                                                                                                // جزئیات
                                                                                                                // هر
                                                                                                                // محصول
                                                                                                                // به
                                                                                                                // رشته
                                                                                                                // s
        }
        s += "===========================\n"; // اضافه کردن یک خط جداکننده برای تمیز کردن خروجی
        return s; // برگرداندن رشته s که حاوی تمام اطلاعات است
    }
}
