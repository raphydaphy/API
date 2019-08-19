package de.ellpeck.rockbottom.api.net.login;

import java.util.UUID;

public interface IUserAccount {
    String getUsername();

    UUID getUUID();
    UUID getToken();
    UUID getServerToken();

    boolean isValid();
    boolean renew();

    boolean changePassword(String oldPassword, String newPassword);

    void cache();
}
