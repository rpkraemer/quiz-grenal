package org.devinpf.controller;

import javax.inject.Inject;

import org.devinpf.model.Fan;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class WelcomeFanController {

	private Result result;
	
	/**
	 * @deprecated
	 * CDI Eyes Only
	 */
	public WelcomeFanController() {}

	@Inject
	public WelcomeFanController(Result result) {
		this.result = result;
	}

	@Post("/welcome")
	public void welcome(Fan fan) {
		if (fan.namePresent()) {
			result.include("welcome", String.format("Olá %s", fan.getName()));
			result.include("fan", fan);
		} else {
			result.include("error", "Mensagem de erro");
		}
	}

	@Get("/")
	public void formFan() {
		/* Forwarded to jsp/welcomeFan/formFan.jsp */
	}

}
