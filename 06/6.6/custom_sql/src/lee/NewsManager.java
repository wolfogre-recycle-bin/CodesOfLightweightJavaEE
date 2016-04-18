package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;

import org.crazyit.app.domain.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class NewsManager
{
	public static void main(String[] args) throws Exception
	{
		// ʵ����Configuration�����д���Ĭ�ϼ���hibernate.cfg.xml�ļ�
		Configuration conf = new Configuration().configure();
		// ��Configurationʵ������SessionFactoryʵ��
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// ʵ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
//		// ������Ϣʵ��
//		News n = new News();
//		// ������Ϣ�������Ϣ����
//		n.setTitle("���Java���˳�����");
//		n.setContent("���Java���˳����ˣ�"
//			+ "��վ��ַhttp://www.crazyit.org");
//		// ������Ϣ
//		sess.save(n);
		News n2 = (News)sess.get(News.class, 1);
		System.out.println(n2.getTitle());
		n2.setContent("aaaaaaaa");
		// �ύ����
		tx.commit();
		// �ر�Session
		sess.close();
	}
}