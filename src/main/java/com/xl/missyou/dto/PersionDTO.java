package com.xl.missyou.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class PersionDTO {
    @NonNull
    private Integer id;
    private String name;
}
