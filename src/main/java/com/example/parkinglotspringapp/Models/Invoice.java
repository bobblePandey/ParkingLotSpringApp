package com.example.parkinglotspringapp.Models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Invoice extends BaseModel{

    @OneToOne
    private Ticket parkingTicket;

    private Date parkingEndTime;

    private float finalPayableAmount;

    @Enumerated
    private InvoicePaymentStatus paymentStatus;


    public int calculateAmount() {
        return 0;
    }

}
