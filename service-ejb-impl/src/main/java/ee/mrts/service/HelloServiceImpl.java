package ee.mrts.servlet;

import ee.mrts.service.HelloService;

import javax.ejb.Stateless;

@Stateless
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello!";
    }
}
