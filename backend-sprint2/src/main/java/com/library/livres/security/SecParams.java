package com.library.livres.security;

public interface SecParams {
    long EXP_TIME = 10 * 24 * 60 * 60 * 1000L;
    String SECRET = "bibliotheque@secret2025";
    String PREFIX = "Bearer ";
}
