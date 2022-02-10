package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

@Rule(key = "ChineseNamingCheck")
public class ChineseNamingCheck extends BaseTreeVisitor implements JavaFileScanner {

  private JavaFileScannerContext context;

  @Override
  public void scanFile(JavaFileScannerContext javaFileScannerContext) {
    this.context = context;
    scan(context.getTree());
  }

  @Override
  public void visitClass(ClassTree tree) {
    String name = tree.simpleName().name();
    if (name.getBytes().length != name.length()) {
      context.reportIssue(this,tree,"Chinese naming is not allowed here");
    }
  }

  @Override
  public void visitMethod(MethodTree tree){
    String name = tree.simpleName().name();
    if (name.getBytes().length != name.length()) {
      context.reportIssue(this,tree,"Chinese naming is not allowed here");
    }
  }
}
