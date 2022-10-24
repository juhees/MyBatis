package kr.kwangan2.test.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select(" select sysdate from dual")
	public String getTime(); //인터페이스를 구현할 클래스를 만들어줌
	
	public String getTime2();
	
	
}
