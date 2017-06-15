package com.revature.ers.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.abstractj.kalium.crypto.Random;

/**
 * A class for randomly generated temporary password reset tokens.
 * @author Eric
 */
public class TemporaryToken {
  private static final Duration LIFESPAN = Duration.ofHours(1);
  
  private String recipient;
  private String token;
  private LocalDateTime creationTimestamp;
  private LocalDateTime expirationTimestamp;
  
  public TemporaryToken(String email) {
    this.recipient = email;
    Random rando = new Random();
    this.token = new String(rando.randomBytes());
    this.creationTimestamp = LocalDateTime.now();
    this.expirationTimestamp = this.creationTimestamp.plus(LIFESPAN);
  }
  
  public String getRecipient() { return recipient; }

  public String getToken() { return token; }
  
  public LocalDateTime getCreationTimestamp() { return creationTimestamp; }
  
  public LocalDateTime getExpirationTimestamp() { return expirationTimestamp; }
  
  public boolean verify(String inputToken, String email) {
    return (this.isExpired() && this.token.equals(inputToken) && this.recipient.equals(email));
  }
  
  private boolean isExpired() { return LocalDateTime.now().isAfter(expirationTimestamp); }
}
