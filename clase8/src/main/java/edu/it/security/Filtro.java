package edu.it.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class Filtro extends OncePerRequestFilter {
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain next)
			throws ServletException, IOException {
		
		try {
			if ("/login".equals(request.getRequestURI())) {
				next.doFilter(request, response);
				return;
			} 
			
			var posibleToken = request.getHeader("x-security-token");
			if (posibleToken == null) {
				throw new RuntimeException("Lo echo del API");
			}
			
			System.out.println("Entra al filtro");
			next.doFilter(request, response);
		}
		catch (Exception ex) {
			salirPorForbidden(response);
		}
	}
	private void salirPorForbidden(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED + " Usuario no identificado");
    }
}
