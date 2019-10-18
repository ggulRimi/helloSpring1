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
@RequestMapping("/board/") //url��û��  /board/�� �����ϴ� ���� ���⼭ ó���Ѵ�. ex) board/abc , board/123 board/create
public class BoardController {
    
    @Inject
    private BoardService service;
    
    @RequestMapping(value="create",method=RequestMethod.GET)
    public void createGET(BoardVO board, Model model) throws Exception{
        System.out.println(" /board/create �Դϴ�. GET���");
    }
    
    @RequestMapping(value = "create",method=RequestMethod.POST )
    public String createPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
        System.out.println("/board/create POST��� �Դϴ�.");
        System.out.println(board.toString());
        
        service.create(board);
        
        //return "/board/success";
        rttr.addFlashAttribute("msg", "����");
        return "redirect:/board/listAll";
    }
    
    @RequestMapping(value = "/listAll", method=RequestMethod.GET)
    public void listAll(Model model) throws Exception{
        
        System.out.println("��ü��� ������");
        
        model.addAttribute("boardList", service.listAll());
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public void detail(@RequestParam("b_no")int b_no, Model model) throws Exception{
    	//@RequestParam�� �Ķ���͸� �ޱ����� �뵵��!
    	//�׷��� /board/detail?b_no=40�̶�� ��û�� �޾Ҵٸ� 
    	//b_no�� ���� int�� b_no�� �����~ ��� ����. �� b_no=40�� �Ȱ���!(������)
    	System.out.println("�� ��ȣ"+b_no+"���� �󼼳��� ������");
    	
    	model.addAttribute(service.read(b_no));
    }
 
}


