//package com.project.watchfun.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.watchfun.dto.Cast;
//
//import com.project.watchfun.repository.CastRepository;
//
//
//@Service
//public class CastService {
//
//	@Autowired
//	private CastRepository castRepository;
//	
//	public List<Cast> getSingleCast() {
//		List<Cast> cast= new ArrayList<>();
//		castRepository.findAll().forEach(cast::add);
//	 return cast;
//	}
//	
//	
//}
