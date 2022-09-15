package membership;

import java.util.regex.Pattern;

public class NaverException {
	
	
	// 아이디 확인
	public void idFormat(String str) throws AuthenException{
		
		if(str.length() < 5 || str.length() > 15) {
			throw new AuthenException("5 ~ 15자 이내의 아이디만 가능합니다.");
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if((ch > 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if(ch >= '0' && ch <= '9')
				cnt2++;
		}
		
		if(cnt1 == 0 || cnt2 == 0)
			throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요");
		
	}
	
	//비밀번호 확인
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = 0; i < pw1.length(); i++) {
			char ch = pw1.charAt(i);
			if((ch > 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if(ch >= '0' && ch <= '9')
				cnt2++;
		}
		
		if(cnt1 == 0 || cnt2 == 0)
			throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요");
		
		if(!pw1.equals(pw2))
			throw new AuthenException("비밀번호가 다릅니다.");
	}
	
	//성별 확인
	public void genCheck(String gender) throws AuthenException{
		if(!gender.equals("남") && !gender.equals("여")) {
			throw new AuthenException("성별을 정확하게 입력해주세요. 예 '남'");
		}
	}
	
	//이름 확인
	public void namCheck(String name) throws AuthenException{
		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
		if (!check)
			throw new AuthenException("한글이름을 입력해주세요.");

	}
	
	//전화번호 확인
	public void phoneCheck(String phone) throws AuthenException {
		boolean check = Pattern.matches(
				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);
		if (!check)
			throw new AuthenException("XXX-XXXX-XXXX 형식으로 전화번호를 입력해주세요");

	}
	
	public void addressCheck(String address) throws AuthenException {
		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", address);
		if (!check)
			throw new AuthenException("한글로 주소를 입력해주세요.");
	}
	
	public void nickCheck(String nick) throws AuthenException {
		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", nick);
		if (!check)
			throw new AuthenException("한글로 닉네임을 입력해주세요.");
	}
	
	

}

