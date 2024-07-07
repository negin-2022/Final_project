// User.java - کلاس کاربر

import java.util.ArrayList; // ایمپورت کردن کلاس ArrayList از پکیج java.util
import java.util.List; // ایمپورت کردن کلاس List از پکیج java.util

// تعریف کلاس User که از کلاس Account ارث‌بری می‌کند
public class User extends Account {
    private String phoneNumber; // شماره تلفن کاربر
    private String address; // آدرس کاربر
    private List<OrderItem> cart; // سبد خرید کاربر
    private List<OrderItem> purchasedProducts; // لیست محصولات خریداری شده
    private double wallet; // کیف پول کاربر

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public User(String username, String password, String email, String phoneNumber, String address) {
        super(username, password, email); // فراخوانی سازنده کلاس پایه (Account) برای مقداردهی به متغیرهای آن
        this.phoneNumber = phoneNumber; // مقداردهی اولیه به متغیر phoneNumber با مقدار ورودی
        this.address = address; // مقداردهی اولیه به متغیر address با مقدار ورودی
        this.cart = new ArrayList<>(); // مقداردهی اولیه به سبد خرید به صورت لیست خالی
        this.purchasedProducts = new ArrayList<>(); // مقداردهی اولیه به لیست محصولات خریداری شده به صورت لیست خالی
        this.wallet = 0.0; // مقداردهی اولیه به کیف پول با مقدار صفر
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public String getPhoneNumber() {
        return phoneNumber; // برگرداندن مقدار متغیر phoneNumber
    }

    public String getAddress() {
        return address; // برگرداندن مقدار متغیر address
    }

    public List<OrderItem> getCart() {
        return cart; // برگرداندن لیست سبد خرید
    }

    public List<OrderItem> getPurchasedProducts() {
        return purchasedProducts; // برگرداندن لیست محصولات خریداری شده
    }

    public double getWallet() {
        return wallet; // برگرداندن مقدار کیف پول
    }

    // متدهای setter برای تغییر مقادیر متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber; // تنظیم مقدار جدید برای متغیر phoneNumber
    }

    public void setAddress(String address) {
        this.address = address; // تنظیم مقدار جدید برای متغیر address
    }

    // متدهای مربوط به سبد خرید
    public void addToCart(OrderItem product) {
        cart.add(product); // اضافه کردن محصول به سبد خرید
    }

    public void addToPurchasedProducts(OrderItem product) {
        purchasedProducts.add(product); // اضافه کردن محصول به لیست محصولات خریداری شده
    }

    public void removeFromCart(OrderItem product) {
        cart.remove(product); // حذف محصول از سبد خرید
    }

    public void clearCart() {
        cart = new ArrayList<>(); // خالی کردن سبد خرید با ایجاد یک لیست جدید
    }

    // متد مربوط به شارژ کیف پول
    public void chargeWallet(double amount) {
        wallet += amount; // اضافه کردن مقدار به کیف پول
    }

    // متد برای نمایش اطلاعات کاربر به همراه سفارشات
    public String info(List<Order> orders, int user_id) {
        String s = super.info(); // استفاده از متد info کلاس پایه (Account) برای گرفتن اطلاعات پایه
        s += "Phone number: " + phoneNumber + "\n"; // اضافه کردن شماره تلفن به رشته s
        s += "Address: " + address + "\n"; // اضافه کردن آدرس به رشته s
        s += "Wallet: " + wallet + "\n"; // اضافه کردن مقدار کیف پول به رشته s
        s += "Cart:\n"; // اضافه کردن عنوان سبد خرید به رشته s

        for (OrderItem product : cart) { // پیمایش لیست سبد خرید
            s += product.getProduct_name() + " - " + product.getQuantity() + " - " + product.getPrice() + "\n"; // اضافه
                                                                                                                // کردن
                                                                                                                // جزئیات
                                                                                                                // هر
                                                                                                                // محصول
                                                                                                                // به
                                                                                                                // رشته
                                                                                                                // s
        }
        s += "Purchased products:\n"; // اضافه کردن عنوان محصولات خریداری شده به رشته s
        for (OrderItem product : purchasedProducts) { // پیمایش لیست محصولات خریداری شده
            s += product.getProduct_name() + " - " + product.getQuantity() + " - " + product.getPrice() + "\n"; // اضافه
                                                                                                                // کردن
                                                                                                                // جزئیات
                                                                                                                // هر
                                                                                                                // محصول
                                                                                                                // به
                                                                                                                // رشته
                                                                                                                // s
        }
        s += "Orders:\n"; // اضافه کردن عنوان سفارشات به رشته s
        for (Order order : orders) { // پیمایش لیست سفارشات
            if (order.getUserID() == user_id) // بررسی اینکه سفارش متعلق به کاربر جاری است یا خیر
                s += order.toString(); // اضافه کردن جزئیات سفارش به رشته s
        }
        s += "-----------------------------------------------------\n"; // اضافه کردن یک خط جداکننده برای تمیز کردن
                                                                        // خروجی
        return s; // برگرداندن رشته s که حاوی تمام اطلاعات است
    }
}
