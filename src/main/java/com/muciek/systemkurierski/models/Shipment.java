/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "shipment")
public class Shipment {
    
    private int id;
    private Recipient recipient;
    private User user;
    private PackageOption packageOption;
    private Set<PackageStatus> packageStatuses = new HashSet<PackageStatus>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "packageOption_id")
    public PackageOption getPackageOption() {
        return packageOption;
    }

    public void setPackageOption(PackageOption packageOption) {
        this.packageOption = packageOption;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
    public Set<PackageStatus> getPackageStatuses() {
        return packageStatuses;
    }

    public void setPackageStatuses(Set<PackageStatus> packageStatuses) {
        this.packageStatuses = packageStatuses;
    }
}