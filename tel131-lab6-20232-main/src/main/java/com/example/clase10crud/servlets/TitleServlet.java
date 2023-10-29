package com.example.clase10crud.servlets;

import com.example.clase10crud.beans.Title;
import com.example.clase10crud.daos.TitleDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "TitleServlet", value = "/TitleServlet")
public class TitleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null? "lista":request.getParameter("action");
        TitleDao titleDao = new TitleDao();

        switch (action){
            case "lista":
                ArrayList<Title> list = titleDao.list();
                //mandar la lista a la vista -> job/lista.jsp
                request.setAttribute("lista",list);
                RequestDispatcher rd = request.getRequestDispatcher("title/lista.jsp");
                rd.forward(request,response);


                break;
            case "new":
                request.getRequestDispatcher("title/form_new.jsp").forward(request,response);
                break;
            case "del":
                String idd = request.getParameter("id");
                Title title = TitleDao.buscarPorId(idd);

                if(title != null){
                    try {
                        titleDao.borrar(idd);
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/JobServlet");
                break;

        }


        //TODO: complete
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        TitleDao titleDao = new TitleDao();
        String action = request.getParameter("action") == null? "crear":request.getParameter("action");

        switch (action){
            case "crear":
                String titleEmp_no = request.getParameter("titleEmp_no");
                String titleTitle = request.getParameter("titleTitle");
                String titleFromDate = request.getParameter("titleFromDate");
                String titleToDate = request.getParameter("titleToDate");

                boolean isAllValid = true;

                if(titleTitle.length()>50){
                    isAllValid = false;
                }

                if(isAllValid){
                    TitleDao.crear(titleEmp_no, titleTitle, titleFromDate,titleToDate);
                }else{
                    request.getRequestDispatcher("title/form_new.jsp").forward(request,response);
                }
                break;

        }


    }
}
