package de.ellpeck.rockbottom.api.net.login;

import java.util.UUID;

public interface IUserAccount {
    String getUsername();

    UUID getToken();
    UUID getServerToken();

    boolean isValid();
    boolean renew();

}
