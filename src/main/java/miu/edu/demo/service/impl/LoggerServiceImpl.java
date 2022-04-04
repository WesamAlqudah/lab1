package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Loger;
import miu.edu.demo.repo.LogerRepo;
import miu.edu.demo.service.LogerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoggerServiceImpl implements LogerService {

    @Autowired
    private LogerRepo logerRepo;

    @Override
    public void save(Loger logger) {
        logerRepo.save(logger);
    }
}
