// Admin.java - کلاس مدیر

// تعریف کلاس Admin که از کلاس Account ارث‌بری می‌کند
public class Admin extends Account {
    private int id; // شناسه منحصر به فرد برای هر مدیر

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Admin(String username, String password, String email, int id) {
        super(username, password, email); // فراخوانی سازنده کلاس پایه (Account) برای مقداردهی به متغیرهای آن
        this.id = id; // مقداردهی اولیه به متغیر id با مقدار ورودی
    }

    // متد getter برای دسترسی به متغیر id
    public int getId() {
        return id; // برگرداندن مقدار متغیر id
    }

    // متد برای اضافه کردن کاربر جدید به فروشگاه
    public void addUser(User user, Shop shop) {
        shop.getAccounts().add(user); // اضافه کردن کاربر به لیست حساب‌های فروشگاه
    }

    // متد برای حذف کاربر از فروشگاه
    public void removeUser(User user, Shop shop) {
        shop.getAccounts().remove(user); // حذف کاربر از لیست حساب‌های فروشگاه
    }

    // متد برای تایید فروشنده
    public void approveSeller(Seller seller) {
        seller.setApproved(true); // تنظیم وضعیت تایید فروشنده به true
    }

    // متد برای اضافه کردن محصول جدید به فروشگاه
    public void addProduct(Product product, Shop shop) {
        shop.getProducts().add(product); // اضافه کردن محصول به لیست محصولات فروشگاه
    }

    // متد برای حذف محصول از فروشگاه
    public void removeProduct(Product product, Shop shop) {
        shop.getProducts().remove(product); // حذف محصول از لیست محصولات فروشگاه
    }

}
