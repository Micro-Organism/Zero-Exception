package com.zero.exception.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemUserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
}
