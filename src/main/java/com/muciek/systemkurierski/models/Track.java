/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "tracks")
public class Track {

    private int id;
    private Courier courier;
    private Set<TrackPoint> trackPoints = new HashSet<>();
    private Date created;
    private boolean active;
    private String encodedPoyline;

    @Column(length = 10000,name = "encoded_polyline", nullable = false, updatable = true)
    public String getEncodedPoyline() {
        return encodedPoyline;
    }

    public void setEncodedPoyline(String encodedPoyline) {
        this.encodedPoyline = encodedPoyline;
    }

    @Column(name = "create_date", nullable = false, updatable = false)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "courier_id")
    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
    
    @JsonIgnore
    @OneToMany(mappedBy = "track")
    public Set<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(Set<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
