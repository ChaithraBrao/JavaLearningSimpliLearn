package com.simpliLearn.phase2.hibernate.web;

import com.simpliLearn.phase2.hibernate.dao.AdminRetriveDao;
import com.simpliLearn.phase2.hibernate.model.Class;
import com.simpliLearn.phase2.hibernate.model.Student;
import com.simpliLearn.phase2.hibernate.model.Subject;
import com.simpliLearn.phase2.hibernate.model.Teacher;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet({"/AdminControllerServlet"})
public class AdminControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminRetriveDao dbRetrieve;
    @Resource(
        name = "jdbc_database"
    )
    private DataSource datasource;

    public void init() throws ServletException {
        super.init();

        try {
            this.dbRetrieve = new AdminRetriveDao(this.datasource);
        } catch (Exception var2) {
            throw new ServletException(var2);
        }
    }

    public AdminControllerServlet() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "CLASSES";
            }

            if (!this.getCookies(request, response) && !command.equals("LOGIN")) {
                response.sendRedirect("/Administrative-Portal/login.jsp");
            } else {
                switch (command) {
                    case "STUDENTS":
                        this.studentsList(request, response);
                        return;
                    case "SUBJECTS":
                        this.subjectList(request, response);
                        return;
                    case "ST_LIST":
                        this.classStudentsList(request, response);
                        return;
                    case "TEACHERS":
                        this.teachersList(request, response);
                        return;
                    case "LOGIN":
                        this.login(request, response);
                        return;
                    case "CLASSES":
                        this.classestList(request, response);
                        return;
                }

                this.classestList(request, response);
            }

        } catch (Exception var5) {
            throw new ServletException(var5);
        }
    }

    private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> students = this.dbRetrieve.getStudents();
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

    private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Teacher> teachers = this.dbRetrieve.getTeachers();
        request.setAttribute("TEACHERS_LIST", teachers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers-list.jsp");
        dispatcher.forward(request, response);
    }

    private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Subject> subjects = this.dbRetrieve.getSubjects();
        request.setAttribute("SUBJECTS_LIST", subjects);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/subjects-list.jsp");
        dispatcher.forward(request, response);
    }

    private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Class> classes = this.dbRetrieve.getClasses();
        request.setAttribute("CLASSES_LIST", classes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/classes-list.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
            Cookie cookie = new Cookie(username, password);
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            this.classestList(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void classStudentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int classId = Integer.parseInt(request.getParameter("classId"));
        String section = request.getParameter("section");
        String subject = request.getParameter("subject");
        List<Student> students = this.dbRetrieve.loadClassStudents(classId);
        request.setAttribute("STUDENTS_LIST", students);
        request.setAttribute("SECTION", section);
        request.setAttribute("SUBJECT", subject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/class-students.jsp");
        dispatcher.forward(request, response);
    }

    private boolean getCookies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean check = false;
        Cookie[] cookies = request.getCookies();
        Cookie[] var8 = cookies;
        int var7 = cookies.length;

        for(int var6 = 0; var6 < var7; ++var6) {
            Cookie cookie = var8[var6];
            if (cookie.getName().equals("admin") && cookie.getValue().equals("admin")) {
                check = true;
                break;
            }
        }

        return check;
    }
}
