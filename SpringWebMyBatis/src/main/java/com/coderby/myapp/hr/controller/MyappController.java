package com.coderby.myapp.hr.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderby.myapp.hr.model.AssignVO;
import com.coderby.myapp.hr.model.EntVO;
import com.coderby.myapp.hr.model.LecVO;
import com.coderby.myapp.hr.model.MemberVO;
import com.coderby.myapp.hr.service.IMyappService;
@Controller
public class MyappController {

private static final Logger logger = LoggerFactory.getLogger(MyappController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	IMyappService myappService;

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale); Date date =
	 * new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * model.addAttribute("key",myappService.getEntCount());
	 * System.out.println(myappService.getEntCount()); String formattedDate =
	 * dateFormat.format(date); model.addAttribute("serverTime", formattedDate );
	 * return "home"; }
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		List<Map<String, Object>> ent = myappService.getListEnt();
		List<Map<String, Object>> assign = myappService.getListAssign();
		System.out.println(assign);
		model.addAttribute("ent", ent);
		model.addAttribute("num", "hihi");
		model.addAttribute("assign", assign);
		return "home";
	}
	
	// ----------list 占쏙옙占�------------
	@RequestMapping(value="/enterprise")
	public String getAllEnt(Model model)
	{
		List<Map<String, Object>>  ent_list = myappService.getListEnt();
		model.addAttribute("ent_list", ent_list); 
		System.out.println(ent_list);
		return "sch/enterprise";
	}
	

	
	@RequestMapping(value="/lecture")
	public String getAllLec(Model model)
	{
		List<Map<String, Object>> lec_list = myappService.getListLec();
		model.addAttribute("lec_list", lec_list);
		List<Map<String, Object>> assign_list = myappService.getListAssign();
		model.addAttribute("assign_list",assign_list);
		return "sch/lecture";
	}
	
	// ------占싹놂옙占쏙옙 占쏙옙占�------------
	@RequestMapping(value="/lecture/{lec_id}")
	public String getIdLec(@PathVariable int lec_id, Model model)
	{
		int seq = myappService.getSeqFromLec(lec_id);
		LecVO lec = myappService.getLecInfo(lec_id, seq);
		model.addAttribute("lec", lec);
		return "sch/detail/lec_detail";
	}
	
	@RequestMapping(value="/enterprise/{ent_id}")
	public String getIdEnt(@PathVariable int ent_id, Model model)
	{
		int seq = myappService.getSeqFromEnt(ent_id);
		EntVO ent = myappService.getEntInfo(ent_id, seq);
		model.addAttribute("ent",ent);
		return "sch/detail/ent_detail";
	}
	
	
	//-------enterprise update, insert
	@RequestMapping(value="/enterprise/update")
	public String updateEnt( int ent_id, Model model)
	{
		int seq = myappService.getSeqFromEnt(ent_id);
		model.addAttribute("ent", myappService.getEntInfo(ent_id,seq));
		return "sch/update/update_ent";
	}
	
	@RequestMapping(value="/enterprise/update", method=RequestMethod.POST)
	public String updateEnt( EntVO ent, Model model)
	{	
		
		myappService.updateEnt(ent);
		return "redirect:/enterprise";
	}
	
	@RequestMapping(value="/enterprise/insert")
	public String insertEnt( Model model)
	{
		return "sch/insert/insert_ent";
	}
	
	@RequestMapping(value="/enterprise/insert",method=RequestMethod.POST)
	public String insertEnt(EntVO ent, Model model)
	{
		myappService.insertEnt(ent);
		return "redirect:/enterprise";
	}
	
	//-----------lecture update, insert
	@RequestMapping(value="/lecture/update")
	public String updateLec(int lec_id, Model model)
	{
		int seq = myappService.getSeqFromLec(lec_id);
		model.addAttribute("lec", myappService.getLecInfo(lec_id, seq));
		return "sch/update/update_lec";
	}
	
	@RequestMapping(value="/lecture/update", method=RequestMethod.POST)
	public String updateLec(LecVO lec, Model model)
	{
		myappService.updateLec(lec);
		return "redirect:/lecture";
	}
	
	@RequestMapping(value="/lecture/insert")
	public String insertLec( Model model)
	{
		return "sch/insert/insert_lec";
	}
	

	@RequestMapping(value="/lecture/insert", method=RequestMethod.POST)
	public String insertLec(LecVO lec, Model model)
	{
		myappService.insertLec(lec);
		return "redirect:/lecture";
	}

	//-----------------assignment insert
	
	@RequestMapping(value="/assign/insert")
	public String insertAssign(int lec_id,String lec_name, Model model)
	{
		return "sch/insert/insert_assign";
	}
	

	@RequestMapping(value="/assign/insert", method=RequestMethod.POST)
	public String inserAssign(AssignVO as, Model model)
	{

		myappService.insertAssign(as);
		return "redirect:/lecture";
	}

	//-------------- mypage ----------------

	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String GetMemberInfo(String mem_id, String mem_pw,Model model)
	{
		//model.addAttribute("mem", myappService.getMemberInfo(mem_id, mem_pw));
		model.addAttribute("mem", myappService.getMemberInfo("hello", "hi"));
		return "sch/mypage/mypage";
	}
	
	@RequestMapping(value="/mypage/login")
	public String MypageLogin(MemberVO mem,  Model model)
	{
		model.addAttribute("mem", myappService.getMemberInfo("hello", "hi"));
		return "sch/mypage/mypage_login";
	}
	
	@RequestMapping(value="/mypage/update", method=RequestMethod.GET)
	public String updateMember(String mem_id, String mem_pw, Model model)
	{
		model.addAttribute(myappService.getMemberInfo(mem_id, mem_pw));
		return "sch/update/update_mem";
	}
	
	@RequestMapping(value="/mypage/update", method=RequestMethod.POST)
	public String updateMember(MemberVO mem, Model model)
	{
		myappService.updateMember(mem);
		return "sch/update/update_mem";
	}
	
	
	@RequestMapping(value="/mypage/delete", method=RequestMethod.GET)
	public String deleteMember(int lec_id, Model model)
	{
		int seq = myappService.getSeqFromLec(lec_id);
		model.addAttribute("mem",myappService.getLecInfo(lec_id,seq) );
		return "sch/delete/delete_lec";
	}
	
	
	//----------delete------------
	@RequestMapping(value="/lecture/delete", method=RequestMethod.GET)
	public String deleteLecG(int lec_id, Model model)
	{
		int seq = myappService.getSeqFromLec(lec_id);
		model.addAttribute("lec",myappService.getLecInfo(lec_id,seq) );
		return "sch/delete/delete_lec";
	}
	
	@RequestMapping(value="/lecture/delete", method=RequestMethod.POST)
	public String deleteLec(int lec_id, Model model)
	{
		int seq = myappService.getSeqFromLec(lec_id);
		myappService.deleteLec(lec_id,seq);
		return "redirect:/lecture";   
	}

	@RequestMapping(value="/assign/delete", method=RequestMethod.GET)
	public String deleteAssignG(int lec_id, String asign_name, Model model)
	{
		model.addAttribute("assign",myappService.getAssignInfo(lec_id, asign_name) );
		return "sch/delete/delete_as";
	}
	
	@RequestMapping(value="/assign/delete", method=RequestMethod.POST)
	public String deleteAssign(int lec_id, String asign_name, Model model)
	{ 
		myappService.deleteAssign(lec_id, asign_name);
		return "redirect:/lecture";
	}


	@RequestMapping(value="/enterprise/delete", method=RequestMethod.GET)
	public String deleteEntG(int ent_id, Model model)
	{
		int seq = myappService.getSeqFromEnt(ent_id);
		model.addAttribute("ent",myappService.getEntInfo(ent_id,seq));
		return "sch/delete/delete_ent";
	}
	
	@RequestMapping(value="/enterprise/delete", method=RequestMethod.POST)
	public String deleteEnt(int ent_id, Model model)
	{
		int seq = myappService.getSeqFromEnt(ent_id);
		myappService.deleteEnt(ent_id,seq);
		return "redirect:/enterprise";
	}
	
	//----------Login------------
	
	@RequestMapping(value="/member/login")
	public String login(Model model)
	{
		return "sch/login/login";
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		logger.info("post login");
		HttpSession session = req.getSession();
		
		String mem_id = member.getMem_id();
		String mem_pw = member.getMem_pw();

		List<Map<String, Object>> list = myappService.getListMember();
		MemberVO login = null;
		
		for (Map<String, Object> map : list) {
			if(map.get("mem_id").equals(mem_id)) {
				login = myappService.getMemberInfo(mem_id, mem_pw);				
			}
		}
		
		System.out.println(login);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		}else {
			session.setAttribute("member", login);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/register", method = RequestMethod.GET)
	public String register() throws Exception{
		
		return "sch/login/register";
	}
	
	@RequestMapping(value = "/member/register", method = RequestMethod.POST)
	public String registerMember(MemberVO member) throws Exception{
		
		myappService.insertMember(member);
		
		return "redirect:/member/login";
	}

}
