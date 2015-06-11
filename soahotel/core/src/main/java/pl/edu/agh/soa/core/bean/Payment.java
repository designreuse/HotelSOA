package pl.edu.agh.soa.core.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ala Czyz.
 */
@Entity
@Table(name = "payment")
public class Payment  implements Serializable{

    private static final long serialVersionUID = -4860796672110809073L;

    public Payment() {
    }

    public Payment(Long id, Date dueDate, BigDecimal grossCost,  Status status,Reservation reservation) {
        this.id = id;
        this.reservation = reservation;
        this.grossCost = grossCost;
        this.dueDate = dueDate;
        this.status = status;
    }

    @Id
    @GeneratedValue
    @Column(name = "pay_id")
    private Long id;


    @JoinColumn(name = "pay_res_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Reservation reservation;


    @Column(name="pay_gross_cost")
    private BigDecimal grossCost;

    @Column(name="pay_due_date", nullable=false)
    private Date  dueDate;

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name="pay_status", nullable=false)
    Status status = Status.UNPAID;

    public Reservation getReservation() {
        return reservation;
    }

    public Status getStatus() {
        return status;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public BigDecimal getGrossCost() {
        return grossCost;
    }

    public void setGrossCost(BigDecimal grossCost) {
        this.grossCost = grossCost;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPaid() {
        return this != null  && (status == Status.PAID || status == Status.CANCELED);
    }

    public Long getUserId() {
        return reservation.getAccount().id;
    }

    public enum Status{
        UNPAID,
        PAID,
        PROCESSED,
        OVERDUE,
        CANCELED;
    }
}
