package com.study.springrest.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.RestVO;
import com.study.springrest.service.RestService;

@Controller
@RequestMapping( "/rest" )
public class Rest {
	@Inject
	private RestService service;
	
	// /유닛/  목록
	@RequestMapping( value = "", method = RequestMethod.GET )
	public String list( Locale locale, Model model ) {
		List<RestVO> list = service.getList();
		model.addAttribute( "list", list );
		return "list";
	}
	
	
//	@RequestMapping( value = "/detail", method = RequestMethod.GET )
//	public String detail( @RequestParam( "board_no" ) int board_no, Model model ) {
//		RestVO vo = service.get( board_no );
//		model.addAttribute( "vo", vo );
//		return "detail";
//	}
	
	@RequestMapping( value = "/{board_no}", method = RequestMethod.GET )
	public ModelAndView detail( @PathVariable( "board_no") Integer board_no ) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName( "detail" );
		RestVO vo = service.get( board_no );
		aaa.addObject( "vo", vo );	
		return aaa;
	}
	
	// /유닛/new 글쓰기페이지
	@RequestMapping( value = "/new", method = RequestMethod.GET )
	public String write() {
		return "write";
	}
	
	// /유닛/ method = post
	@RequestMapping( value = "", method = RequestMethod.POST )
	public String insert( RestVO vo, Model model ) {
		service.insert( vo );
		return "redirect:/rest";
	}
	
	// detail 삭제
	@RequestMapping( value = "/{board_no}", method = RequestMethod.DELETE )
	public ModelAndView delete( @PathVariable( "board_no") Integer board_no ) {
		service.delete( board_no );
		return new ModelAndView( "redirect:/rest" );
	}
	
	// list 삭제
	@RequestMapping( value = "/delete", method = RequestMethod.POST )
	public String listdelete( @RequestParam( "board_no" ) int board_no, Model model ) {
		service.delete( board_no );
		return "redirect:/rest";
	}
	
	@RequestMapping( value = "/update", method = RequestMethod.POST )
	public String update( @RequestParam( "board_no" ) int board_no, Model model ) {
		RestVO vo = service.get( board_no );
		model.addAttribute( "vo", vo );
		return "update";
	}
	
	@RequestMapping( value = "/update2", method = RequestMethod.POST )
	public String update2( RestVO vo, Model model ) {
		service.update( vo );
		return "redirect:/rest";
	}
}
