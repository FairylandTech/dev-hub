/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 11:22:29 UTC+08:00
 ****************************************************/
package com.fairyland.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Address {
    private String province;
    private String city;
    
    public Address() {
    }
    
    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }
    
    public String getProvince() {
        return province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        Address address = (Address) o;
        
        return new EqualsBuilder().append(province, address.province).append(city, address.city).isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(province).append(city).toHashCode();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("province", province)
                .append("city", city)
                .toString();
    }
}
