package miu.edu.demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Loger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transaction;
    Date date;
    double time;
    int principle;
    String operation;

}
