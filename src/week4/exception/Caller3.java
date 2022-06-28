package week4.exception;
import week4.exception.myexception.MyException;
import week4.exception.myexception.myRuntimeException;
public class Caller3 {

    public void callThrowRTException() {
        // >> TODO 可以在这里catch异常，然后封装成自己的异常，并增加相应的异常描述
        System.out.println("Caller3.callThrowRTException开始");
        try {
            Object n = null;
            n.toString();
        } catch (Exception ex) {
            throw new myRuntimeException("执行callThrowRTException出错", ex);
        }
        System.out.println("Caller3.callThrowRTException结束");
    }

    public void callThrowException() throws MyException {
        // >> TODO 可以在这里catch异常，然后封装成自己的异常，并增加相应的异常描述
        System.out.println("Caller3.callThrowException开始");
        try {
            Class.forName("com.neverland.Rabbit");
        } catch (ClassNotFoundException ex) {
            throw new MyException("", ex);
        }
        System.out.println("Caller3.callThrowException结束");
    }
}

