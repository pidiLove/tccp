package com.tc.tccp.web.service; 

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tc.tccp.core.entity.Studio;
import com.tc.tccp.core.page.PageParameter;
 
/** 
 * @author wangpei 
 * @version 
 *����ʱ�䣺2016��10��11�� ����6:21:56 
 * ��˵�� 
 */

 public interface StudioService {
	public boolean addStudio(Studio stu);
	public List<Studio> findStudio(String StudioName);//�����ݳ������Ʋ����ݳ���
	public List<Studio> findAllStudioByPage(PageParameter page);//�������е��ݳ���
	public boolean deleteById(int id);// �����ݳ�������ɾ���ݳ���
	public boolean updateStudio(Studio us);//�޸��ݳ���
	//public boolean deleteMany(int []id);//�Զ����id��studio��������ɾ��

}
 