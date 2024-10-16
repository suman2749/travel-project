package com.hotel.payload;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDTO {
    @JsonIgnore
    private String email;
    private String username;
    private String password;
    private String message;
}
