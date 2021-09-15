package com.prashhanth.secuirty.entity.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prashhanth.secuirty.util.seqGenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @GenericGenerator(
    name = "user_seq",
    strategy = "com.prashhanth.secuirty.util.seqGenerator.StringPrefixedSequenceIdGenerator",
    parameters = {
    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "User_"),
    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
    private String userId;
    private String name;
    private String password;
    private String role;
    private boolean isActive;

    @JsonCreator
    public User(@JsonProperty("userId") String userId,@JsonProperty("name")  String name,
                @JsonProperty("password") String password,@JsonProperty("role")  String role, boolean isActive) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }
}
