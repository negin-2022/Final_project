// Category.java - کلاس دسته‌بندی

import java.util.ArrayList; // ایمپورت کردن کلاس ArrayList از پکیج java.util
import java.util.List; // ایمپورت کردن کلاس List از پکیج java.util

// تعریف کلاس Category
public class Category {
    private String name; // نام دسته‌بندی
    private List<Category> subcategories; // لیست دسته‌بندی‌های فرعی
    private Category parentCategory; // دسته‌بندی والد

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Category(String name) {
        this.name = name; // مقداردهی اولیه به متغیر name با مقدار ورودی
        this.subcategories = new ArrayList<>(); // مقداردهی اولیه به لیست دسته‌بندی‌های فرعی به صورت لیست خالی
        this.parentCategory = null; // در ابتدا، هیچ دسته‌بندی والدی ندارد
    }

    // متدهای getter برای دسترسی به متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public String getName() {
        return name; // برگرداندن مقدار متغیر name
    }

    public List<Category> getSubcategories() {
        return subcategories; // برگرداندن لیست دسته‌بندی‌های فرعی
    }

    public Category getParentCategory() {
        return parentCategory; // برگرداندن دسته‌بندی والد
    }

    // متدهای setter برای تغییر مقادیر متغیرهای خصوصی (private) یا محافظت شده
    // (protected)
    public void setName(String name) {
        this.name = name; // تنظیم مقدار جدید برای متغیر name
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory; // تنظیم دسته‌بندی والد
        this.name = parentCategory.getName() + " - " + this.name; // به‌روزرسانی نام دسته‌بندی با اضافه کردن نام
                                                                  // دسته‌بندی والد
    }

    // متد برای اضافه کردن دسته‌بندی فرعی
    public void addSubcategory(Category subcategory) {
        subcategories.add(subcategory); // اضافه کردن دسته‌بندی فرعی به لیست
        subcategory.setParentCategory(this); // تنظیم دسته‌بندی والد برای دسته‌بندی فرعی
    }

    // متد toString برای نمایش بهتر دسته‌بندی
    @Override
    public String toString() {
        return name; // برگرداندن نام دسته‌بندی
    }
}
