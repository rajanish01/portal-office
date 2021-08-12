package com.epex.office.repository;


import com.epex.office.models.OfficeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "office_master")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "office_id", unique = true, nullable = false)
    private String officeId;
    private String email;
    private String phone;
    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;
    @UpdateTimestamp
    @Column(name = "last_modified_on")
    private Date lastModifiedOn;

    public Office(OfficeDTO dto) {
        this.setId(dto.getId());
        this.setCompanyName(dto.getCompanyName());
        this.setOfficeId(dto.getOfficeId());
        this.setEmail(dto.getEmail());
        this.setPhone(dto.getPhone());
        this.setCreatedOn(dto.getCreatedOn());
        this.setLastModifiedOn(dto.getLastModifiedOn());
    }
}
