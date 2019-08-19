package de.ellpeck.rockbottom.api.net.login;

import java.util.UUID;

public interface IUserAccount {
    String getUsername();
    UUID getToken();
    boolean isValid();
    boolean renew();
}
