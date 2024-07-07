// Seller.java - کلاس فروشنده

import java.util.List; // ایمپورت کردن کلاس List از پکیج java.util

// تعریف کلاس Seller که از کلاس Account ارث‌بری می‌کند
public class Seller extends Account {
    private String companyName; // نام شرکت فروشنده
    private double wallet; // کیف پول فروشنده
    private boolean isApproved; // وضعیت تأیید فروشنده
    private int id; // شناسه منحصر به فرد فروشنده

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Seller(String username, String password, String email, int id, String companyName) {
        super(username, password, email); // فراخوانی سازنده کلاس پایه (Account) برای مقداردهی به متغیرهای آن
        this.id = id; // مقداردهی اولیه به متغیر id با مقدار ورودی
        this.companyName = companyName; // مقداردهی اولیه به متغیر companyName با مقدار ورودی
        this.wallet = 0.0; // مقداردهی اولیه به کیف پول با مقدار صفر
        this.isApproved = false; // فروشنده در ابتدا تأیید نشده است
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public String getCompanyName() {
        return companyName; // برگرداندن مقدار متغیر companyName
    }

    public int getId() {
        return id; // برگرداندن مقدار متغیر id
    }

    public double getWallet() {
        return wallet; // برگرداندن مقدار کیف پول
    }

    public boolean isApproved() {
        return isApproved; // برگرداندن وضعیت تأیید فروشنده
    }

    // متدهای setter برای تغییر مقادیر متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public void setCompanyName(String companyName) {
        this.companyName = companyName; // تنظیم مقدار جدید برای متغیر companyName
    }

    public void setApproved(boolean approved) {
        isApproved = approved; // تنظیم وضعیت تأیید فروشنده
    }

    // متد برای دریافت پرداخت و اضافه کردن به کیف پول
    public void receivePayment(double amount) {
        if (amount > 0) { // بررسی اینکه مقدار پرداخت مثبت است
            wallet += amount; // اضافه کردن مقدار به کیف پول
        }
    }

    // متد برای نمایش اطلاعات فروشنده به همراه محصولاتش
    public String info(List<Product> products) {
        String s = super.info(); // استفاده از متد info کلاس پایه (Account) برای گرفتن اطلاعات پایه
        s += "Company Name: " + companyName + "\n"; // اضافه کردن نام شرکت به رشته s
        s += "Wallet: " + wallet + "\n"; // اضافه کردن مقدار کیف پول به رشته s
        s += "Approved: " + (isApproved ? "Yes" : "No") + "\n"; // اضافه کردن وضعیت تأیید فروشنده به رشته s
        s += "Products:\n"; // اضافه کردن عنوان محصولات به رشته s
        for (Product product : products) { // پیمایش لیست محصولات
            if (product.getSeller_id() == id) { // بررسی اینکه محصول متعلق به فروشنده جاری است یا خیر
                s += product.toString() + "\n"; // اضافه کردن جزئیات محصول به رشته s
            }
        }
        s += "-----------------------------------------------------\n"; // اضافه کردن یک خط جداکننده برای تمیز کردن
                                                                        // خروجی
        return s; // برگرداندن رشته s که حاوی تمام اطلاعات است
    }
}
