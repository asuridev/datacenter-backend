package co.com.freesoft.datacenter.common.exceptions;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(){

    }
    public UnauthorizedException(String message) {
        super(message);
    }
}
  