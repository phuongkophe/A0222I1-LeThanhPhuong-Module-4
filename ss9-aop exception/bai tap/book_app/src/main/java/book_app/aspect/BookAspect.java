package book_app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    private int count = 0;

    @Pointcut(value = "execution(* book_app.service.LibraryCardService.save(..))")
    public void saveLog() {};
    @Pointcut(value = "execution(* book_app.service.LibraryCardService.deleteById(..))")
    public void deleteLog() {};
    @Pointcut(value = "execution(* book_app.service.BookService.*(..))")
    public void log() {};

    @AfterReturning("saveLog() || deleteLog()")
    public void getLog(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        System.out.println("Book status is changed");
    }

    @Before("log()")
    public void allLog(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
         count++;
        System.out.println("View: " + count);
    }

}
