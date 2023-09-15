package com.nisum.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.demo.entity.DTO.PhoneDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "phone")
public class UsuarioPhone {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "usuario_id")
    @NotNull
    private Usuario usuario;

    @Column(name = "number", nullable = false)
    @NotNull
    private String number;

    @Column(name = "citycode", nullable = false)
    @NotNull
    private String cityCode;

    @Column(name = "countrycode", nullable = false)
    @NotNull
    private String countryCode;

    public UsuarioPhone(PhoneDTO oPhoneDTO) {
        this.number = oPhoneDTO.getNumber();
        this.cityCode = oPhoneDTO.getCityCode();
        this.countryCode = oPhoneDTO.getCountryCode();
    }

}
