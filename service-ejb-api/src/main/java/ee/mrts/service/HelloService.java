package ee.mrts.service;

import javax.ejb.Remote;

@Remote
public interface HelloService {

    String sayHello();

}
