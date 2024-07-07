// Shop.java - کلاس فروشگاه

import java.util.ArrayList; // وارد کردن کلاس ArrayList از پکیج java.util
import java.util.List; // وارد کردن کلاس List از پکیج java.util
import java.util.Scanner; // وارد کردن کلاس Scanner از پکیج java.util

public class Shop {
    private String name; // نام فروشگاه
    private String webAddress; // آدرس وب فروشگاه
    private String supportNumber; // شماره پشتیبانی فروشگاه
    private List<Account> accounts; // لیست حساب‌های کاربری
    private List<Product> products; // لیست محصولات
    private List<Order> orders; // لیست سفارش‌ها
    private List<Category> categories; // لیست دسته‌بندی‌ها
    private List<String> categories_name; // لیست نام دسته‌بندی‌ها
    private List<Bank> banks; // لیست بانک‌ها
    private double totalProfit; // سود کل فروشگاه

    // سازنده (Constructor) برای مقداردهی اولیه به متغیرهای کلاس
    public void collectCategoryNames(List<Category> categories, List<String> categoryNamesList) {
        for (Category category : categories) { // پیمایش لیست دسته‌بندی‌ها
            categoryNamesList.add(category.getName()); // اضافه کردن نام دسته‌بندی به لیست نام دسته‌بندی‌ها
            collectCategoryNames(category.getSubcategories(), categoryNamesList); // فراخوانی بازگشتی برای دسته‌بندی‌های
                                                                                  // فرعی
        }
    }

    public Shop(String name, String webAddress, String supportNumber) {
        this.name = name; // مقداردهی اولیه به نام فروشگاه با مقدار ورودی
        this.webAddress = webAddress; // مقداردهی اولیه به آدرس وب فروشگاه با مقدار ورودی
        this.supportNumber = supportNumber; // مقداردهی اولیه به شماره پشتیبانی فروشگاه با مقدار ورودی
        this.accounts = new ArrayList<>(); // مقداردهی اولیه به لیست حساب‌های کاربری
        this.products = new ArrayList<>(); // مقداردهی اولیه به لیست محصولات
        this.orders = new ArrayList<>(); // مقداردهی اولیه به لیست سفارش‌ها
        this.banks = new ArrayList<>(); // مقداردهی اولیه به لیست بانک‌ها
        this.totalProfit = 0.0; // مقداردهی اولیه به سود کل فروشگاه با مقدار صفر

        // ایجاد یک مدیر پیش‌فرض
        Admin defaultAdmin = new Admin("admin", "1234", "admin@shop.com", 0); // ساخت یک مدیر پیش‌فرض
        accounts.add(defaultAdmin); // اضافه کردن مدیر پیش‌فرض به لیست حساب‌های کاربری

        this.categories = new ArrayList<>(); // مقداردهی اولیه به لیست دسته‌بندی‌ها
        this.categories.add(new Category("Electronics")); // اضافه کردن دسته‌بندی "Electronics" به لیست دسته‌بندی‌ها
        this.categories.add(new Category("Clothing")); // اضافه کردن دسته‌بندی "Clothing" به لیست دسته‌بندی‌ها
        this.categories.add(new Category("Books")); // اضافه کردن دسته‌بندی "Books" به لیست دسته‌بندی‌ها

        // اضافه کردن دسته‌بندی‌های فرعی به دسته‌بندی‌ها
        this.categories.get(0).addSubcategory(new Category("Laptops")); // اضافه کردن دسته‌بندی "Laptops" به دسته‌بندی
                                                                        // "Electronics"
        this.categories.get(0).addSubcategory(new Category("Phones")); // اضافه کردن دسته‌بندی "Phones" به دسته‌بندی
                                                                       // "Electronics"
        this.categories.get(1).addSubcategory(new Category("Shirts")); // اضافه کردن دسته‌بندی "Shirts" به دسته‌بندی
                                                                       // "Clothing"
        this.categories.get(1).addSubcategory(new Category("Pants")); // اضافه کردن دسته‌بندی "Pants" به دسته‌بندی
                                                                      // "Clothing"
        this.categories.get(2).addSubcategory(new Category("Novels")); // اضافه کردن دسته‌بندی "Novels" به دسته‌بندی
                                                                       // "Books"
        this.categories.get(2).addSubcategory(new Category("Poems")); // اضافه کردن دسته‌بندی "Poems" به دسته‌بندی
                                                                      // "Books"
        this.categories.get(2).getSubcategories().get(1).addSubcategory(new Category("Poems_1")); // اضافه کردن
                                                                                                  // دسته‌بندی "Poems_1"
                                                                                                  // به دسته‌بندی فرعی
                                                                                                  // "Poems"

        this.categories_name = new ArrayList<>(); // مقداردهی اولیه به لیست نام دسته‌بندی‌ها
        collectCategoryNames(categories, categories_name); // جمع‌آوری نام دسته‌بندی‌ها و اضافه کردن به لیست نام
                                                           // دسته‌بندی‌ها
    }
    // Getters

    /**
     * این تابع نام فروشگاه را برمی‌گرداند.
     * 
     * @return نام فروشگاه
     */
    public String getName() {
        return name;
    }

    /**
     * این تابع آدرس وب فروشگاه را برمی‌گرداند.
     * 
     * @return آدرس وب فروشگاه
     */
    public String getWebAddress() {
        return webAddress;
    }

    /**
     * این تابع شماره پشتیبانی فروشگاه را برمی‌گرداند.
     * 
     * @return شماره پشتیبانی فروشگاه
     */
    public String getSupportNumber() {
        return supportNumber;
    }

    /**
     * این تابع لیست حساب‌های کاربری فروشگاه را برمی‌گرداند.
     * 
     * @return لیست حساب‌های کاربری
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * این تابع لیست محصولات فروشگاه را برمی‌گرداند.
     * 
     * @return لیست محصولات
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * این تابع لیست سفارش‌های فروشگاه را برمی‌گرداند.
     * 
     * @return لیست سفارش‌ها
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * این تابع سود کل فروشگاه را برمی‌گرداند.
     * 
     * @return سود کل فروشگاه
     */
    public double getTotalProfit() {
        return totalProfit;
    }

    /**
     * این تابع عملیات ثبت‌نام کاربر جدید را انجام می‌دهد.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void registerUser(Scanner sc) {
        // عملیات ثبت‌نام کاربر

        // درخواست نام کاربری از کاربر
        System.out.println("username");
        String username = sc.nextLine();

        // درخواست کلمه عبور از کاربر
        System.out.println("password");
        String password = sc.nextLine();

        // درخواست ایمیل از کاربر
        System.out.println("email");
        String email = sc.nextLine();

        // درخواست شماره تلفن از کاربر
        System.out.println("phoneNumber");
        String phoneNumber = sc.nextLine();

        // درخواست آدرس از کاربر
        System.out.println("address");
        String address = sc.nextLine();

        // بررسی یکتا بودن نام کاربری
        for (Account ac : accounts) {
            if (ac.getUsername().equals(username)) {
                System.out.println("username is already taken"); // پیام خطا در صورت تکراری بودن نام کاربری
                return; // خروج از تابع در صورت تکراری بودن
            }
        }

        // ایجاد یک کاربر جدید و اضافه کردن به لیست حساب‌ها
        User user = new User(username, password, email, phoneNumber, address); // ایجاد شیء کاربر جدید
        accounts.add(user); // اضافه کردن کاربر به لیست حساب‌ها
    }

    /**
     * عملیات ثبت‌نام فروشنده
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void regiserSeller(Scanner sc) {
        // عملیات ثبت‌نام فروشنده

        // درخواست نام کاربری از کاربر و خواندن ورودی
        System.out.println("username");
        // ذخیره نام کاربری وارد شده توسط کاربر
        String username = sc.nextLine();

        // درخواست رمز عبور از کاربر و خواندن ورودی
        System.out.println("password");
        // ذخیره رمز عبور وارد شده توسط کاربر
        String password = sc.nextLine();

        // درخواست ایمیل از کاربر و خواندن ورودی
        System.out.println("email");
        // ذخیره ایمیل وارد شده توسط کاربر
        String email = sc.nextLine();

        // درخواست نام شرکت از کاربر و خواندن ورودی
        System.out.println("companyName");
        // ذخیره نام شرکت وارد شده توسط کاربر
        String companyName = sc.nextLine();

        // بررسی اینکه آیا نام کاربری وارد شده قبلاً توسط کاربر دیگری استفاده شده است یا
        // خیر
        for (Account ac : accounts) {
            // اگر نام کاربری وارد شده با نام کاربری یکی از حساب‌های موجود یکسان باشد
            if (ac.getUsername().equals(username)) {
                // نمایش پیغام خطا که نام کاربری قبلاً استفاده شده است
                System.out.println("username is already taken");
                // خروج از متد بدون انجام عملیات بیشتر
                return;
            }
        }

        // تنظیم شناسه حساب کاربری بر اساس تعداد حساب‌های موجود
        int account_id = accounts.size();

        // ایجاد یک شیء جدید از نوع Seller با اطلاعات وارد شده
        Seller seller = new Seller(username, password, email, account_id, companyName);

        // اضافه کردن حساب فروشنده جدید به لیست حساب‌ها
        accounts.add(seller);
    }

    /**
     * عملیات ثبت‌نام مدیر
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void regiserAdmin(Scanner sc) {
        // عملیات ثبت‌نام مدیر

        // درخواست نام کاربری از کاربر و خواندن ورودی
        System.out.println("username");
        // ذخیره نام کاربری وارد شده توسط کاربر
        String username = sc.nextLine();

        // درخواست رمز عبور از کاربر و خواندن ورودی
        System.out.println("password");
        // ذخیره رمز عبور وارد شده توسط کاربر
        String password = sc.nextLine();

        // درخواست ایمیل از کاربر و خواندن ورودی
        System.out.println("email");
        // ذخیره ایمیل وارد شده توسط کاربر
        String email = sc.nextLine();

        // بررسی اینکه آیا نام کاربری وارد شده قبلاً توسط کاربر دیگری استفاده شده است یا
        // خیر
        for (Account ac : accounts) {
            // اگر نام کاربری وارد شده با نام کاربری یکی از حساب‌های موجود یکسان باشد
            if (ac.getUsername().equals(username)) {
                // نمایش پیغام خطا که نام کاربری قبلاً استفاده شده است
                System.out.println("username is already taken");
                // خروج از متد بدون انجام عملیات بیشتر
                return;
            }
        }

        // تنظیم شناسه حساب کاربری بر اساس تعداد حساب‌های موجود
        int id = accounts.size();

        // ایجاد یک شیء جدید از نوع Admin با اطلاعات وارد شده
        Admin admin = new Admin(username, password, email, id);

        // اضافه کردن حساب مدیر جدید به لیست حساب‌ها
        accounts.add(admin);
    }

    /**
     * ورود کاربر به سیستم بر اساس نام کاربری و رمز عبور
     * 
     * @param username نام کاربری وارد شده توسط کاربر
     * @param password رمز عبور وارد شده توسط کاربر
     * @return شناسه حساب کاربری اگر ورود موفقیت‌آمیز بود و -1 اگر نام کاربری یا رمز
     *         عبور اشتباه است
     */
    public int login(String username, String password) {
        // بررسی هر یک از حساب‌های موجود برای یافتن حسابی که نام کاربری و رمز عبور
        // مطابقت داشته باشد
        for (int i = 0; i < accounts.size(); i++) {
            // در صورتی که نام کاربری و رمز عبور وارد شده با نام کاربری و رمز عبور یکی از
            // حساب‌ها مطابقت داشته باشد
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                // بازگشت شناسه حساب کاربری
                return i;
            }
        }

        // در صورتی که هیچ حسابی با نام کاربری و رمز عبور وارد شده مطابقت نداشته باشد
        return -1; // نام کاربری یا رمز عبور اشتباه است
    }

    /**
     * بازگردانی حساب با شناسه مشخص شده.
     * 
     * @param id شناسه حساب کاربری
     * @return حساب کاربری متناظر با شناسه داده شده
     */
    public Account geAccount(int id) {
        // بازگشت حساب کاربری متناظر با شناسه
        return accounts.get(id);
    }

    /**
     * عملیات اضافه کردن محصول توسط فروشنده.
     * 
     * @param sc        شیء Scanner برای دریافت ورودی‌های کاربر
     * @param seller_id شناسه فروشنده
     */
    public void addProduct(Scanner sc, int seller_id) {
        // گرفتن فروشنده با استفاده از شناسه فروشنده
        Seller seller = (Seller) accounts.get(seller_id); // دریافت شیء فروشنده بر اساس شناسه

        // بررسی تأیید شدن فروشنده
        if (!seller.isApproved()) {
            System.out.println("You are not approved yet!"); // پیام خطا در صورت تأیید نشدن فروشنده
            return; // خروج از تابع در صورت تأیید نشدن فروشنده
        }

        // درخواست نام محصول از کاربر و خواندن ورودی
        System.out.println("Enter the name of the product: ");
        String name = sc.nextLine();

        // درخواست قیمت محصول از کاربر و خواندن ورودی
        System.out.println("Enter the price of the product: ");
        double price = sc.nextDouble();

        // درخواست تعداد محصول از کاربر و خواندن ورودی
        System.out.println("Enter the quantity of the product: ");
        int quantity = sc.nextInt();

        // select category
        System.out.println("Select the category of the product: ");
        for (int j = 0; j < categories_name.size(); j++) {
            System.out.println(j + ". " + categories_name.get(j)); // نمایش دسته‌بندی‌ها به کاربر
        }
        int categoryIndex = sc.nextInt();

        // بررسی معتبر بودن دسته‌بندی انتخابی
        if (categoryIndex >= categories_name.size() || categoryIndex < 0) {
            System.out.println("Invalid category"); // پیام خطا در صورت انتخاب دسته‌بندی نامعتبر
            return; // خروج از تابع در صورت انتخاب دسته‌بندی نامعتبر
        }

        // ایجاد محصول جدید با استفاده از اطلاعات وارد شده
        Product product = new Product(seller_id, name, price, quantity, categories_name.get(categoryIndex)); // ایجاد
                                                                                                             // شیء
                                                                                                             // محصول
                                                                                                             // جدید

        // اضافه کردن محصول به لیست محصولات
        products.add(product); // اضافه کردن محصول به لیست کل محصولات
    }

    /**
     * عملیات تأیید فروشنده توسط مدیر.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void approveSeller(Scanner sc) {
        // نمایش لیست فروشندگان تایید نشده
        System.out.println("Approve Seller \n");
        for (int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i) instanceof Seller) {
                Seller seller = (Seller) accounts.get(i); // دریافت شیء فروشنده
                if (!seller.isApproved()) {
                    System.out.println(i + ". " + seller.getUsername()); // نمایش نام فروشنده در صورت عدم تایید
                }
            }
        }

        // درخواست شناسه فروشنده برای تایید از کاربر و خواندن ورودی
        System.out.println("Enter the id of the seller: ");
        int id = sc.nextInt();

        // بررسی معتبر بودن شناسه فروشنده
        if (id >= accounts.size() || id < 0) {
            System.out.println("Invalid id"); // پیام خطا در صورت شناسه نامعتبر
            return; // خروج از تابع در صورت شناسه نامعتبر
        }

        // تایید فروشنده انتخاب شده
        if (accounts.get(id) instanceof Seller) {
            Seller seller = (Seller) accounts.get(id); // دریافت شیء فروشنده
            seller.setApproved(true); // تنظیم تایید برای فروشنده
        } else {
            System.out.println("Invalid id"); // پیام خطا در صورت شناسه نامعتبر
        }
    }

    /**
     * عملیات ویرایش اطلاعات کاربر توسط کاربر خود یا مدیر.
     * 
     * @param user_id شناسه کاربر که اطلاعات آن ویرایش می‌شود
     * @param sc      شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void editUserInfo(int user_id, Scanner sc) {
        User user = (User) accounts.get(user_id);

        // درخواست نام کاربری جدید و خواندن ورودی
        System.out.println("Enter the new username: ");
        String username = sc.nextLine();
        user.setUsername(username);

        // درخواست ایمیل جدید و خواندن ورودی
        System.out.println("Enter the new email: ");
        String email = sc.nextLine();
        user.setEmail(email);

        // درخواست شماره تلفن جدید و خواندن ورودی
        System.out.println("Enter the new phone number: ");
        String phoneNumber = sc.nextLine();
        user.setPhoneNumber(phoneNumber);

        // درخواست آدرس جدید و خواندن ورودی
        System.out.println("Enter the new address: ");
        String address = sc.nextLine();
        user.setAddress(address);

        // درخواست رمز عبور جدید و خواندن ورودی
        System.out.println("Enter the new password: ");
        String password = sc.nextLine();
        user.setPassword(password);
    }

    /**
     * نمایش منوی اصلی برای کاربر.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     * @return انتخاب کاربر (عدد انتخابی)
     */
    public int munu(Scanner sc) {
        System.out.println("1. Register User");
        System.out.println("2. Register Seller");
        System.out.println("3. Login");
        System.out.println("4. Exit");

        int choice = sc.nextInt();
        sc.nextLine(); // خواندن خط خالی

        return choice;
    }

    /**
     * نمایش منوی فروشنده برای انجام عملیات.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     * @return انتخاب فروشنده (عدد انتخابی)
     */
    public int SellerMenu(Scanner sc) {
        System.out.println("1. Add Product");
        System.out.println("2. Show Info");
        System.out.println("3. Exit");

        int choice = sc.nextInt();
        sc.nextLine(); // خواندن خط خالی

        return choice;
    }

    /**
     * نمایش منوی مدیر برای انجام عملیات مدیریت فروشگاه.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     * @return انتخاب مدیر (عدد انتخابی)
     */
    public int adminMenu(Scanner sc) {
        System.out.println("1. Approve Seller");
        System.out.println("2. Register Admin");
        System.out.println("3. All Account Info");
        System.out.println("4. All Product Info");
        System.out.println("5. Accept Transaction");
        System.out.println("6. Accept Buy");
        System.out.println("7. All Orders Info");
        System.out.println("8. Shop Money");
        System.out.println("9. Exit");

        int choice = sc.nextInt();
        sc.nextLine(); // خواندن خط خالی

        return choice;
    }

    /**
     * نمایش منوی کاربر برای انجام عملیات.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     * @return انتخاب کاربر (عدد انتخابی)
     */
    public int userMenu(Scanner sc) {
        System.out.println("1. Edit User Info");
        System.out.println("2. Increase Wallet");
        System.out.println("3. Buy");
        System.out.println("4. Show Info");
        System.out.println("5. Exit");

        int choice = sc.nextInt();
        sc.nextLine(); // خواندن خط خالی

        return choice;
    }

    /**
     * افزایش موجودی کیف پول کاربر.
     * 
     * @param user_id شناسه کاربر
     * @param sc      شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void increaceWallet(int user_id, Scanner sc) {
        System.out.println("Enter the amount: ");
        double amount = sc.nextDouble(); // دریافت مقدار مبلغ از کاربر

        if (amount > 0) {
            Bank bank = new Bank(amount, user_id); // ایجاد شیء Bank برای ثبت تراکنش
            banks.add(bank); // اضافه کردن تراکنش به لیست تراکنش‌ها
            System.out.println("Wait to accept by admin"); // نمایش پیام انتظار تأیید توسط مدیر
        } else {
            System.out.println("Invalid amount"); // پیام خطای مبلغ نامعتبر در صورت وارد شدن مبلغ منفی یا صفر
        }
    }

    /**
     * انجام فرایند خرید برای کاربر.
     * 
     * @param user_id شناسه کاربر که خرید را انجام می‌دهد
     * @param sc      شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void buy(int user_id, Scanner sc) {
        // گرفتن شیء کاربر از طریق شناسه کاربر
        User user = (User) accounts.get(user_id);

        // حلقه برای نمایش محصولات به کاربر و انتخاب آن‌ها برای خرید
        while (true) {
            // نمایش لیست محصولات به کاربر برای انتخاب
            for (int i = 0; i < products.size(); i++) {
                System.out.println(i + ". " + products.get(i).getName()
                        + " \t " + products.get(i).getPrice() + " \t "
                        + products.get(i).getStockQuantity()
                        + " \t " + products.get(i).getCategory());
            }

            // نمایش گزینه خروج از حلقه
            System.out.println(products.size() + ". Exit ");

            // درخواست و ورود شناسه محصول از کاربر
            System.out.println("Enter the id of the product: ");
            int id = sc.nextInt();

            // بررسی معتبر بودن شناسه محصول و خروج از حلقه در صورت لزوم
            if (id >= products.size() || id < 0) {
                break;
            }

            // درخواست و ورود تعداد محصول مورد نظر از کاربر
            System.out.println("Enter the number of the product: ");
            int number = sc.nextInt();

            // بررسی موجودی کافی محصول برای خرید
            if (number > products.get(id).getStockQuantity()) {
                System.out.println("Not enough stock");
                continue;
            }

            // ایجاد آیتم سفارش و اضافه کردن به سبد خرید کاربر
            OrderItem orderItem = new OrderItem(id, products.get(id).getName(), number, products.get(id).getPrice());
            user.addToCart(orderItem);
        }

        // ایجاد سفارش جدید با استفاده از سبد خرید کاربر و افزودن آن به لیست سفارش‌ها
        Order order = new Order(user.getCart(), user_id);
        orders.add(order);

        // خالی کردن سبد خرید کاربر
        user.clearCart();
    }

    /**
     * پذیرش فرایند خرید و انجام تأیید خرید برای سفارش‌ها.
     * 
     * @param sc شیء Scanner برای دریافت ورودی‌های کاربر
     */
    public void accept_buy(Scanner sc) {
        // نمایش لیست سفارش‌هایی که منتظر تأیید هستند
        for (int i = 0; i < orders.size(); i++) {
            if (!orders.get(i).getStatus()) { // اگر وضعیت سفارش تأیید نشده باشد
                System.out.println(i + ". " + orders.get(i).toString()); // نمایش اطلاعات سفارش
                System.out.println("-------------------------------------\n"); // خط جداکننده
            }
        }

        // درخواست و ورود شناسه خرید از کاربر
        System.out.println("Enter the id of the buy: ");
        int id = sc.nextInt();

        // بررسی معتبر بودن شناسه خرید
        if (id >= orders.size() || id < 0) { // اگر شناسه وارد شده نامعتبر باشد
            System.out.println("Invalid id"); // پیام خطا
        } else {
            // دریافت سفارش انتخاب شده
            Order order = orders.get(id); // دریافت سفارش بر اساس شناسه ورودی
            int userId = order.getUserID(); // دریافت شناسه کاربر مرتبط با سفارش
            User user = (User) accounts.get(userId); // دریافت شیء کاربر مرتبط

            double total = order.getTotalCost(); // محاسبه مجموع هزینه‌های سفارش
            int flag = 1; // نشان‌دهنده موفقیت فرایند

            // بررسی کیفیت مالی کاربر برای پرداخت
            if (total <= user.getWallet()) { // اگر کیف پول کاربر کافی باشد
                // بررسی موجودی کافی محصولات برای سفارش
                for (OrderItem item : order.getProducts()) { // بررسی هر آیتم سفارش
                    int productId = item.getProduct_id(); // شناسه محصول
                    int number = item.getQuantity(); // تعداد محصول

                    if (getProducts().get(productId).getStockQuantity() >= number) { // اگر موجودی کافی باشد
                        continue; // ادامه به آیتم بعدی
                    } else {
                        System.out.println("Not enough stock for product: " // پیام خطا
                                + getProducts().get(productId).getName()); // نمایش نام محصول
                        flag = 0; // نشان دهنده خطا
                        break; // خروج از حلقه
                    }
                }

            } else {
                System.out.println("Not enough money"); // پیام خطا
                flag = 0; // نشان دهنده خطا
            }

            // انجام تأیید خرید و تغییر وضعیت محصولات و مالیات
            if (flag == 1) { // اگر فرایند بدون مشکل انجام شود
                order.setStatus(true); // تغییر وضعیت سفارش به تأیید شده
                for (OrderItem item : order.getProducts()) { // بررسی هر آیتم سفارش
                    int productId = item.getProduct_id(); // شناسه محصول
                    int number = item.getQuantity(); // تعداد محصول

                    // کاهش موجودی محصول
                    products.get(productId).decreaseStock(number);

                    // دریافت اطلاعات فروشنده و محاسبه مالیات‌ها
                    int seller_id = products.get(productId).getSeller_id(); // شناسه فروشنده
                    Seller seller = (Seller) accounts.get(seller_id); // شیء فروشنده

                    double money = products.get(productId).getPrice() * number; // محاسبه مبلغ کل
                    double money_seller = money * 0.9; // محاسبه مبلغ برای فروشنده
                    double money_shop = money * 0.1; // محاسبه مبلغ برای فروشگاه

                    // واریز مبلغ به حساب فروشنده و محاسبه سود کل فروشگاه
                    seller.receivePayment(money_seller); // واریز مبلغ به حساب فروشنده
                    totalProfit += money_shop; // افزودن به سود کل فروشگاه

                    // کم کردن مبلغ از کیف پول کاربر
                    user.chargeWallet(-money);

                    // اضافه کردن محصول به لیست محصولات خریداری شده توسط کاربر
                    user.addToPurchasedProducts(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        // ایجاد یک فروشگاه جدید با نام، آدرس و شماره تماس
        Shop shop = new Shop("MyShop", "www.myshop.com", "1234567890");

        // ایجاد یک شیء Scanner برای خواندن ورودی‌های کاربر
        Scanner sc = new Scanner(System.in);

        // حلقه اصلی برنامه برای نمایش منوی اصلی فروشگاه و پردازش ورودی‌های کاربر
        while (true) {
            // نمایش منوی اصلی و خواندن انتخاب کاربر
            int choice = shop.munu(sc);

            if (choice == 1) {
                // ثبت‌نام کاربر جدید در صورت انتخاب گزینه ۱
                shop.registerUser(sc);
            } else if (choice == 2) {
                // ثبت‌نام فروشنده جدید در صورت انتخاب گزینه ۲
                shop.regiserSeller(sc);
            } else if (choice == 3) {
                // ورود به سیستم در صورت انتخاب گزینه ۳

                // درخواست نام کاربری و رمز عبور از کاربر و خواندن ورودی‌ها
                System.out.println("Enter the username: ");
                String username = sc.nextLine();
                System.out.println("Enter the password: ");
                String password = sc.nextLine();

                // اعتبارسنجی ورود و دریافت شناسه کاربر اگر ورود موفق باشد
                int user_id = shop.login(username, password);
                if (user_id == -1) {
                    System.out.println("Invalid username or password");
                } else {
                    // نمایش پیام ورود موفق به عنوان نام کاربری و نوع حساب
                    System.out.println("Logged in as " + shop.getAccounts().get(user_id).getUsername());
                    Account account = shop.geAccount(user_id);

                    // پردازش عملیات بسته به نوع حساب کاربر

                    // حساب کاربری عادی (User)
                    if (account instanceof User) {
                        System.out.println("user account");
                        while (true) {
                            // نمایش منوی کاربر و خواندن انتخاب کاربر
                            int n = shop.userMenu(sc);
                            if (n == 1) {
                                // ویرایش اطلاعات کاربر در صورت انتخاب گزینه ۱
                                shop.editUserInfo(user_id, sc);
                            } else if (n == 2) {
                                // افزایش موجودی کیف پول در صورت انتخاب گزینه ۲
                                shop.increaceWallet(user_id, sc);
                            } else if (n == 3) {
                                // خرید محصول در صورت انتخاب گزینه ۳
                                shop.buy(user_id, sc);
                            } else if (n == 4) {
                                // نمایش اطلاعات حساب کاربری در صورت انتخاب گزینه ۴
                                System.out.println(account.info(shop.getOrders(), user_id));
                            } else if (n == 5) {
                                // خروج از حساب کاربری در صورت انتخاب گزینه ۵
                                break;
                            }
                        }
                    }

                    // حساب فروشنده
                    else if (account instanceof Seller) {
                        System.out.println("seller account");
                        while (true) {
                            // نمایش منوی فروشنده و خواندن انتخاب کاربر
                            int n = shop.SellerMenu(sc);
                            if (n == 1) {
                                // افزودن محصول جدید در صورت انتخاب گزینه ۱
                                shop.addProduct(sc, user_id);
                            } else if (n == 2) {
                                // نمایش اطلاعات حساب فروشنده در صورت انتخاب گزینه ۲
                                System.out.println(account.info(shop.getProducts()));
                            } else if (n == 3) {
                                // خروج از حساب فروشنده در صورت انتخاب گزینه ۳
                                break;
                            }
                        }
                    }

                    // حساب مدیر
                    else if (account instanceof Admin) { // اگر حساب کاربری از نوع Admin باشد
                        System.out.println("admin account"); // چاپ پیام "admin account"

                        // حلقه اصلی برای نمایش منوی مدیر و انجام عملیات‌های مختلف
                        while (true) {
                            int n = shop.adminMenu(sc); // نمایش منوی مدیر و دریافت انتخاب کاربر

                            if (n == 1) { // اگر کاربر گزینه 1 را انتخاب کرد (تأیید فروشنده)
                                shop.approveSeller(sc); // فراخوانی متد approveSeller برای تأیید فروشنده
                            } else if (n == 2) { // اگر کاربر گزینه 2 را انتخاب کرد (ثبت‌نام مدیر جدید)
                                shop.regiserAdmin(sc); // فراخوانی متد regiserAdmin برای ثبت‌نام مدیر جدید
                            } else if (n == 3) { // اگر کاربر گزینه 3 را انتخاب کرد (نمایش اطلاعات حساب‌ها)
                                // حلقه برای پیمایش و نمایش اطلاعات هر حساب کاربری
                                int id = 0;
                                for (Account ac : shop.getAccounts()) { // برای هر حساب کاربری در لیست حساب‌های فروشگاه
                                    if (ac instanceof User) // اگر حساب کاربری از نوع User باشد
                                        System.out.println(ac.info(shop.getOrders(), id)); // نمایش اطلاعات کاربر
                                    else if (ac instanceof Seller) // اگر حساب کاربری از نوع Seller باشد
                                        System.out.println(ac.info(shop.getProducts())); // نمایش اطلاعات فروشنده
                                    else if (ac instanceof Admin) // اگر حساب کاربری از نوع Admin باشد
                                        System.out.println(ac.info()); // نمایش اطلاعات مدیر
                                    id += 1; // افزایش شناسه حساب کاربری برای نمایش
                                }
                            } else if (n == 4) { // اگر کاربر گزینه 4 را انتخاب کرد (نمایش اطلاعات محصولات)
                                for (Product p : shop.getProducts()) { // برای هر محصول در لیست محصولات فروشگاه
                                    System.out.println(p.toString()); // نمایش اطلاعات محصول
                                }
                            } else if (n == 5) { // اگر کاربر گزینه 5 را انتخاب کرد (نمایش تراکنش‌های مالی)
                                // حلقه برای نمایش موجودی هر تراکنش
                                for (int i = 0; i < shop.banks.size(); i++) {
                                    System.out.println(i + ". " + shop.banks.get(i).getMoney());
                                }
                                System.out.println("Enter the id of the transaction: "); // دریافت شناسه تراکنش از کاربر
                                int id = sc.nextInt();
                                if (id >= shop.banks.size() || id < 0) { // بررسی اعتبار شناسه تراکنش
                                    System.out.println("Invalid id"); // چاپ پیام خطا در صورت نامعتبر بودن شناسه
                                } else {
                                    Bank b = shop.banks.get(id); // دریافت تراکنش با شناسه مشخص شده
                                    int userId = b.getUserID(); // دریافت شناسه کاربر مرتبط با تراکنش
                                    double money = b.getMoney(); // دریافت مبلغ تراکنش
                                    if (money > 0) { // اگر مبلغ تراکنش مثبت باشد (شارژ کیف پول)
                                        User user = (User) shop.accounts.get(userId); // دریافت کاربر مرتبط با تراکنش
                                        user.chargeWallet(money); // شارژ کیف پول کاربر
                                        shop.banks.remove(id); // حذف تراکنش از لیست تراکنش‌ها
                                    }
                                }
                            } else if (n == 6) { // اگر کاربر گزینه 6 را انتخاب کرد (تأیید خرید)
                                shop.accept_buy(sc); // فراخوانی متد accept_buy برای تأیید خرید
                            } else if (n == 7) { // اگر کاربر گزینه 7 را انتخاب کرد (نمایش اطلاعات سفارش‌ها)
                                for (Order order : shop.getOrders()) // برای هر سفارش در لیست سفارش‌های فروشگاه
                                    System.out.println(order.toString()); // نمایش اطلاعات سفارش
                            } else if (n == 8) { // اگر کاربر گزینه 8 را انتخاب کرد (نمایش مجموع درآمد فروشگاه)
                                double shopMoney = shop.getTotalProfit(); // محاسبه مجموع درآمد فروشگاه
                                System.out.println("Shop Money: " + shopMoney); // نمایش مجموع درآمد
                            } else if (n == 9) { // اگر کاربر گزینه 9 را انتخاب کرد (خروج از حساب مدیر)
                                break; // خروج از حلقه اصلی
                            }
                        }
                    }

                }
            } else if (choice == 4) {
                // خروج از برنامه در صورت انتخاب گزینه ۴
                break;
            }
        }

        // بستن شیء Scanner پس از اتمام برنامه
        sc.close();
    }

}
