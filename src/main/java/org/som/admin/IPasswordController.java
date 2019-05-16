package org.som.admin;

import org.springframework.http.MediaType;
import org.som.bean.PasswordFormBean;
import org.som.bean.UserFormBean;
import org.som.security.resource.IPathAdmin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IPasswordController extends IPathAdmin
{
	@PostMapping
	@RequestMapping(value = CHANGE_PASSWORD)
	ResponseEntity<?> changePassword(PasswordFormBean password);
	
	@PostMapping
	@RequestMapping(value = FORGOT_PASSWORD)
	ResponseEntity<?> forgotPassword(UserFormBean user);

	@PostMapping
	@RequestMapping(value = RESET_PASSWORD, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> resetPassword(PasswordFormBean pfBean);

}