package edu.uptc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "real_state_types")
public class RealStateType implements Serializable{

    private static final long serialVersionUID = 5442745398170857199L;
    @Id
    @Column(name= "real_state_type_id ")
    private int realStateTypeId;
    @Column(name= "real_state_type")
    @Enumerated(EnumType.ORDINAL)
    private RealStateEnum realStateType;
  

    public RealStateType() {
    }

    public RealStateType(int realStateTypeId) {
        super();
        this.realStateTypeId = realStateTypeId;
    }

    public int getRealStateTypeId() {
        return realStateTypeId;
    }

    public void setRealStateTypeId(int realStateTypeId) {
        this.realStateTypeId = realStateTypeId;
    }
}