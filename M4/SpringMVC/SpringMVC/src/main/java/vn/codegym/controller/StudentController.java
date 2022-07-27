package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;
import vn.codegym.service.StudentServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public String showList(Model model,
                           ModelMap modelMap){
        List<Student> studentList = studentService.findAll();
//        model.addAttribute("studentList", studentList);
        modelMap.addAttribute("studentList", studentList);

        return "list";
    }

    @GetMapping("/list")
    public ModelAndView showList1(){
        return new ModelAndView("list",
                "studentList", studentService.findAll());
    }

}
