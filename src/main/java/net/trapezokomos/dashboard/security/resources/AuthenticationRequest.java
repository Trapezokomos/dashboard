package net.trapezokomos.dashboard.security.resources;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
  private String email;
  private String password;
}
