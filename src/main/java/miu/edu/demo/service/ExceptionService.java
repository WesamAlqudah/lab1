package miu.edu.demo.service;


import miu.edu.demo.domain.Exception;
import org.springframework.stereotype.Service;

@Service
public interface ExceptionService {
    void save(Exception exception);

}
