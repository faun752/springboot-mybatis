package dev.sb.mb.mapper;

import dev.sb.mb.model.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface StudentMapper {

    List<Student> selectAll();

    Student selectByPrimaryKey(Long id);

    int insert(Student record);

    int updateByPrimaryKey(Student record);

    int deleteByPrimaryKey(Long id);
}
