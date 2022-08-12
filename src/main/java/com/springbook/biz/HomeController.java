package com.springbook.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class HomeController {

	@Autowired
	UserService us;
	@Autowired
	BoardService bs;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {



		return "login";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest req, Model model) {
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(pwd);
		
		UserVO user = us.getUser(vo);
		
		if(user != null) {
			model.addAttribute("user",user.getId());
			System.out.println("컨트롤러1");
			try {
				System.out.println("컨트롤러2");
				List<BoardVO> boardList = bs.getBoardList();
				for(BoardVO list : boardList) {
					model.addAttribute("list",list);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "getBoardList";
		} else {
			return "login";
		}
	}
	@RequestMapping(value = "/getBoard.do", method = RequestMethod.GET)
	public String getBoard(HttpServletRequest req, Model model) {
		

		
		
		return "getBoard";
	}
	@RequestMapping(value = "/getBoardList.do", method = RequestMethod.POST)
	public String getBoardList(HttpServletRequest req, Model model) {
		
		String searchCondition = req.getParameter("searchCondition");
		String searchKeyword = req.getParameter("searchKeyword");
		
		
		return "getBoardList";
	}

}
