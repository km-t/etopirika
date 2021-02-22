package spring.aop;


import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import spring.persistence.entity.Shop;

@Aspect
@Component
public class MyAop {

    /*@Before("execution(* *..*service.*.get*(..))")
    public void before(JoinPoint jp) {
        System.out.println("before");
        Signature sig = jp.getSignature();
        System.out.println("method name is " + sig.getName());
    }

    @After("execution(* *..*service.*.get*(..))")
    public void after(JoinPoint jp) {
        System.out.println("after");
        Signature sig = jp.getSignature();
        System.out.println("method name is " + sig.getName());
    }*/

    @AfterReturning(value="execution(* *..*service.*.get*(..))", returning="shopList")
    public void afterReturning(JoinPoint jp, List<Shop> shopList) {
        System.out.println("after returning");
        Signature sig = jp.getSignature();
        System.out.println("method name is " + sig.getName());
        for(Shop s: shopList) {
            System.out.println(s);
        }
    }

    @AfterThrowing(value="execution(* *..*service.get*(..) throws Exception)", throwing="ex")
    public String exceptionThrowing(JoinPoint jp, Exception ex) {
        Signature sig = jp.getSignature();
        System.out.println("Throwing Exception (method name is " + sig.getName() + ")");
        return "/error/";
    }
}
