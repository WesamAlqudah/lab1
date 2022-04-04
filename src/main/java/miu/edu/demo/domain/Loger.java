package miu.edu.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Loger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transaction;
    Date datetime;
    double duration;
    @ManyToOne
    @JoinColumn(name = "principle_id")
    @JsonBackReference
    Userr principle;
    String operation;


}
