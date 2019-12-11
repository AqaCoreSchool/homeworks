package desingpatterns.chainofresponsibility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPool {

    private static UserPool instance;
    private List<User> users;

    private UserPool() {
        users = new ArrayList<>();
        User user1 = new User.UserBuilder().name("QA").password("1111").isAvailable(true).build();
        User user2 = new User.UserBuilder().name("DEV").password("2222").isAvailable(true).build();
        users.addAll(Arrays.asList(user1, user2));
    }

    public User getAvailableUser() {
        User user = users.stream()
                .filter(User::isAvailable)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("No available users were found."));
        // Set false for isAvailable
        return user;
    }

    public static UserPool getInstance() {
        if (instance == null) {
            synchronized (UserPool.class) {
                if (instance == null) {
                    instance = new UserPool();
                }
            }
        }
        return instance;
    }
}
