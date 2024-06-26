package commons;

import java.io.File;

public class GlobalConstants {
    public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
    public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "reportIGImage" + File.separator;
    public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
    public static final long LONG_TIMEOUT = 30;
    public static final long SHORT_TIMEOUT = 5;


}
