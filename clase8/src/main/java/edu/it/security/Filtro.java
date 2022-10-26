package edu.it.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class Filtro extends OncePerRequestFilter {
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain next)
			throws ServletException, IOException {
		
		try {
			if ("/api/login".equals(request.getRequestURI())) {
				next.doFilter(request, response);
				return;
			} 
			
			var posibleToken = request.getHeader("x-security-token");
			if (posibleToken == null) {
				throw new RuntimeException("Lo echo del API");
			}
			
			try {
				JWTUtil.validarToken(posibleToken);
			}
			catch (io.jsonwebtoken.SignatureException ex) {
				salirPorForbidden("Error en la firma", response);
				return;
			}
			catch (io.jsonwebtoken.ExpiredJwtException ex) {
				salirPorForbidden("El token ha expirado", response);
				return;
			}
			catch (io.jsonwebtoken.MalformedJwtException ex) {
				salirPorForbidden("token mal formateado", response);
				return;
			}
			catch (Exception ex) {
				System.out.println("*************************************");
				ex.printStackTrace();
				System.out.println("*************************************");
				throw new RuntimeException("Lo echo del API");
			}

			SecurityContextHolder.clearContext();
			
			ArrayList<String> authorities = new ArrayList<String>();
			
			authorities.add((String)JWTUtil.obtenerKey(posibleToken, "roles"));
			
			for (String s : authorities) {
				System.out.println(s);
			}
			
			UsernamePasswordAuthenticationToken auth =
	                new UsernamePasswordAuthenticationToken(
	                        "NA", null,
	                        authorities.stream()
	                                .map(SimpleGrantedAuthority::new)
	                                .collect(Collectors.toList()));
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			System.out.println("Entra al filtro");
			next.doFilter(request, response);
		}
		catch (Exception ex) {
			salirPorForbidden("", response);
		}
	}
	private void salirPorForbidden(String mensaje, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED + " " +mensaje);
    }
}
