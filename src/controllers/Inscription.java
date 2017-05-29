package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cart;
import beans.Client;
import dao.CartDao;
import dao.ClientDao;


/**
 * Servlet implementation class inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/inscription.jsp" ).forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		GestionInscription gestionInscription = new GestionInscription();

        // Traitement de la requete et recuperation du bean en résultat
        Client client = null;
		try {
			client = gestionInscription.getClient(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 if (!gestionInscription.hasErrorOccured()) { 
			 if (ClientDao.findSQL(client.getEmail()) == null) {
				 CartDao.insertSQL(new Cart());
				 int id_cart = CartDao.findLastCart();
				 client.setCart(id_cart);
				 if(ClientDao.insertSQL(client) > 0){
					 gestionInscription.setResultat("Inscription has succeeded");
				 }
				 else{
					 CartDao.deleteCart(id_cart);
					 gestionInscription.setResultat("Inscription has failer");
				 }	 
			 }
			 else {
				 gestionInscription.setResultat("A user with this email already exists");
			 }
			 
	        } 
		 request.setAttribute("gestionInscription", gestionInscription);
		 
		 request.getRequestDispatcher("/inscription.jsp").forward(request, response);
		
	}

}