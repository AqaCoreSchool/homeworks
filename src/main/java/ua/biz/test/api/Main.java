package ua.biz.test.api;

public class Main {
    public static void main(String[] args) {
        Api api = new Api();
        api.init();
        api.saveEmployeeWorkExperience();
        api.getEmployeeWorkExperience();
        api.deleteEmployeeWorkExperience();
    }
}
