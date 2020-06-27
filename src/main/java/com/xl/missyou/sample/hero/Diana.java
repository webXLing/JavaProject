package com.xl.missyou.sample.hero;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class Diana {
   public Diana(){
       System.out.println("Diana");
   }
  public  void q(){
        System.out.println("Q");
    }
}
