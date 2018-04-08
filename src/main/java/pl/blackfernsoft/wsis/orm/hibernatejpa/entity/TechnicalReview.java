package pl.blackfernsoft.wsis.orm.hibernatejpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TechnicalReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date nextReview;

    @Enumerated(EnumType.STRING)
    private TechnicalReviewResultEnum result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car car;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getNextReview() {
        return nextReview;
    }

    public void setNextReview(Date nextReview) {
        this.nextReview = nextReview;
    }

    public TechnicalReviewResultEnum getResult() {
        return result;
    }

    public void setResult(TechnicalReviewResultEnum result) {
        this.result = result;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "TechnicalReview{" +
                "id=" + id +
                ", date=" + date +
                ", nextReview=" + nextReview +
                ", result=" + result +
                ", car=" + (car != null ? car.getName() : "null") +
                '}';
    }
}
