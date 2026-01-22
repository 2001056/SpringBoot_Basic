package com.beyond.basic.b2_board.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorUpdatePwDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
