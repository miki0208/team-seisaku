package team.seisaku.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.seisaku.demo.model.GakuseiHyou;

@Repository
public interface GakuseiRepository  extends JpaRepository<GakuseiHyou, Long>{

}


