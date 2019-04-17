package br.com.ufc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufc.model.Pessoa;

@WebServlet("/adicionaPessoa")
public class AdicionaPessoaServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String time = request.getParameter("time");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTime(time);
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title> Meu primeiro </title>");
		out.println("</head>");
		
		out.println("<body>");
		 out.println("Pessoa" + pessoa.getNome() 
		 + "foi cadastrada com o time " + pessoa.getTime());
		
		out.println("</body>");
		out.println("</html>");
		
		//Pegar os valores do formulário
		//Criar objeto do tipo Pessoa
		//Cadastrar pessoa e mostrar
	}
	
	
	
}
