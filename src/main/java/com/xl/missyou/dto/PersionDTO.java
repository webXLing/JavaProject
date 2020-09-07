package com.xl.missyou.dto;
// 前端传递给后端的对象
import com.xl.missyou.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@PasswordEqual(min = 1)
public class PersionDTO {
    @NonNull
    private Integer id;

    @Length(min = 2,max = 4)
    private String name;

    @Valid //让schoolDTO 也能去校验 开启级联校验
    private SchoolDTO schoolDTO;
    private String password1;
    private String password2;
}
