package com.example.parkinglotspringapp.Models;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.Random;

@NoArgsConstructor
@Entity
public class Payment extends BaseModel{

    private float amount;
    private Date timestamp;
    @Enumerated
    private PaymentStatus status;
    private String txnId;
    private PaymentMode mode;


    public Payment(float amount, PaymentMode mode) {
        this.amount = amount;
        this.mode = mode;
        this.status = PaymentStatus.PAYMENT_IN_PROGRESS;
        this.txnId = generateTxnID(System.currentTimeMillis());
        this.timestamp = new Date();
        timestamp.setTime(System.currentTimeMillis());
    }

    private String generateTxnID(long seed) {
        Random r = new Random(seed);

        return "TXN_" + Integer.toString(r.nextInt());
    }
}
