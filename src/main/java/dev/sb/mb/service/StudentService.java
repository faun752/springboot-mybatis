package dev.sb.mb.service;

import dev.sb.mb.mapper.*;
import dev.sb.mb.model.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@Transactional
@Service
public class StudentService {
    private final StudentMapper mapper;

    public List<Student> selectAll() {
        return mapper.selectAll();
    }

    public Student selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void save(Student student) {
        if (student.getId() == null) {
            mapper.insert(student);
        } else {
            mapper.updateByPrimaryKey(student);
        }
    }

    public void deleteByPrimaryKey(Long id) {
        mapper.deleteByPrimaryKey(id);
    }
}
