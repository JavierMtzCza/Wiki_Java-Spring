package com.wiki.controllers;

import com.wiki.models.user.dtos.UserDTOLogin;
import com.wiki.models.user.dtos.UserDTORegister;
import com.wiki.models.user.dtos.UserDTOTokenResponse;
import com.wiki.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   private UserService userService;

   @PostMapping("/signIn")
   public ResponseEntity<?> signIn(@RequestBody @Valid UserDTORegister userDTORegister) {
      UserDTOTokenResponse response = userService.createUser(userDTORegister);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

   @PostMapping("/logIn")
   public ResponseEntity<?> logIn(@RequestBody @Valid UserDTOLogin userDTOLogin) {
      UserDTOTokenResponse response = userService.loginUser(userDTOLogin);
      return ResponseEntity.ok().body(response);
   }
}