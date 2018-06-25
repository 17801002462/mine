package com.xlove;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
  
/** 
 *  注：为了避免扫描路径不一致，请将启动类放在Root Package 即 com.cicoding.integration 
 */  
  
@SpringBootApplication  
public class Application {  
  
    public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }
    
}  