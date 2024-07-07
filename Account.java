// Account.java - کلاس پایه برای انواع حساب‌های کاربری

import java.util.List; // ایمپورت کردن کلاس List از پکیج java.util

// تعریف یک کلاس انتزاعی به نام Account که به عنوان پایه‌ای برای انواع حساب‌های کاربری استفاده می‌شود
public abstract class Account {
    // تعریف متغیرهای protected که فقط در همین کلاس و زیرکلاس‌ها قابل دسترسی هستند
    protected String username; // نام کاربری حساب
    protected String password; // رمز عبور حساب
    protected String email; // ایمیل حساب

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Account(String username, String password, String email) {
        this.username = username; // مقداردهی اولیه به متغیر username با مقدار ورودی
        this.password = password; // مقداردهی اولیه به متغیر password با مقدار ورودی
        this.email = email; // مقداردهی اولیه به متغیر email با مقدار ورودی
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public String getUsername() {
        return username; // برگرداندن مقدار متغیر username
    }

    public String getPassword() {
        return password; // برگرداندن مقدار متغیر password
    }

    public String getEmail() {
        return email; // برگرداندن مقدار متغیر email
    }

    // متدهای setter برای تغییر مقادیر متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public void setPassword(String password) {
        this.password = password; // تنظیم مقدار جدید برای متغیر password
    }

    public void setEmail(String email) {
        this.email = email; // تنظیم مقدار جدید برای متغیر email
    }

    public void setUsername(String username) {
        this.username = username; // تنظیم مقدار جدید برای متغیر username
    }

    // متد info برای نمایش اطلاعات حساب به صورت رشته
    public String info() {
        String s = ""; // ایجاد یک رشته خالی برای ذخیره اطلاعات
        s += "Username: " + username + "\n"; // اضافه کردن نام کاربری به رشته s
        s += "Password: " + password + "\n"; // اضافه کردن رمز عبور به رشته s
        s += "Email: " + email + "\n"; // اضافه کردن ایمیل به رشته s
        return s; // برگرداندن رشته s که حاوی اطلاعات حساب است
    }

    // متد info با پارامترهای لیست سفارشات و شناسه برای نمایش اطلاعات حساب
    public String info(List<Order> orders, int id) {
        String s = ""; // ایجاد یک رشته خالی برای ذخیره اطلاعات
        s += "Username: " + username + "\n"; // اضافه کردن نام کاربری به رشته s
        s += "Password: " + password + "\n"; // اضافه کردن رمز عبور به رشته s
        s += "Email: " + email + "\n"; // اضافه کردن ایمیل به رشته s
        // در این متد اطلاعات مربوط به سفارشات و شناسه به رشته s اضافه نمی‌شود، می‌توان
        // آن را بهبود داد
        return s; // برگرداندن رشته s که حاوی اطلاعات حساب است
    }

    // متد info با پارامتر لیست محصولات برای نمایش اطلاعات حساب
    public String info(List<Product> products) {
        String s = ""; // ایجاد یک رشته خالی برای ذخیره اطلاعات
        s += "Username: " + username + "\n"; // اضافه کردن نام کاربری به رشته s
        s += "Password: " + password + "\n"; // اضافه کردن رمز عبور به رشته s
        s += "Email: " + email + "\n"; // اضافه کردن ایمیل به رشته s
        // در این متد اطلاعات مربوط به محصولات به رشته s اضافه نمی‌شود، می‌توان آن را
        // بهبود داد
        return s; // برگرداندن رشته s که حاوی اطلاعات حساب است
    }
}
