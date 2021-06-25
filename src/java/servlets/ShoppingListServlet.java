/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author 854276
 */
public class ShoppingListServlet extends HttpServlet {

    private ArrayList<String> itemList = new ArrayList<String>();
       private HttpSession session; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String action = request.getParameter("action");

    
           session = request.getSession();
          //  HttpSession usernameSession = (HttpSession) session.getAttribute("sessoion");
if(action != null)
{
        if (action.equals("logout")) {
            session.invalidate();
            itemList.clear();
       //     session = request.getSession();
        }
}

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         session = request.getSession();
        String regName = request.getParameter("registerName");
        session.setAttribute("username", regName);

        String itemEntered = request.getParameter("itemName");
        String action = request.getParameter("action");
        String button = request.getParameter("buttons");

        if (action == null) {
            request.setAttribute("itemIsAdded", false);
        } else if (action.equals("Add")) {

            request.setAttribute("itemIsAdded", true);
            itemList.add(itemEntered);
            session.setAttribute("itemsInList", itemList);

        } else if (action.equals("Delete")) {

            request.setAttribute("itemIsAdded", true);
            for (int i = 0; i < itemList.size(); i++) {
                if (button.equals(itemList.get(i))) {
                    itemList.remove(i);
                }
            }
      }
        //else if (action.equals("logout")) {
//            session.invalidate();
//            session = request.getSession();
//        } 
        
   

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
