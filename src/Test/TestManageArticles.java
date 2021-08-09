package Test;

import operaciones.ManageArticles;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import clases.Articles;
import operaciones.Factory;

public class TestManageArticles {
	Factory fc = new Factory();
	SessionFactory factory = fc.createFactory();
	ManageArticles MA = new ManageArticles();
	Integer article;
	double priceI;
	String nameList, nameI, descriptionI;
	
	@Test
	public void TestManageArticles() {
		Session session = factory.openSession();
		nameI = "Orange Ball";
		descriptionI = "The best orange ball you will find";
		priceI = 160.5;
		article = MA.addArticles(factory, nameI, descriptionI, priceI);
		List articleList = session.createQuery("FROM Articles c WHERE c.articlesId = " + article).list(); 
        for (Iterator iterator = articleList.iterator(); iterator.hasNext();){
           Articles b = (Articles) iterator.next(); 
           nameList = b.getName();
        }
        assertEquals(nameI, nameList);
	}
}
