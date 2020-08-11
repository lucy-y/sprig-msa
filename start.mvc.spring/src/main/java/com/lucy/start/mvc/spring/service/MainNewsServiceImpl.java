package com.lucy.start.mvc.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lucy.start.mvc.spring.vo.News;

@Service
public class MainNewsServiceImpl implements NewsService{

	@Override
	public List<News> getNews() {
		List mainNews = new ArrayList();
		
		News news1 = new News();
		news1.setTitle("title1");
		news1.setContent("content1");
		news1.setDate("2020-08-05 12:57:00");
		news1.setAuthor("lu");
		news1.setType("social");
		
		News news2 = new News();
		news2.setTitle("title2");
		news2.setContent("content2");
		news2.setDate("2020-08-05 12:58:00");
		news2.setAuthor("lu");
		news2.setType("sports");
		
		mainNews.add(news1);
		mainNews.add(news2);
		
		return mainNews;
	}

}
