package com.revature.ers.util;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.text.RandomStringGenerator;

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
    RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').build();
    this.token = generator.generate(20);
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
