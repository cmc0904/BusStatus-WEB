package com.example.bus.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus<T> {

    private T msgBody;

}