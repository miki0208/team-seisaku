package team.seisaku.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;


public class MainController

{
	@GetMapping("/")
    public String index(Model model) {
//      model("message", "こんにちは");
      return "index";
    }
	  }
