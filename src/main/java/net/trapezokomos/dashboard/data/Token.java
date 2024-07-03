package net.trapezokomos.dashboard.data;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Token extends AbstractEntity {

  @Column(
    name = "token", unique = true
  )
  public String token;

  @Enumerated(EnumType.STRING)
  @Column(
      name = "token_type", nullable = false
  )
  public TokenType tokenType;

  @Column(
      name = "revoked", nullable = false
  )
  public boolean revoked;

  @Column(
      name = "expired", nullable = false
  )
  public boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  public User user;
}
