package desingpatterns.chainofresponsibility;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

@Value
@Builder
public class User {

    private String name;
    private String password;
    private boolean isAvailable;

    public void setAvailable(boolean isAvailable) {
        isAvailable = isAvailable;
    }
}
