package de.ellpeck.rockbottom.api.net.login;

import java.util.UUID;

public interface IUserAccount {
    String getUsername();

    UUID getUUID();
    UUID getToken();
    UUID getServerToken();

    boolean isValid();
    boolean renew();

    void cache();
}
