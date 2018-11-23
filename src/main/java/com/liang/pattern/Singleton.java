package com.liang.pattern;

/**
* @author lianghaiyang
* @date 2018/09/19
*/
public enum Singleton implements MySingleton {
   /**
    *  单例模式的实例
    */
   INSTANCE {
       @Override
       public void doSomething() {
           System.out.println("complete singleton");
       }
   };

   public static MySingleton getInstance() {
       return Singleton.INSTANCE;
   }
}
