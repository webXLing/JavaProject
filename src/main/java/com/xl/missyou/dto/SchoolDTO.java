package com.xl.missyou.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class SchoolDTO {
    @Length(min = 2,max = 4)
    private String name;
}
