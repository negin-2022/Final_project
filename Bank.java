public class Bank {
    private double money; // مقدار پول موجود در بانک
    private int user_id; // شناسه کاربری که به این حساب بانکی تعلق دارد

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public Bank(double money, int user_id) {
        this.money = money; // مقداردهی اولیه به متغیر money با مقدار ورودی
        this.user_id = user_id; // مقداردهی اولیه به متغیر user_id با مقدار ورودی
    }

    // متد getter برای دسترسی به مقدار پول موجود در بانک
    public double getMoney() {
        return money; // برگرداندن مقدار متغیر money
    }

    // متد getter برای دسترسی به شناسه کاربری
    public int getUserID() {
        return user_id; // برگرداندن مقدار متغیر user_id
    }
}
