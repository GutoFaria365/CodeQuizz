package org.example.dto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {

    private String firstName;

    private String lastName;

    private String email;
}
