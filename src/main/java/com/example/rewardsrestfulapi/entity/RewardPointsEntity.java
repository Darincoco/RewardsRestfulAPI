//package com.example.rewardsrestfulapi.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "rewards_point")
//public class RewardPointsEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "customer_id")
//    private long customerId;
//
//    @Column(name = "`month`")
//    private int month;
//
//    @Column(name = "`year`")
//    private int year;
//
//    @Column(name = "points")
//    private double points;
//
//    public RewardPointsEntity() {
//    }
//
//    public RewardPointsEntity(long id, long customerId, int month, int year, double points) {
//        this.id = id;
//        this.customerId = customerId;
//        this.month = month;
//        this.year = year;
//        this.points = points;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(long customerId) {
//        this.customerId = customerId;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public void setMonth(int month) {
//        this.month = month;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public double getPoints() {
//        return points;
//    }
//
//    public void setPoints(double points) {
//        this.points = points;
//    }
//
//    @Override
//    public String toString() {
//        return "RewardPointsEntity{" +
//                "id=" + id +
//                ", customerId=" + customerId +
//                ", month=" + month +
//                ", year=" + year +
//                ", points=" + points +
//                '}';
//    }
//}
