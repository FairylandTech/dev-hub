/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 17:12:51 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo1;

/**
 * @author Lionel Johnson
 */
public class Chef extends People {
    public Chef() {
    }
    
    public Chef(String jobId, String name, double salary) {
        super(jobId, name, salary);
    }
    
    @Override
    public void work() {
        System.out.println("厨师在炒菜");
    }
}
