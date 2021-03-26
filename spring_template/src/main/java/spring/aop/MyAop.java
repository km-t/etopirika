package spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
	}

	@AfterReturning(value="execution(* *..*service.*.get*(..))", returning="shopList")
	public void afterReturning(JoinPoint jp, List<Shop> shopList) {
		System.out.println("after returning");
		Signature sig = jp.getSignature();
		System.out.println("method name is " + sig.getName());
		for(Shop s: shopList) {
			System.out.println(s);
		}
	}

	@AfterThrowing(value="execution(* *..*.get*(..) throws Exception)", throwing="ex")
	public String exceptionThrowing(JoinPoint jp, Exception ex) {
		Signature sig = jp.getSignature();
		System.out.println("Throwing Exception (method name is " + sig.getName() + ")");
		return "/error/";
	}
	*/

	@AfterThrowing(value="execution(* showHome(..))", throwing="ex")
	public String exceptionThrowingHome(JoinPoint jp, Exception ex) {
		Signature sig = jp.getSignature();
		System.out.println("Throwing Exception (method name is " + sig.getName() + ")");
		ex.printStackTrace();
		return "/error/";
	}
}
