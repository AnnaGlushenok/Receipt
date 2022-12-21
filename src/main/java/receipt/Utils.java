package receipt;

public class Utils {
    public static final String FILENAME_REGEX = "([a-zA-Z0-9\\s_;,#\\$%\\^&\\*\\/\\\\.\\-\\(\\):])+(\\..+)$";
    public static final String HAT_RECEIPT = "%28s\n%30s\n%35s\n%30s\n%-10s%14s%10s\n%30s%-9s";
    public static final String BODY_HAT = "%3s %5s%16s %8s";
    public static final String BODY = "%2d  %-17s %8s %9s";
    public static final String FOOTER_RECEIPT = "TAXABLE TOT. %27s\nDISCOUNT%4d%%%27s\nTOTAL %34s";
    public static final int LINE_LENGTH = 40;
    public static final int DISCOUNT = 10;
    public static final int COUNT_PRODUCTS_FOR_DISCOUNT = 5;
    public static final String CURRENCY = "$";
    public static final String SINGLE_LINE = "-";
    public static final String DOUBLE_LINE = "=";
    public static final String DASH_SPLITERATOR = "-";
    public static final String SPACE_SPLITERATOR = " ";
    public static String convertExpenses(int number) {
        return String.format("%d.%02d", number / 100, number % 100);
    }
}
