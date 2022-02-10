package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import java.nio.charset.StandardCharsets;

public class LimitMethodRowsTest {

  @Test
  void verify() {
    JavaCheckVerifier.newVerifier()
      .onFile("src/test/files/LimitMethodRowsTest.java")
      .withCheck(new LimitMethodRows())
      .verifyIssues();
  }

  @Test
  void test2(){
    String str = "test汉字";
    if (str.getBytes().length == str.length()) {
      System.out.println("无汉字");
    } else {
      System.out.println("有汉字");
    }
  }

  @Test
  public void test() {
    JavaCheckVerifier.newVerifier()
      .onFile("src/test/files/LimitMethodRowsTest.java")
      .withCheck(new LimitMethodRows())
      .verifyNoIssues();
  }
}
