package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class EnumClassNameCheckTest {

  @Test
  void verify() {
      JavaCheckVerifier.newVerifier()
        .onFile("src/test/files/Country.java")
        .withCheck(new EnumClassNameCheck())
        .verifyIssues();
    }

  @Test
  public void test() {
    JavaCheckVerifier.newVerifier()
      .onFile("src/test/files/Country.java")
      .withCheck(new EnumClassNameCheck())
      .verifyNoIssues();
  }


}
