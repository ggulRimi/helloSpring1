package org.hello.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hello.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImp implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "org.hello.mapper.BoardMapper";
	
	//�Խ��� �߰�
	@Override
	public void create(BoardVO vo) throws Exception{
		sqlSession.insert(namespace+".insertBoard",vo);
	}
	
	//�Խ��� ����
	@Override
	public List<BoardVO> listAll() throws Exception{
		sqlSession.selectList(namespace+".listBoard");
		return sqlSession.selectList(namespace+".listBoard");
	}
	
	//�Խ��� ��
	@Override
	public BoardVO read(Integer b_no) throws Exception{
		sqlSession.selectOne(namespace+".detailBoard", b_no);
		return null;
	}
	
	//�Խ��� ����
	@Override
	public void delete(Integer b_no) throws Exception{
		sqlSession.delete(namespace+".deleteBoard", b_no);
	}
	
	//�Խ��� ����
	public void update(BoardVO vo) throws Exception{
		sqlSession.update(namespace+".updateBoard", vo);
	}
	
	
	

}
