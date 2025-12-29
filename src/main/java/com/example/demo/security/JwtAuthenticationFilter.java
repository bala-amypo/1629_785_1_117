// package com.example.demo.security;

// import jakarta.servlet.*;
// import jakarta.servlet.http.*;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import java.io.IOException;

// @Component
// @RequiredArgsConstructor
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtUtil jwtUtil;
//     private final CustomUserDetailsService userService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request,
//                                     HttpServletResponse response,
//                                     FilterChain filterChain) throws ServletException, IOException {

//         String header = request.getHeader("Authorization");

//         if(header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);

//             if(jwtUtil.validateToken(token)) {
//                 String email = jwtUtil.getEmail(token);

//                 UserDetails details = userService.loadUserByUsername(email);

//                 UsernamePasswordAuthenticationToken auth =
//                         new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
//                 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//                 SecurityContextHolder.getContext().setAuthentication(auth);
//             }
//         }
//         filterChain.doFilter(request,response);
//     }
// }
