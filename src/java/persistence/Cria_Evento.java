package persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.evento.entity.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RodrigoCavotre
 */
@WebServlet(urlPatterns = {"/Cria_Evento"})
public class Cria_Evento extends HttpServlet implements Serializable {

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
            out.println("<title>Servlet Cria_Evento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cria_Evento at " + request.getContextPath() + "</h1>");
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
        String nome = request.getParameter("nome");
        String sigla = request.getParameter("sigla");
        String area = request.getParameter("area");
        String org = request.getParameter("organizadora");
        Cria_Evento_DB cn = new Cria_Evento_DB();
        Evento e = new Evento();
        e.setNome(nome);
        e.setSigla(sigla);
        e.setAreaDeConcentracao(area);
        e.setInstituicaoOrganizadora(org);
        Long id = e.getIndex();
        request.setAttribute("index", id);
        
        cn.salva(e);
        


        ServletContext servcontext = request.getServletContext();
        request.setAttribute("mensagem", "Post salvo com sucesso!");
        if (cn.recupera(id) != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/Cadastro_Feito.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher dispatcher = servcontext.getRequestDispatcher("/MostraErro.jsp");
            dispatcher.include(request, response);
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
