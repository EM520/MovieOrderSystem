//package com.elena.casestudy.movieordersystem.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.elena.casestudy.movieordersystem.entity.FavList;
//import com.elena.casestudy.movieordersystem.entity.FavListItem;
//import com.elena.casestudy.movieordersystem.repository.FavListItemRepository;
//import com.elena.casestudy.movieordersystem.repository.FavListRepository;
//import com.elena.casestudy.movieordersystem.repository.MovieRepository;
//import com.elena.casestudy.movieordersystem.repository.MovieRepositoryImpl;
//
//@Service
//public class FavListService {
//	@Autowired
//	private FavListRepository favListRepo;
//	@Autowired
//	private FavListItemRepository favListItemRepo;
//	@Autowired
//	private MovieRepository movieRepo;
//	@Autowired
//	private MovieService movieServ;
//	
//	@SuppressWarnings("deprecation")
//	public FavList addToFavList(Long id,Long userId) {
//		FavList favList = new FavList();
//		FavListItem favListItem = new FavListItem();
//		favListItem.setMovie(movieRepo.getById(id));
//		favList.setUser(null);
//		favList.getItems().add(favListItem);
//		return favListRepo.save(favList);	
//	}
//}
