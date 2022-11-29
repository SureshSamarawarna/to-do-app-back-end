package lk.ijse.dep9.entity;

import lk.ijse.dep9.entity.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItem implements SuperEntity {
    private int id;
    private String userName;
    private String description;
    private Status status;
}
