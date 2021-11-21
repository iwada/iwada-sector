package io.iwada.controller;

import io.iwada.model.User;
import io.iwada.service.SectorService;
import io.iwada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SectorController {

	private final static String SUCCESS = "Details Updated";

	private UserService userService;
	private SectorService sectorService;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("user", userService.getCurrentUser());
		model.addAttribute("sectorList", sectorService.getSectorList());
		return "index";
	}

	@PostMapping("/save")
	public String save(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		userService.saveCurrentUser(user);
		model.addAttribute("success", SUCCESS);
		return index(model);
	}

	@Autowired
	@Qualifier("userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	@Qualifier("sectorService")
	public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}

}
