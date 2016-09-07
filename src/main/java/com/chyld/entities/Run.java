package com.chyld.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="runs")
@Data
public class Run {
    private int id;
    private Date startTime;
    private Date stopTime;
    private int version;
    private Date created;
    private Date modified;
    private Device device;
    private List<Position> positions;

    public Run(){
        positions = new ArrayList<>();
    }

    public Run(Date startTime, Date stopTime){
        this();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="start_time", nullable = false)
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name="stop_time")
    public Date getStopTime() {
        return stopTime;
    }
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name="device_id")
    @JsonIgnore
    public Device getDevice() {return device;}
    public void setDevice(Device device) { this.device = device;}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "run")
    public List<Position> getPositions() {return positions;}
    public void setPositions(List<Position> positions) {this.positions = positions;}
}
