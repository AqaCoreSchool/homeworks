package selenium.data;

import selenium.common.Utils;

public class UserData {
    public static final String URL = "http://test.biz.ua";

    public static final String USER_LOGIN_NAME = "TestUser08";
    public static final String USER_PASSWORD = "Vfylhfujhf!1";
    public static final String USER_NAME = "Pavlo";
    public static final String USER_LASTNAME = "Hrytsyshyn";
    public static final String USER_OTHER_ID = "08";
    public static final String USER_EMPLOYEE_ID = "20";
    public static final String USER_LICENCE_NO = "104128";
    public static final String USER_LICENCE_EXP_DATE = Utils.getCurrentDate().plusYears(20).toString();
    public static final String USER_BIRTH_DATE = "1998-02-06";
    public static final String USER_NATION = "Ukr";
    public static final String USER_MARITAL = "Sin";
    public static final String USER_EMAIL = "Sandman22838@gmail.com";
    public static final String USER_CONTACT_NO = "0961234567";

    public static final String IN_NOTE = "Punched in ...";
    public static final String OUT_NOTE = "Punched out ...";

    private UserData() {
    }


}
