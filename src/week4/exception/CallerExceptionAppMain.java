package week4.exception;
import week4.exception.myexception.MyException;
public class CallerExceptionAppMain {

    public static void main(String[] args) throws MyException {

        Caller1 caller1 = new Caller1();
        System.out.println("调用开始");

        caller1.call2Exception();

        System.out.println("调用结束");
    }
}
