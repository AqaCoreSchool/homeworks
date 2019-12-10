package desingpatterns.facade;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClientInfo {

    private String name;
    private String address;
}
