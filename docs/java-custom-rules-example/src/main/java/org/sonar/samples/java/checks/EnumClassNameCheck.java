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

/**
 * 枚举类命名检查
 * 枚举类命名使用Enum结尾
 */
/*
@Rule(key = "EnumClassNameCheck")
public class EnumClassNameCheck extends IssuableSubscriptionVisitor {

 @Override
  public List<Tree.Kind> nodesToVisit() {
    return Collections.singletonList(Tree.Kind.ENUM);
  }

  @Override
  public void visitNode(Tree tree) {
    ClassTree classTree = (ClassTree) tree;
    String className = classTree.simpleName().name();
    String lastName = "Enum";
    //判断类的修饰符是否为enum
    if (classTree.kind().name().equals("ENUM")) {
      //判断类名长度是否小于lastName长度
      if (className.length()<=lastName.length()){
        reportIssue(classTree, "The Name Of Enum Class should end with 'Enum'");
      }else {
        //判断类名长度是否包含lastName
        if (className.indexOf(lastName)!=-1){
          //判断lastName是否在末尾处
          if (!className.endsWith(lastName)){
            reportIssue(classTree, "The Name Of Enum Class should end with 'Enum'");
          }
        }else {
          reportIssue(classTree, "The Name Of Enum Class should end with 'Enum'");
        }
      }
    }
    System.out.println("=========================================");
  }

}*/









@Rule(key = "EnumClassNameCheck")
public class EnumClassNameCheck extends BaseTreeVisitor implements JavaFileScanner {


    private JavaFileScannerContext context;



    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }


   @Override
    public void visitClass(ClassTree tree) {
      String className = tree.simpleName().name();
      String lastName = "Enum";
      //取得所有类中内容
      //String contents = context.getInputFile().contents();
     //判断类的修饰符是否为enum
      if (tree.kind().name().equals("ENUM")) {
        //判断类名长度是否小于lastName长度
        if (className.length()<=lastName.length()){
          context.reportIssue(this, tree, "The Name Of Enum Class should end with 'Enum'");
        }else {
          //判断类名长度是否包含lastName
          if (className.indexOf(lastName)!=-1){
            //判断lastName是否在末尾处
            if (!className.endsWith(lastName)){
              context.reportIssue(this, tree, "The Name Of Enum Class should end with 'Enum'");
            }
          }else {
            context.reportIssue(this, tree, "The Name Of Enum Class should end with 'Enum'");
            System.out.println(1);
          }
        }
      }
      super.visitClass(tree);
    }
}


