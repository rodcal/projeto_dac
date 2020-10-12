/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.evento.entity.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RodrigoCavotre
 */
@WebServlet(name = "Busca_Servlet", urlPatterns = {"/Busca_Servlet"})
public class Busca_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Busca_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Busca_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cria_Evento_DB cn = new Cria_Evento_DB();
        
        List<Evento> eventos = cn.buscaNome(request.getParameter("nome"));
        int k = eventos.size();
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Eventos - Resultado de Consulta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado da consulta para o nome \"" + request.getParameter("nome") + "\"</h1>");
            out.println("<p>Foram encontrados "+ k +" registros de eventos com o nome \"" + request.getParameter("nome") + "\":<p>");

            Iterator<Evento> eventosAsIterator = eventos.iterator();
            while (eventosAsIterator.hasNext()) {
                Evento ent = eventosAsIterator.next();
                out.println("<p> *" + ent.getNome() + ", " + ent.getSigla() + ", " + ent.getAreaDeConcentracao()+ ", " + ent.getInstituicaoOrganizadora()+ "\"</p>");
            }
            out.println("<p><a href=\"http://localhost:8080/Projecto_DAC/Busca_Evento.jsp\">Nova consulta</a></p>");
            out.println("<p><a href=\"http://localhost:8080/Projecto_DAC/index.html\">Página Inicial</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
