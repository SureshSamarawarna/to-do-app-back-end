package lk.ijse.dep9.service.custom;

import lk.ijse.dep9.dto.ToDoItemDTO;
import lk.ijse.dep9.service.exception.DuplicateException;
import lk.ijse.dep9.service.exception.InUseException;
import lk.ijse.dep9.service.exception.NotFoundException;

public interface ToDoItemService {

        void createNewToDoItem(ToDoItemDTO dto) throws DuplicateException;

        void updateToDoItem(ToDoItemDTO dto) throws NotFoundException;

        void deleteToDoItem(String memberId) throws NotFoundException, InUseException;

        ToDoItemDTO getToDOItem(String isbn) throws NotFoundException;

        void deleteALLToDoItems(String memberId) throws NotFoundException, InUseException;

}
