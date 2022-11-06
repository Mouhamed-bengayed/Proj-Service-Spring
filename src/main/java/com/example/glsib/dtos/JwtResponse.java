package com.example.glsib.dtos;

import lombok.Data;

@Data
public class JwtResponse {
    String Token;

    public JwtResponse(String token) {
    }
}
