package ait.shop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectLogging {

    private final Logger logger = LoggerFactory.getLogger(AspectLogging.class);

//    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.saveProduct(ait.shop.model.dto.ProductDTO))")
//    public void saveProduct() {}
//
//    @Before("saveProduct()")
//    public void beforeSavingProduct(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        logger.info("Method saveProduct of the class ProductServiceImpl called with argument {}", args[0]);
//    }
//
//    @After("saveProduct()")
//    public void afterSavingProduct() {
//        logger.info("Method saveProduct of the class ProductServiceImpl finished its work");
//    }
//
//    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.getById(..))")
//    public void getProductById() {}
//
//    @AfterReturning(
//            pointcut = "getProductById()",
//            returning = "result"
//    )
//    public void afterReturningProductById(Object result) {
//        logger.info("Method getById of the class ProductServiceImpl successfully returned result: {}", result);
//    }
//
//    @AfterThrowing(
//            pointcut = "getProductById()",
//            throwing = "e"
//    )
//    public void exceptionWhileGettingProductById(Exception e) {
//        logger.warn("Method getById of the class ProductServiceImpl threw an exception: {}", e.getMessage());
//    }



//    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.getAllActiveProducts(..))")
//        public void getAllActiveProducts() {}
//
//    @Before("getAllActiveProducts()")
//    public void beforeReturningAllActiveProducts(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        logger.info("Method getAllActiveProducts of the class ProductServiceImpl successfully returned result: {}", Arrays.toString(args));
//    }
//
//    @After("getAllActiveProducts()")
//    public void afterReturningAllActiveProducts() {
//        logger.info("Method getAllActiveProduct of the class ProductServiceImpl finished its work");
//    }


    /* При помощи АОП сделать логирование всех методов сервиса продуктов (при помощи одного поинтката!). Для задания Pointcut использовать ProductServiceImpl .*(..). В лог должно выводиться:
  А. Какой метод и с какими параметрами вызван.
  Б. Какой метод завершил работу.*/
    @Pointcut("execution(* ait.shop.service.ProductServiceImpl.*(..))")
    public void logsForAllProductsServiceMethods() {}

    @Before("logsForAllProductsServiceMethods()")
    public void loggMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method {} called with args: {}", methodName, Arrays.toString(args));
    }

    @After("logsForAllProductsServiceMethods()")
    public void logMethodCompletion(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method {} finished execution", methodName);
    }

    @Pointcut("execution(* ait.shop.service..*(..))")
    public void logsForAllServiceMethods () {}

    @Before("logsForAllServiceMethods()")
    private void methodClassAndArgs(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method {} in class {} called with args {}", methodName, className, Arrays.toString(args));
    }

    @After("logsForAllServiceMethods()")
    private void methodAndClassCompletion(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        logger.info("Method {} of class {} finished execution" , methodName, className);

    }



//    В. Какой метод какого класса успешно вернул результат.


    @Pointcut("execution(* ait.shop.service..*(..))")
    private void methodAndClassWithPositiveResult() {}

    @AfterReturning(
            pointcut = "methodAndClassWithPositiveResult()",
            returning = "result"
    )
    private void logSuccessfulResult(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        logger.info("Method {} of class {} successfully returned result: {}", methodName, className, result);
    }

    //    Г. Какой метод какого класса вызвал ошибку.

    @Pointcut("execution(* ait.shop.service..*(..))")
    private void methodAndClassWithException() {}

    @AfterThrowing(
            pointcut = "methodAndClassWithException()",
            throwing = "e"
    )
    private void exceptionMethodAndClass(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        logger.warn("Method {} of the class {} threw an exception: {}", methodName, className, e.getMessage());
    }

}
