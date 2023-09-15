package com.nisum.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Mensaje {

    @JsonProperty(value = "id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;

    @JsonProperty("created")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date created;

    @JsonProperty("modified")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modified;

    @JsonProperty("last_login")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date last_login;

    @JsonProperty("token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @JsonProperty("isactive")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isactive;

    @JsonProperty(value = "mensaje")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mensaje;

    public Mensaje(Builder builder) {
        this.id = builder.id;
        this.created = builder.created;
        this.modified = builder.modified;
        this.last_login = builder.last_login;
        this.token = builder.token;
        this.isactive = builder.isactive;
        this.mensaje = builder.mensaje;
    }

    public static class Builder{
        private UUID id;
        private Date created;
        private String modified;
        private Date last_login;
        private String token;
        private Boolean isactive;
        private String mensaje;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder modified(String modified) {
            this.modified = modified;
            return this;
        }

        public Builder last_login(Date last_login) {
            this.last_login = last_login;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder isactive(Boolean isactive) {
            this.isactive = isactive;
            return this;
        }

        public Builder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public Mensaje builder(){
            return  new Mensaje(this);

        }
    }

}
