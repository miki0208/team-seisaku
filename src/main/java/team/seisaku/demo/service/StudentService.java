package team.seisaku.demo.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.seisaku.demo.model.Student;
import team.seisaku.demo.repository.StudentRepository;
 
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
    
    public List<Student> filterStudents(Integer entYear, String classNum, boolean isAttend) {
        return studentRepository.findByEntYearAndClassNumAndIsAttend(entYear, classNum, isAttend);
    }
}
