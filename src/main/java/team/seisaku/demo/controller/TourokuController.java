package team.seisaku.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import team.seisaku.demo.model.Student;
import team.seisaku.demo.service.StudentService;
@Controller
public class TourokuController {
	@Autowired
    private StudentService studentService;
	// 全生徒を取得
	@GetMapping("/gakuseikannri")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getStudentList();
        model.addAttribute("students", students);
        return "gakuseikannri";
	}
	
	@PostMapping("/gakuseikannri")
	public String filterStudents(Model model, @ModelAttribute("filterModel") Student student) {
	    List<Student> filteredStudents = studentService.filterStudents(student.getEntYear(), student.getClassNum(), student.getIsAttend());
	    model.addAttribute("students", filteredStudents);
	    return "gakuseikannri";
	}

	  @GetMapping("/gakuseitouroku")
	  public String add(Model model)  {
	      model.addAttribute("student", new Student());
	     
	      return "Gakuseitouroku";
	    }
	  
	  @PostMapping("/gakuseitouroku")
		public String saveStudent(Model model, @ModelAttribute("studentModel") Student student) {
	    	try {
				studentService.save(student);
	        	return "redirect:/gakuseikannri";
	    	} catch(Exception e){
	        	System.out.println("エラーが発生しました：" + e.getMessage());
	        	return "redirect:/gakuseitouroku";
	    	}

	    }
	  @GetMapping("/edit/{id}")
	  public String editStudent(@PathVariable Long id, Model model) {
	      Student student = studentService.getStudentById(id);
	      model.addAttribute("student", student);
	      return "Hensyu";
	  }

	  @PostMapping("/update")
	  public String updateStudent(@ModelAttribute("student") Student student) {
	      studentService.save(student);
	      return "redirect:/gakuseikannri";
	  }
	  @GetMapping("/delete/{id}")
		public String deleteStudent(@PathVariable("id") Long id, Model model) {
		    Student student = studentService.getStudentById(id);
		    student.setIsAttend(null);
		    studentService.save(student);
		    //studentService.deleteStudent(id);
		    return "redirect:/gakuseikannri";
		}
	 

}