package lk.ijse.dep9.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements SuperEntity {
    private String user_name;
    private String full_name;
    private String password;

}
