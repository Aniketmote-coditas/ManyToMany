import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello {
	public static void main(String[] args) throws IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
		EntityManager manager = factory.createEntityManager();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the product details");
		System.out.println("Enter the name of product");
		String pname = bufferedReader.readLine();
		System.out.println("Enter price of product");
		int pprice =Integer.parseInt(bufferedReader.readLine());

		Product product = new Product();
		product.setPname(pname);
		product.setPprice(pprice);

		System.out.println("Enter the User details");
		System.out.println("Enter the name of user");
		String uname = bufferedReader.readLine();

		User user = new User();
		user.setUname(uname);

		List<User> userList = new ArrayList<>();
		userList.add(user);

		List<Product> productlist = new ArrayList<>();
		productlist.add(product);

		product.setUserlist(userList);
		user.setProductList(productlist);

		manager.getTransaction().begin();
		manager.persist(product);
		manager.getTransaction().commit();

	}
}
