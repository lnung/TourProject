package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TourDao;
import model.vo.MemberVO;

public class RegisterUpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		
		MemberVO vo = new MemberVO(password, mail, tel);
		TourDao.getInstance().updateInfo(vo);
		// ������Ʈ���� ���� �߿��� �κ�
		// ���ǿ� ������ ������ �ݵ�� ���ε��ϴ� �κ��� �־���Ѵ�.(��� �ٲ�� ������ �ȹٲ���� )

		return new ModelAndView("registerupdate.jsp");
	}
}