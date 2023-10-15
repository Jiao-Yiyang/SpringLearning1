package app;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 1, message = "名字至少一个字符")
    private String firstName;
    @NotNull
    @Size(min = 1, message = "名字至少一个字符")
    private String lastName;
    @Pattern(regexp = "^1([34578])\\d{9}$", message = "无效的手机号码")
    private String phoneNumber;
    @NotBlank(message = "电子邮箱不能为空")
    @Email
    private String emailAddress;

}