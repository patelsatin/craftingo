package com.caftingo.models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "AuthRequest{}";
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
