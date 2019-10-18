package org.hello.controller;
 
import javax.inject.Inject;

import org.hello.domain.BoardVO;
import org.hello.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
@RequestMapping("/board/") //url요청이  /board/로 시작하는 것은 여기서 처리한다. ex) board/abc , board/123 board/create
public class BoardController {
    
    @Inject
    private BoardService service;
    
    @RequestMapping(value="create",method=RequestMethod.GET)
    public void createGET(BoardVO board, Model model) throws Exception{
        System.out.println(" /board/create 입니다. GET방식");
    }
    
    @RequestMapping(value = "create",method=RequestMethod.POST )
    public String createPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
        System.out.println("/board/create POST방식 입니다.");
        System.out.println(board.toString());
        
        service.create(board);
        
        //return "/board/success";
        rttr.addFlashAttribute("msg", "성공");
        return "redirect:/board/listAll";
    }
    
    @RequestMapping(value = "/listAll", method=RequestMethod.GET)
    public void listAll(Model model) throws Exception{
        
        System.out.println("전체목록 페이지");
        
        model.addAttribute("boardList", service.listAll());
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public void detail(@RequestParam("b_no")int b_no, Model model) throws Exception{
    	//@RequestParam은 파라미터를 받기위한 용도임!
    	//그래서 /board/detail?b_no=40이라고 요청을 받았다면 
    	//b_no의 값을 int형 b_no에 담아줘~ 라는 뜻임. 즉 b_no=40이 된거임!(정수형)
    	System.out.println("글 번호"+b_no+"번의 상세내용 페이지");
    	
    	model.addAttribute(service.read(b_no));
    }
 
}


