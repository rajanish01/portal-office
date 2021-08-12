package com.epex.office.models;

import com.epex.office.repository.Office;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfficeDTO {
    private Long id;
    @NotEmpty(message = "Company Name Required !")
    private String companyName;
    @NotEmpty(message = "Office Id Required !")
    private String officeId;
    @Email(message = "Valid Email Required !")
    @NotEmpty(message = "Office Email Can not Be Null/Empty !")
    private String email;
    @Size(min = 4, max = 12, message = "Valid Phone Number Required !")
    private String phone;
    private Date createdOn;
    private Date lastModifiedOn;

    public OfficeDTO(Office office) {
        this.setId(office.getId());
        this.setCompanyName(office.getCompanyName());
        this.setOfficeId(office.getOfficeId());
        this.setEmail(office.getEmail());
        this.setPhone(office.getPhone());
        this.setCreatedOn(office.getCreatedOn());
        this.setLastModifiedOn(office.getLastModifiedOn());
    }
}
